package com.example.JAVASPRING1.javaspring1_services.javacore1;

import org.springframework.stereotype.Service;

@Service
public class Level3ServiceImpl implements Level3Service{

    @Override
    public int bai1(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j< nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[1];
    }

    @Override
    public int bai2(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int i=0; i<nums.length; i++){
            if(max < nums[i]) max = nums[i];
            if(min > nums[i]) min = nums[i];
        }
        return max - min;
    }

    @Override
    public int[] bai3(int[] nums) {
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];

        int maxLength = 1;
        int endIndex = 0;

        for(int i=0; i< nums.length; i++){
            dp[i] = 1;
            prev[i] = -1;

            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > maxLength){
                maxLength = dp[i];
                endIndex = i;
            }
        }

        int[] longestSubsequence = new int[maxLength];
        int index = maxLength - 1;
        while (endIndex >= 0){
            longestSubsequence[index] = nums[endIndex];
            endIndex = prev[endIndex];
            index --;
        }
        return longestSubsequence;
    }

    @Override
    public String[] bai4(String[] strings) {
        String[] largestOverlapStrings = new String[2];
        int maxOverlap =0;

        for(int i=0; i<strings.length -1; i++){
            String str1 = strings[i];
            for (int j=i+1; j<strings.length; j++){
                String str2 = strings[j];
                int overlap = calculateOverlap(str1, str2);
                if(overlap > maxOverlap) {
                    maxOverlap = overlap;
                    largestOverlapStrings[0] = str1;
                    largestOverlapStrings[1] = str2;
                }
            }
        }
        return largestOverlapStrings;
    }

    public static int calculateOverlap (String str1, String str2){
        int maxOverlap = 0;

        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                int k =0;
                while ((i + k) < str1.length() && j + k < str2.length() && str1.charAt(i + k) == str2.charAt(j + k)) {
                    k++;
                }
                maxOverlap = Math.max(maxOverlap, k);
            }
        }
        return maxOverlap;
    }

    @Override
    public int bai5(int[] nums) {
        int smallest = 1;

        for (int num : nums){
            if(num > smallest){
                break;
            }
            smallest += num;
        }
        return smallest;
    }

    @Override
    public float bai6(int[] nums1, int[] nums2) {
        int[] mergeArray = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, mergeArray, 0, nums1.length);
        System.arraycopy(nums2,0,mergeArray,nums1.length,nums2.length);

        for(int i=0; i<mergeArray.length; i++){
            for(int j=i+1; j< mergeArray.length; j++){
                if(mergeArray[i]>mergeArray[j]) {
                    int temp = mergeArray[i];
                    mergeArray[i] = mergeArray[j];
                    mergeArray[j] = temp;
                }
            }
        }
        if((nums1.length + nums2.length) % 2 ==1){
            return (float) mergeArray[(nums1.length + nums2.length) / 2];
        } else{
            return ((float) mergeArray[(nums1.length+ nums2.length)/2 -1]
                    + (float) mergeArray[(nums1.length+ nums2.length)/2]) /2;
        }
    }

    @Override
    public int bai7(String str) {
        int[] charCount = new int[128];
        int oddCount = 0;
        for (char c : str.toCharArray()){
            charCount[c] ++;
        }

        for(int count : charCount){
            if(count % 2 !=0){
                oddCount ++;
            }
        }

        if(oddCount <=1){
            return str.length();
        } else {
            return str.length() - oddCount + 1;
        }
    }

    @Override
    public String[] bai10(String[] strings) {
        for(int i=0; i<strings.length; i++){
            for(int j =i+1; j<strings.length; j++){
                if (countDistinctCharacters(strings[i]) > countDistinctCharacters(strings[j])){
                    swap(strings,i,j);
                }
            }
        }
        return strings;
    }
    public static int countDistinctCharacters(String str){
        boolean[] visited = new boolean[128];
        int count =0;
        for(char c : str.toCharArray()){
            if(!visited[c]){
                visited[c] = true;
                count++;
            }
        }
        return  count;
    }
    public static void swap(String[] strings, int i, int j){
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }


}
