package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai14Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/springjava1/javacore2/bai14")
public class Bai14Controller {
    @Autowired
    private Bai14Service bai14Service;

    @GetMapping
    public ResponseEntity<Set<Integer>> findCommonElements(@RequestParam("numArray1") int[] nums1, @RequestParam("numArray2") int[] nums2){
        return ResponseEntity.ok(bai14Service.findCommonElement(nums1, nums2));
    }
}

