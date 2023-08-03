package com.example.JAVASPRING1.javaspring2_services;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface SQLLevel3Service {
    List<Map<String, Object>> bai1(Pageable pageable);
    List<Map<String, Object>> bai2(Pageable pageable);
    List<Map<String, Object>> bai3(Pageable pageable);
    List<Map<String, Object>> bai5(Pageable pageable);
    List<Map<String, Object>> bai6(Pageable pageable);
    List<Map<String, Object>> bai7(Pageable pageable);
    List<Map<String, Object>> bai8(Pageable pageable);
    List<Map<String, Object>> bai9(Pageable pageable);
    List<Map<String, Object>> bai10(Pageable pageable);
}
