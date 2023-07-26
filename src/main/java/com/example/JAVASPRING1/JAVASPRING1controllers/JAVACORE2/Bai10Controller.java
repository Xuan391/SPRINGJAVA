package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/javacore2/bai10")
public class Bai10Controller {
    @Autowired
    private Bai10Service bai10Service;

    @GetMapping
    public ResponseEntity<List<String>> bai10(@RequestParam("score") double score){
        return ResponseEntity.ok(bai10Service.scoresCount(score));
    }
}
