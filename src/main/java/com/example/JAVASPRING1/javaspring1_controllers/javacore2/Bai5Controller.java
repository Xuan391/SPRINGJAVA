package com.example.JAVASPRING1.javaspring1_controllers.javacore2;

import com.example.JAVASPRING1.javaspring1_services.javacore2.Bai5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/springjava1/javacore2/bai5")
public class Bai5Controller {
    @Autowired
    private Bai5Service bai5Service;

    @GetMapping
    public ResponseEntity<ArrayList<String>> bai5(@RequestParam("numArray") int[] nums, @RequestParam("target") int target){
        Map<Integer,Integer> result = bai5Service.twoSum(nums, target);
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> i : result.entrySet()){
            list.add("[" + i.getKey() + ", "+ i.getValue()+"]");
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
