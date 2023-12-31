package com.example.JAVASPRING1.javaspring1_controllers.javacore2;

import com.example.JAVASPRING1.javaspring1_services.javacore2.Bai4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava1/javacore2/bai4")
public class Bai4Controller {
    @Autowired
    private Bai4Service bai4Service;

    @GetMapping("/sortAsc")
    public ResponseEntity<String> sortAsc(){
        return new ResponseEntity<>(bai4Service.sortAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortDesc")
    public ResponseEntity<String> sortDesc(){
        return new ResponseEntity<>(bai4Service.sortDesc(), HttpStatus.OK);
    }
}
