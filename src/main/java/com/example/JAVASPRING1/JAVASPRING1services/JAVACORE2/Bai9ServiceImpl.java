package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bai9ServiceImpl implements Bai9Service{

    @Override
    public List<String> countWords(String text) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Split the text into words
        String[] words = text.split("\\s+");

        // Count the occurrences of each word
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        List<String> results = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : wordCountMap.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue();
            results.add(word +": " + count);
        }
        return results;
    }
}
