package com.example.JAVASPRING1.javaspring1_services.javacore2;

import com.example.JAVASPRING1.models.SanPhamB12;

import java.util.List;

public interface Bai12Service {
    List<SanPhamB12> sortByName();
    List<SanPhamB12> sortByPrice();
    List<SanPhamB12> sortByDate();
    List<SanPhamB12> sortByPriceAndDate();
}
