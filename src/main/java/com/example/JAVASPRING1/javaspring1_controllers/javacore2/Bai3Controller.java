package com.example.JAVASPRING1.javaspring1_controllers.javacore2;

import com.example.JAVASPRING1.javaspring1_services.javacore2.Bai3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/springjava1/javacore2/bai3")
public class Bai3Controller {
    @Autowired
    private Bai3Service bai1Service;

    @GetMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestParam("name") String name, @RequestParam("age") int age){
        bai1Service.addPerson(name, age);
        return new ResponseEntity<>("Add person successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllPersons")
    public ResponseEntity<Map<String,Integer>> getAllPersons(){
        return new ResponseEntity<>(bai1Service.getAllPersons(),HttpStatus.OK);
    }

    @GetMapping("/findAgeByName")
    public ResponseEntity<Integer> findAgeByName(@RequestParam("name") String name){
        return new ResponseEntity<>(bai1Service.findAgeByName(name), HttpStatus.OK);
    }

    @GetMapping("/removePerson")
    public ResponseEntity<String> removePerson(@RequestParam("name") String name){
        return new ResponseEntity<>(bai1Service.removePerson(name), HttpStatus.OK);
    }

    @GetMapping("/checkPerson")
    public ResponseEntity<String> checkPerson(@RequestParam("name") String name){
        return new ResponseEntity<>(bai1Service.checkPerson(name), HttpStatus.OK);
    }

}
