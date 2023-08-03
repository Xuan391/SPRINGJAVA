package com.example.JAVASPRING1.javaspring2_controller;

import com.example.JAVASPRING1.javaspring2_services.SQLLevel4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava2/level4")
public class SQLLevel4Controller {
    @Autowired
    private SQLLevel4Service sqlLevel4Service;

    @GetMapping("/bai1")
    public ResponseEntity<String> bai1(){
        sqlLevel4Service.bai1();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai2")
    public ResponseEntity<String> bai2(){
        sqlLevel4Service.bai2();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai3")
    public ResponseEntity<String> bai3(){
        sqlLevel4Service.bai3();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai4")
    public ResponseEntity<String> bai4(){
        sqlLevel4Service.bai4();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai5")
    public ResponseEntity<String> bai5(){
        sqlLevel4Service.bai5();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai6")
    public ResponseEntity<String> bai6(){
        sqlLevel4Service.bai6();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai7")
    public ResponseEntity<String> bai7(){
        sqlLevel4Service.bai7();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai8")
    public ResponseEntity<String> bai8(){
        sqlLevel4Service.bai8();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai9")
    public ResponseEntity<String> bai9(){
        sqlLevel4Service.bai9();
        return ResponseEntity.ok("update successfully");
    }

    @GetMapping("/bai10")
    public ResponseEntity<String> bai10(){
        sqlLevel4Service.bai10();
        return ResponseEntity.ok("update successfully");
    }
}
