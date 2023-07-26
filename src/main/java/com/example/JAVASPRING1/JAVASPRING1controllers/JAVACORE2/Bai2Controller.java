package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/javacore2/bai2")
public class Bai2Controller {
    @Autowired
    private Bai2Service bai2Service;

    @GetMapping("/add")
    public ResponseEntity<String> add(@RequestParam("country") String name){
        return new ResponseEntity<>(bai2Service.add(name), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<String>> getAll(){
        return new ResponseEntity<>(bai2Service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> check(@RequestParam("country") String name){
        return new ResponseEntity<>(bai2Service.check(name), HttpStatus.OK);
    }

    @GetMapping("/remove")
    public ResponseEntity<String> remove(@RequestParam("country") String name){
        return new ResponseEntity<>(bai2Service.remover(name), HttpStatus.OK);
    }

    @GetMapping("/quantity")
    public ResponseEntity<String> remove(){
        return new ResponseEntity<>(bai2Service.quantity(), HttpStatus.OK);
    }
}
