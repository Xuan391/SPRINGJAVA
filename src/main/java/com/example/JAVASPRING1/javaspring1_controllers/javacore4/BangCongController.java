package com.example.JAVASPRING1.javaspring1_controllers.javacore4;

import com.example.JAVASPRING1.models.Employee;
import com.example.JAVASPRING1.javaspring1_services.javacore4.BangCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/springjava1/javacore4/bangcong")
public class BangCongController {
    @Autowired
    private BangCongService bangCongService;

    @PostMapping
    public ResponseEntity<List<Employee>> phanTichBangCong(@RequestParam ("fileExcel")MultipartFile file){
        String generatedFileName = bangCongService.storeFile(file);
        return ResponseEntity.ok(bangCongService.bangCong(generatedFileName));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam ("fileExcel")MultipartFile file){
        String generatedFileName = bangCongService.storeFile(file);
        return ResponseEntity.ok("upload file thanh cong: " + generatedFileName);
    }
}
