package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai11Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/javacore2/bai11")
public class Bai11Controller {
    @Autowired
    private Bai11Service bai11Service;

    @GetMapping("/add")
    public ResponseEntity<String> addWord(@RequestParam("word") String word, @RequestParam("mean") String mean){
        return ResponseEntity.ok(bai11Service.addWord(word, mean));
    }

    @GetMapping("/find")
    public ResponseEntity<String> findWord(@RequestParam("word") String word){
        return ResponseEntity.ok(bai11Service.findWord(word));
    }


}
