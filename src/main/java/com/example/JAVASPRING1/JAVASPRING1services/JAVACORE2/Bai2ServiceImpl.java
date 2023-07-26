package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Bai2ServiceImpl implements Bai2Service{
    private final HashSet<String> countrySet = new HashSet<>();
    @Override
    public String add(String name) {
        countrySet.add(name);
        return "add country successfully";
    }

    @Override
    public Set<String> getAll() {
        return countrySet;
    }

    @Override
    public String check(String name) {
        if (countrySet.contains(name)){
            return  "Quoc gia " + name + " ton tai trong danh sach";
        } else {
           return  "Quoc gia " + name + " khong ton tai trong danh sach";
        }
    }

    @Override
    public String remover(String name) {
        if (countrySet.contains(name)){
            countrySet.remove(name);
            return  "Quoc gia " + name + " da duoc xoa khoi danh sach";
        } else {
            return  "Quoc gia " + name + " khong ton tai trong danh sach";
        }
    }

    @Override
    public String quantity() {
        return " so luong quoc gia la: " + countrySet.size();
    }
}
