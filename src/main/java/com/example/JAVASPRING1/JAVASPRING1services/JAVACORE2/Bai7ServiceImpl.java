package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bai7ServiceImpl implements Bai7Service{
    private final HashMap<String, List<Double>> sinhVienList = new HashMap<>();

    public Bai7ServiceImpl() {
        sinhVienList.put("Hong", List.of(5.0,5.0,8.0,9.0));
        sinhVienList.put("Nhung", List.of(7.0,8.0,9.0,4.0));
        sinhVienList.put("Hanh", List.of(8.0,6.0,7.0,6.0));
    }
    @Override
    public ArrayList<String> diemTBSVList() {
        ArrayList<String> results = new ArrayList<>();
        for(Map.Entry<String,List<Double>> sinhvien: sinhVienList.entrySet()){
            String sinhVienName = sinhvien.getKey();
            List<Double> diems = sinhvien.getValue();
            double TB = diemTB(diems);
           results.add(sinhVienName + " co diem trung binh la: "+ TB);
        }
        return results;
    }
    public static double diemTB (List<Double> diems){
        double sum = 0;
        double TB = 0;

        for(double diem : diems){
            sum += diem;
        }
        TB = sum/diems.size();
        return TB;
    }


}
