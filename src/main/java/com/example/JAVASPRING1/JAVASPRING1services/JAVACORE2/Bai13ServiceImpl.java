package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Bai13ServiceImpl implements Bai13Service{
    @Override
    public Set<Integer> findDuplicateElement(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicateElements = new HashSet<>();

        for(int i : nums){
            if(!set.add(i)){
                duplicateElements.add(i);
            }
        }
        return duplicateElements;
    }
}
