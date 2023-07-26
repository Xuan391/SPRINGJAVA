package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE4;

import com.example.JAVASPRING1.models.Employee;
import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE4.BangCongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/javacore4/bangcong")
public class BangCongController {
    @Autowired
    private BangCongService bangCongService;

    @GetMapping
    public ResponseEntity<List<Employee>> phanTichBangCong(){
        return ResponseEntity.ok(bangCongService.bangCong());
    }
}
