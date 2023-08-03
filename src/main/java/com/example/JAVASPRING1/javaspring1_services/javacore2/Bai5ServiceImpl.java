package com.example.JAVASPRING1.javaspring1_services.javacore2;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bai5ServiceImpl implements Bai5Service{
    @Override
    public Map<Integer, Integer> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Map <Integer, Integer> result  = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                result.put(map.get(complement), i);
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
