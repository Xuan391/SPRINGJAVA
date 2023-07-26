package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class Bai14ServiceImpl implements Bai14Service {

    @Override
    public Set<Integer> findCommonElement(int[] nums1, int[] nums2) {
        Set<Integer> commonElements = new HashSet<>();

        for(int i=0; i< nums1.length; i++){
            for (int j=0; j< nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    commonElements.add(nums1[i]);
                }
            }
        }
        return commonElements;
    }
}
