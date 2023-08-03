package com.example.JAVASPRING1.javaspring1_services.javacore2;

import com.example.JAVASPRING1.models.SanPhamB8;

import java.util.Map;

public interface Bai8Service {
    String addSanPham(String key, SanPhamB8 newSanPham);
    Map<String, SanPhamB8> getAllSanPham();
    SanPhamB8 findSanPhamByKey(String Key);
    String removeSanPhamByKey(String Key);
    String updateSanPham(String key, SanPhamB8 sanPhamUpdate);
}
