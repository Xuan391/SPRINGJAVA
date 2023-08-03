package com.example.JAVASPRING1.javaspring1_services.javacore2;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class Bai15ServiceImpl implements Bai15Service{
    @Override
    public Set<Integer> showAllElement(int[] nums1, int[] nums2) {
        Set<Integer> allElements = new HashSet<>();

        for (int i=0; i< nums1.length; i++){
            allElements.add(nums1[i]);
            for (int j=0; j< nums2.length; j++){
                allElements.add(nums2[j]);
            }
        }
        return allElements;
    }
}
