package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/javacore2/bai1")
public class Bai1Controller {
    @Autowired
    private Bai1Service bai1Service;

    @GetMapping("/addElement")
    public ResponseEntity<String> addElement(@RequestParam("element") int i){
        return new ResponseEntity<>(bai1Service.addElement(i), HttpStatus.OK);
    }

    @GetMapping("/sum")
    public ResponseEntity<String> sum(){
        return new ResponseEntity<>(bai1Service.sum(), HttpStatus.OK);
    }

    @GetMapping("/maxMin")
    public ResponseEntity<String> maxMin(){
        return new ResponseEntity<>(bai1Service.maxMin(), HttpStatus.OK);
    }

    @GetMapping("/removeElement")
    public ResponseEntity<String> removeElement(@RequestParam("element") int i){
        return new ResponseEntity<>(bai1Service.remove(i), HttpStatus.OK);
    }

    @GetMapping("/checkElement")
    public ResponseEntity<String> checjkElement(@RequestParam("element") int i){
        return new ResponseEntity<>(bai1Service.checkElement(i),HttpStatus.OK);
    }
}
