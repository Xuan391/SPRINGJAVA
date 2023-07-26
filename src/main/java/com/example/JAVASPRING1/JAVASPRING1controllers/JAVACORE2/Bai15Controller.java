package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai15Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/javacore2/bai15")
public class Bai15Controller {
    @Autowired
    private Bai15Service bai15Service;

    @GetMapping
    public ResponseEntity<Set<Integer>> showAllElements(@RequestParam("numArray1") int[] nums1, @RequestParam("numArray2") int[] nums2){
        return ResponseEntity.ok(bai15Service.showAllElement(nums1, nums2));
    }
}
