package com.example.JAVASPRING1.JAVASPRING2controller;

import com.example.JAVASPRING1.JAVASPRING2services.SQLLevel1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/springjava2/level1")
public class SQLLevel1Controller {
    @Autowired
    private SQLLevel1Service sqlLevel1Service;

    @GetMapping("/bai1")
    public List<Map<String, Object>> bai1(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return sqlLevel1Service.bai1(pageable);
    }

    @GetMapping("/bai2")
    public List<Map<String, Object>> bai2(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return sqlLevel1Service.bai2(pageable);
    }

    @GetMapping("/bai3")
    public List<Map<String, Object>> bai3(){
        return sqlLevel1Service.bai3();
    }

    @GetMapping("/bai4")
    public List<Map<String, Object>> bai4(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return sqlLevel1Service.bai4(pageable);
    }

    @GetMapping("/bai5")
    public List<Map<String, Object>> bai5(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return sqlLevel1Service.bai5(pageable);
    }

    @GetMapping("/bai6")
    public List<Map<String, Object>> bai6(){
        return sqlLevel1Service.bai6();
    }

    @GetMapping("/bai7")
    public List<Map<String, Object>> bai7(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return sqlLevel1Service.bai7(pageable);
    }

    @GetMapping("/bai8")
    public List<Map<String, Object>> bai8(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return sqlLevel1Service.bai8(pageable);
    }

}
