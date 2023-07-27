package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai161718Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/springjava1/javacore2")
public class Bai161718Controller {
    @Autowired
    private Bai161718Service bai161718Service;

    @GetMapping("/bai16")
    public ResponseEntity<String> bai16(@RequestParam("numArray") int[] nums){
        return ResponseEntity.ok(bai161718Service.bai16(nums));
    }

    @GetMapping("/bai17")
    public ResponseEntity<Set<Integer>> bai17(@RequestParam("numArray") int[] nums){
        return ResponseEntity.ok(bai161718Service.bai17(nums));
    }

    @GetMapping("/bai18")
    public ResponseEntity<String> bai18(@RequestParam("numArray") int[] nums){
        return ResponseEntity.ok(bai161718Service.bai18(nums));
    }
}
