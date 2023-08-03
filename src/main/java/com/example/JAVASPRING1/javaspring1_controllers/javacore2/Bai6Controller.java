package com.example.JAVASPRING1.javaspring1_controllers.javacore2;

import com.example.JAVASPRING1.javaspring1_services.javacore2.Bai6Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava1/javacore2/bai6")
public class Bai6Controller {
    @Autowired
    private Bai6Service bai6Service;

    @GetMapping
    public ResponseEntity<String> bai6(@RequestParam("prices") int[] prices){
        return new ResponseEntity<>(bai6Service.maxProfit(prices), HttpStatus.OK);
    }
}
