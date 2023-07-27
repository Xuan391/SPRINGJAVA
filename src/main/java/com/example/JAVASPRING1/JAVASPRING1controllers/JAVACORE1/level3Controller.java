package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE1;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE1.Level3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava1/level3")
public class level3Controller {
    @Autowired
    private Level3Service level3Service;

    @GetMapping("/bai1")
    public ResponseEntity<Integer> bai1(@RequestParam("numArray") int[] nums){
        int result = level3Service.bai1(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai2")
    public ResponseEntity<Integer> bai2(@RequestParam("numArray") int[] nums){
        int result = level3Service.bai2(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai3")
    public ResponseEntity<int[]> bai3(@RequestParam("numArray") int[] nums){
        int[] result = level3Service.bai3(nums);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai4")
    public ResponseEntity<String[]> bai4(@RequestParam("stringArray") String[] strings){
        String[] result = level3Service.bai4(strings);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai5")
    public ResponseEntity<Integer> bai5(@RequestParam("numArray") int[] nums){
        int result = level3Service.bai5(nums);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai6")
    public ResponseEntity<Float> bai6(@RequestParam("numArray1") int[] nums1, @RequestParam("numArray2") int[] nums2){
        float result = level3Service.bai6(nums1, nums2);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/bai7")
    public ResponseEntity<Integer> bai7(@RequestParam("string") String str){
        int result = level3Service.bai7(str);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/bai10")
    public ResponseEntity<String[]> bai10(@RequestParam("stringArray") String[] strings){
        String[] result = level3Service.bai10(strings);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
