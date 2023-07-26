package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
@Service
public class Bai161718ServiceImpl implements Bai161718Service{
    @Override
    public String bai16(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        return "Min: "+ Collections.min(set) + ", Max: " + Collections.max(set);
    }

    @Override
    public Set<Integer> bai17(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        return set;
    }

    @Override
    public String bai18(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        return "Số lượng phần tử không trùng lặp: " + set.size();
    }
}
