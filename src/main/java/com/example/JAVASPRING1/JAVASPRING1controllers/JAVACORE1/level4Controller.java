package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE1;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE1.Level4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava1/level4")
public class level4Controller {
    @Autowired
    private Level4Service level4Service;

    @GetMapping("/bai1")
    public ResponseEntity<Integer> bai1(@RequestParam("numArray") int[] nums){
        int result = level4Service.bai1(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai2")
    public ResponseEntity<Integer> bai2(@RequestParam("numArray") int[] nums, @RequestParam("tager") int tager){
        int result = level4Service.bai2(nums, tager);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai3")
    public ResponseEntity<Integer> bai3(@RequestParam("stringArray") String[] strings){
        int result = level4Service.bai3(strings);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai6")
    public ResponseEntity<Integer> bai6(@RequestParam("numArray") int[] nums){
        int result = level4Service.bai6(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai7")
    public ResponseEntity<String[]> bai7(@RequestParam("stringArray") String[] strings){
        String[] result = level4Service.bai7(strings);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai9")
    public ResponseEntity<Integer> bai9(){
        int result = level4Service.bai9();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai10")
    public ResponseEntity<String> bai10(){
        return new ResponseEntity<>(level4Service.bai10(),HttpStatus.OK);
    }
}
