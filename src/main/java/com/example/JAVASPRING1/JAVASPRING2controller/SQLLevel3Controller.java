package com.example.JAVASPRING1.JAVASPRING2controller;

import com.example.JAVASPRING1.JAVASPRING2services.SQLLevel3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("springjava2/level3")
public class SQLLevel3Controller {

    @Autowired
    private SQLLevel3Service sqlLevel3Service;

    @GetMapping("/bai1")
    public List<Map<String, Object>> bai1 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai1(pageable);
    }

    @GetMapping("/bai2")
    public List<Map<String, Object>> bai2(@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai2(pageable);
    }

    @GetMapping("/bai3")
    public List<Map<String, Object>> bai3 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai3(pageable);
    }

    @GetMapping("/bai5")
    public List<Map<String, Object>> bai5 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai5(pageable);
    }

    @GetMapping("/bai6")
    public List<Map<String, Object>> bai6 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai6(pageable);
    }

    @GetMapping("/bai7")
    public List<Map<String, Object>> bai7 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai7(pageable);
    }

    @GetMapping("/bai8")
    public List<Map<String, Object>> bai8 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai8(pageable);
    }

    @GetMapping("/bai9")
    public List<Map<String, Object>> bai9 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai9(pageable);
    }

    @GetMapping("/bai10")
    public List<Map<String, Object>> bai10 (@RequestParam(value = "page", defaultValue = "0") int page,
                                           @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel3Service.bai10(pageable);
    }
}
