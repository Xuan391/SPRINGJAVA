package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE1;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE1.Level1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/level1")
public class level1Controller {
    @Autowired
    private Level1Service level1Service;

    @GetMapping("/bai1")
    public ResponseEntity<Double> bai1(@RequestParam("a") double a, @RequestParam("b") double b) {
        double result = level1Service.bai1(a, b);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai2")
    public ResponseEntity<Integer> bai2(@RequestParam ("string") String str){
        int result = level1Service.bai2(str);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai3")
    public ResponseEntity<Double> bai3(@RequestParam ("a") double a) {
        double result = level1Service.bai3(a);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai4")
    public ResponseEntity<Integer> bai4(@RequestParam ("numArray") int[] nums){
        int result = level1Service.bai4(nums);
        return  new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/bai5")
    public ResponseEntity<String> bai5(@RequestParam ("stringArray") String[] strings){
        String result = level1Service.bai5(strings);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai6")
    public ResponseEntity<int[]> bai6(@RequestParam ("numArray") int[] nums){
        int[] result = level1Service.bai6(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai7")
    public ResponseEntity<String[]> bai7 (@RequestParam ("stringArray") String[] strings){
        String[] result = level1Service.bai7(strings);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/bai8")
    public ResponseEntity<Double> bai8 (@RequestParam ("numArray") double[] nums){
        double result = level1Service.bai8(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai9")
    public ResponseEntity<Integer> bai9(@RequestParam ("string") String str){
        int result = level1Service.bai9(str);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/bai10")
    public  ResponseEntity<Integer> bai10(@RequestParam ("stringArray") String[] strings){
        int result = level1Service.bai10(strings);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
