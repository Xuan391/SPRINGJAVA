package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE1;

import org.springframework.stereotype.Service;

@Service
public class Level2ServiceImpl implements Level2Service{

    @Override
    public int bai1(int[] nums) {
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j< nums.length ; j++){
                if(nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i]= nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[1];
    }

    @Override
    public String bai2(String[] strings) {
        int strMax = strings[0].length();
        int index = 0;
        for (int i = 0; i<strings.length; i++){
            if(strMax < strings[i].length()){
                strMax = strings[i].length();
                index = i;
            }
        }
        return strings[index];
    }

    @Override
    public String bai3(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength =0;
        int endIndex = 0;

        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(dp[i+1][j+1] > maxLength){
                        maxLength = dp[i+1][j+1];
                        endIndex = i+1;
                    }
                }else{
                    dp[i+1][j+1] =0;
                }
            }
        }
        return str1.substring(endIndex - maxLength, endIndex);
    }

    @Override
    public int bai4(int[] nums) {
        int sum =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] % 15 == 0){
                sum += nums[i];
            }
        }
        return sum;
    }

    @Override
    public int bai5(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i =0; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
