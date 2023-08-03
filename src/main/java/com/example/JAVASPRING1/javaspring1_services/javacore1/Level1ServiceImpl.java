package com.example.JAVASPRING1.javaspring1_services.javacore1;

import org.springframework.stereotype.Service;

@Service
public class Level1ServiceImpl implements Level1Service {
    @Override
    public double bai1(double a, double b) {
        return a+b;
    }

    @Override
    public int bai2(String str) {
        return str.length();
    }

    @Override
    public double bai3(double a) {
        return a*a;
    }

    @Override
    public int bai4(int[] nums) {
        int max = nums[0];
        for(int i=0; i< nums.length; i++){
            if(max < nums[i]) max = nums[i];
        }
        return max;
    }

    @Override
    public String bai5(String[] strings) {
        int strMin = strings[0].length();
        int index =0;
        for(int i=0; i<strings.length; i++){
            if(strMin > strings[i].length()){
                strMin = strings[i].length();
                index = i;
            }
        }
        return strings[index];
    }

    @Override
    public int[] bai6(int[] nums) {
        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    @Override
    public String[] bai7(String[] strings) {
        for(int i=0; i<strings.length; i++){
            for(int j = i+1; j<strings.length; j++){
                if(strings[i].compareTo(strings[j])>0){
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }

    @Override
    public double bai8(double[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] > nums[j]){
                    double temp = nums[i];
                    nums[j] = nums[i];
                    nums[j] = temp;
                }
            }
        }
        if(nums.length % 2 == 1){
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length/2 - 1] + nums[nums.length/2]) / 2;
        }
    }

    @Override
    public int bai9(String str) {
        int count = 0;
        if(str.charAt(0) != ' ') count = 1;
        for(int i=0; i< str.length(); i++){
            if(str.charAt(i) == ' ' && str.charAt(i+1) !=' '){
                count ++ ;
            }
        }
        return count;
    }

    @Override
    public int bai10(String[] strings) {
        int count =0;
        for(String str : strings){
            if(containA(str)) count ++;
        }
        return count;
    }
    public static boolean containA(String str){
        for (int i=0; i< str.length(); i++){
            if(str.charAt(i) == 'a'){
                return true;
            }
        }
        return false;
    }
}
