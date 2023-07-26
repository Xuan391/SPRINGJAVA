package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE1;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Level4ServiceImpl implements Level4Service {
    @Override
    public int bai1(int[] nums) {
        int count =0;
        for(int i=0; i< nums.length; i++){
            for(int j=i+1; j< nums.length; j++){
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int bai2(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] =1;

        for(int i=0; i<nums.length; i++){
            for(int j = sum; j>= nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

    @Override
    public int bai3(String[] strings) {
        if(strings == null || strings.length == 0){
            return  0;
        }

        String firstString = strings[0];
        int longestSubstring =0;

        for(int i=0; i<firstString.length(); i++){
            for(int j =i+1; j<=firstString.length(); j++){
                String substring = firstString.substring(i,j);
                boolean commonSubstring = true;

                for(int k=1; k<strings.length; k++){
                    if(!strings[k].contains(substring)){
                        commonSubstring =false;
                        break;
                    }
                }
                if(commonSubstring && substring.length()>longestSubstring) {
                    longestSubstring = substring.length();
                }
            }
        }
        return longestSubstring;
    }

    @Override
    public int bai6(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > max1){
                max3=max2;
                max2=max1;
                max1=num;
            } else if(num > max2) {
                max3=max2;
                max2=num;
            }else if (num>max3){
                max3 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }

    @Override
    public String[] bai7(String[] strings) {
        for (int i = 0; i < strings.length ; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                if (countDistinctCharacters(strings[i]) < countDistinctCharacters(strings[j])) {
                    String temp;
                    temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                } else if (strings[i].compareTo(strings[j]) > 0 & countDistinctCharacters(strings[i]) == countDistinctCharacters(strings[j]) ) {
                    // Hoán đổi vị trí
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        return strings;
    }

    public static int countDistinctCharacters(String str) {
        boolean[] visited = new boolean[128];
        int count = 0;

        for (char c : str.toCharArray()) {
            if (!visited[c]) {
                visited[c] = true;
                count++;
            }
        }

        return count;
    }

    @Override
    public int bai9() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 3, 2, 5, 6, 1);
        int longestLength = getLongestIncreasingSubsequence(numbers);
        return longestLength;
    }

    public static int getLongestIncreasingSubsequence(List<Integer> numbers) {
        int n = numbers.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(numbers.get(i) - numbers.get(j)) <= 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longestLength = 0;
        for (int length : dp) {
            longestLength = Math.max(longestLength, length);
        }

        return longestLength;
    }

    @Override
    public String bai10() {
        String[] strings = {"abcdefg", "abcde", "abcdef", "ab", "abc"};
        int k = 2;
        String[] result = getLargestOverlap(strings, k);
        return "Strings with largest overlap: " + result[0] + " and " + result[1];
    }
    public static String[] getLargestOverlap(String[] strings, int k) {
        int maxOverlap = 0;
        String string1 = "";
        String string2 = "";

        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                String[] substrings = getSubstrings(strings[i], k);
                for (String substring : substrings) {
                    if (containsSubstring(strings[j], substring)) {
                        int overlap = strings[j].length() - strings[j].indexOf(substring);
                        if (overlap > maxOverlap) {
                            maxOverlap = overlap;
                            string1 = strings[i];
                            string2 = strings[j];
                        }
                    }
                }
            }
        }

        return new String[]{string1, string2};
    }

    public static String[] getSubstrings(String str, int k) {
        int numSubstrings = str.length() - k + 1;
        String[] substrings = new String[numSubstrings];
        for (int i = 0; i < numSubstrings; i++) {
            substrings[i] = str.substring(i, i + k);
        }
        return substrings;
    }

    public static boolean containsSubstring(String str, String substring) {
        int substringLength = substring.length();
        int endIndex = str.length() - substringLength;
        for (int i = 0; i <= endIndex; i++) {
            if (str.regionMatches(i, substring, 0, substringLength)) {
                return true;
            }
        }
        return false;
    }
}
