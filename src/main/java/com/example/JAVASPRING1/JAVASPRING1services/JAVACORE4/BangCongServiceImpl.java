package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE4;

import com.example.JAVASPRING1.models.AttendanceDay;
import com.example.JAVASPRING1.models.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BangCongServiceImpl implements BangCongService{
    public final String filePath = "excel/BangCong.xlsx";
    @Override
    public List<Employee> bangCong() {
        try {
            List<Employee> employees = analyzeAttendance(filePath);
            return employees;
        } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static List<Employee> analyzeAttendance(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();

        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Trang tính đầu tiên trong tệp Excel

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();

        boolean isFirstDate = true;
        int index = 0; // đánh dấu số thứ tự chỉ cột đầu tiên trong tháng.
        // Loop1 : row 3
        Row row3 = sheet.getRow(3);
        int day = 0;
        for(int i=0; i<=row3.getLastCellNum(); i++){
            Cell cell = row3.getCell(i);
            if(cell!=null && cell.getCellTypeEnum() == CellType.NUMERIC){
                day = (int) cell.getNumericCellValue();
                if(isFirstDate == true){
                    index = i;
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
            double compareAmount = row.getCell(16).getNumericCellValue();
            Employee employee = new Employee();
            employee.setName(name);
            employee.setCompareAmount(compareAmount);
            AttendanceDay attendanceDay = null;
            for (int j = index; j<= row.getLastCellNum(); j++){
                Cell cell = row.getCell(j);
                if(cell != null){
                    if(cell.getCellTypeEnum()==CellType.NUMERIC){
                        double hour =0.0;
                        hour += cell.getNumericCellValue();
                        double amount =0.0;
                        List<String> dayShifts = new ArrayList<>();
                        if(cell.getNumericCellValue() > 0.0){
                            int date = map1.get(j);
                            String shift =  map2.get(j);
                            dayShifts.add(shift);
                            if(map3.containsKey(shift)){
                                int indexMoney = map3.get(shift);
                                double money = row.getCell(indexMoney).getNumericCellValue();
                                amount += hour * money;
                            }

                            attendanceDay = new AttendanceDay(date, hour, dayShifts, amount );
                            if(attendanceDay != null ){
                                attendanceDay = new AttendanceDay(date, hour, dayShifts, amount );
                                employee.addAttendanceDay(attendanceDay);
                            }
                        }
                    }
                }
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
