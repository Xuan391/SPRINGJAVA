package com.example.JAVASPRING1.javaspring2_controller;

import com.example.JAVASPRING1.javaspring2_services.SQLLevel2Service;
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
@RequestMapping("/springjava2/level2")
public class SQLLevel2Controller {

    @Autowired
    private SQLLevel2Service sqlLevel2Service;

    @GetMapping("/bai1")
    public List<Map<String, Object>> bai1(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai1(pageable);
    }

    @GetMapping("/bai2")
    public List<Map<String, Object>> bai2(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai2(pageable);
    }

    @GetMapping("/bai3")
    public List<Map<String, Object>> bai3(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai3(pageable);
    }

    @GetMapping("/bai4")
    public List<Map<String, Object>> bai4(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai4(pageable);
    }

    @GetMapping("/bai5")
    public List<Map<String, Object>> bai5(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai5(pageable);
    }

    @GetMapping("/bai6")
    public List<Map<String, Object>> bai6(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai6(pageable);
    }

    @GetMapping("/bai7")
    public List<Map<String, Object>> bai7(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai7(pageable);
    }

    @GetMapping("/bai8")
    public List<Map<String, Object>> bai8(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai8(pageable);
    }

    @GetMapping("/bai9")
    public List<Map<String, Object>> bai9(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai9(pageable);
    }

    @GetMapping("/bai10")
    public List<Map<String, Object>> bai10(@RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size" , defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return sqlLevel2Service.bai10(pageable);
    }

}
