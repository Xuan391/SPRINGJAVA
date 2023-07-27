package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai13Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/springjava1/javacore2/bai13")
public class Bai13Controller {
    @Autowired
    private Bai13Service bai13Service;

    @GetMapping
    public ResponseEntity<Set<Integer>> duplicateElements(@RequestParam("numArray") int[] nums){
        return ResponseEntity.ok(bai13Service.findDuplicateElement(nums));
    }
}
