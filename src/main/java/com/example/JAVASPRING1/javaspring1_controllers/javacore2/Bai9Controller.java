package com.example.JAVASPRING1.javaspring1_controllers.javacore2;

import com.example.JAVASPRING1.javaspring1_services.javacore2.Bai9Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springjava1/javacore2/bai9")
public class Bai9Controller {
    @Autowired
    private Bai9Service bai9Service;

    @GetMapping
    public ResponseEntity<List<String>> countWord(@RequestParam("text") String text){
        return ResponseEntity.ok(bai9Service.countWords(text));
    }
}
