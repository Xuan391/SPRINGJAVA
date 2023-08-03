package com.example.JAVASPRING1.javaspring1_controllers.javacore1;

import com.example.JAVASPRING1.javaspring1_services.javacore1.Level2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava1/level2")
public class level2Controller {
    @Autowired
    private Level2Service level2Service;

    @GetMapping("/bai1")
    public ResponseEntity<Integer> bai1(@RequestParam ("numArray") int[] nums){
        int result  = level2Service.bai1(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai2")
    public  ResponseEntity<String> bai2(@RequestParam ("stringArray") String[] strings){
        String result = level2Service.bai2(strings);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai3")
    public ResponseEntity<String> bai3(@RequestParam("string1") String str1, @RequestParam("string2") String str2){
        String result = level2Service.bai3(str1, str2);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai4")
    public ResponseEntity<Integer> bai4(@RequestParam("numArray") int[] nums){
        int result = level2Service.bai4(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai5")
    public ResponseEntity<Integer> bai5(@RequestParam("numArray") int[] nums){
        int result = level2Service.bai5(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
