package com.example.JAVASPRING1.javaspring1_services.javacore4;

import com.example.JAVASPRING1.models.AttendanceDay;
import com.example.JAVASPRING1.models.Employee;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class BangCongServiceImpl implements BangCongService{
    private final Path storageFolder = Paths.get("temp");
    public BangCongServiceImpl(){
        try{
            Files.createDirectories(storageFolder);
            File directory = new File("upload/excels");
            System.out.println(directory.exists()); // Kiểm tra xem thư mục có tồn tại hay không
            System.out.println(directory.isDirectory()); // Kiểm tra xem đó có phải là thư mục hay không
            System.out.println(directory.canWrite()); // Kiểm tra quyền ghi
        } catch (IOException exception) {
            throw new RuntimeException("Cannot initialize storage", exception);
        }
    }

    private boolean isExcelFile(MultipartFile file){
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[] {"xlsx"}).contains(fileExtension.trim().toLowerCase());
    }
    @Override
    public String storeFile(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }
            if (!isExcelFile(file)) {
                throw new RuntimeException("You can only upload excel .xlsx file");
            }

            String originalFilename = file.getOriginalFilename();
            String generatedFilename = System.currentTimeMillis() + "_" + originalFilename;
            Path destinationFilePath = this.storageFolder.resolve(Paths.get(generatedFilename)).normalize().toAbsolutePath();
            if (!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
                //this is a security check
                throw new RuntimeException("cannot store file outside current directory");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            } // copy file upload vào destinationFilePath // REPLACE_EXISTING nếu tồn tại thì ghi đè
            System.out.println("Generated Filename: " + generatedFilename);
            return generatedFilename;
        }catch (IOException exception)
        {
            throw new RuntimeException("Failed to store file.",exception);
        }
    }

    @Override
    public List<Employee> bangCong(String fileName) {
        try {
            List<Employee> employees = analyzeAttendance(fileName);
            Path filePath = storageFolder.resolve(fileName);
            Files.deleteIfExists(filePath);
            return employees;
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Employee> analyzeAttendance(String fileName) throws IOException {
        List<Employee> employees = new ArrayList<>();

        Path filePath = Paths.get("temp").resolve(fileName);
        FileInputStream fis = new FileInputStream(filePath.toFile());
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Trang tính đầu tiên trong tệp Excel

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();

        boolean isFirstDate = true;
        int index = 0; // đánh dấu số thứ tự chỉ cột đầu tiên trong tháng.
        int indexQ = 0;
        // Loop1 : row 3
        Row row3 = sheet.getRow(3);
        int day = 0;
        for(int i=0; i<=row3.getLastCellNum(); i++){
            Cell cell = row3.getCell(i);
            if(cell!=null && cell.getCellTypeEnum() == CellType.NUMERIC){
                day = (int) cell.getNumericCellValue();
                if(isFirstDate == true){
                    index = i;
                    indexQ = index -1;
                    isFirstDate = false;
                }
            }
            map1.put(i,day);
        }
//        System.out.println(map1);

        //Loop2 :row5
        Row row5 = sheet.getRow(5);
        String idShift ="";
        for(int i = index; i<= row5.getLastCellNum(); i++ ){
            Cell cell = row5.getCell(i);
            if(cell != null && cell.getCellTypeEnum() == CellType.STRING){
                idShift = cell.getStringCellValue();
            }
            map2.put(i,idShift);
        }
//        System.out.println(map2);

        //Loop3 : row5
        List<String> shifts = new ArrayList<>();
        for (int i=0; i< index ; i++){
            Cell cell = row5.getCell(i);
            if(cell != null && cell.getCellTypeEnum() == CellType.STRING){
                if(cell.getStringCellValue().equals("$")){
                    new ArrayList<>(shifts);
                    for (String shift: shifts){
                        map3.put(shift,i);
                    }
                    shifts.clear();
                }else{
                    String shift = cell.getStringCellValue();
                    shifts.add(shift);
                }
            }
        }
//        System.out.println(map3);

        //loop4: duyet nhan vien
        for (int i =6; i<=9; i++){
            Row row = sheet.getRow(i);
            String name = row.getCell(2).getStringCellValue();
            double compareAmount = row.getCell(indexQ).getNumericCellValue();
            Employee employee = new Employee();
            employee.setName(name);
            employee.setCompareAmount(compareAmount);
            AttendanceDay attendanceDay = null;
            int currentDate = -1; // Biến để lưu trữ ngày hiện tại, khởi tạo bằng giá trị không hợp lệ
            double hour = 0.0;
            double amount = 0.0;
            List<String> dayShifts = new ArrayList<>();
            for (int j = index; j <= row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if(cell!= null) {
                    if (cell.getCellTypeEnum() == CellType.NUMERIC && cell.getNumericCellValue() > 0.0) {
                        int date = map1.get(j); //---
                        if (date != currentDate) {
                            if (attendanceDay != null) {
                                employee.addAttendanceDay(attendanceDay);
                            }
                            hour = 0.0;
                            amount = 0.0;
                            dayShifts = new ArrayList<>();
                            attendanceDay = new AttendanceDay();
                        }

                        String shift = map2.get(j);
                        dayShifts.add(shift); //---
                        double hourCell = cell.getNumericCellValue();
                        hour += hourCell; //---

                        if (map3.containsKey(shift)) {
                            int indexMoney = map3.get(shift);
                            double money = row.getCell(indexMoney).getNumericCellValue();
                            amount += hourCell * money; //---
                        }

                        attendanceDay.setDate(date);
                        attendanceDay.setHours(hour);
                        attendanceDay.setAmount(amount);
                        attendanceDay.setShifts(dayShifts);

                        currentDate = date;

                    }
                }

            }

            // Sau khi kết thúc vòng lặp, thêm attendanceDay cuối cùng vào employee
            if (attendanceDay != null) {
                employee.addAttendanceDay(attendanceDay);
            }
            employees.add(employee);
        }
        workbook.close();
        fis.close();

        return employees;
    }

    public static boolean compareDouble (double num1, double num2, double epsilon){
        return Math.abs(num1-num2) < epsilon;
    }
}
