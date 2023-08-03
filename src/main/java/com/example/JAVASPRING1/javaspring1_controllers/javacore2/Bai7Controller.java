package com.example.JAVASPRING1.javaspring1_controllers.javacore2;

import com.example.JAVASPRING1.javaspring1_services.javacore2.Bai7Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/springjava1/javacore2/bai7")
public class Bai7Controller {
    @Autowired
    private Bai7Service bai7Service;

    @GetMapping
    public ResponseEntity<ArrayList<String>> diemTBSVList(){
        return new ResponseEntity<>(bai7Service.diemTBSVList(), HttpStatus.OK);
    }
}
