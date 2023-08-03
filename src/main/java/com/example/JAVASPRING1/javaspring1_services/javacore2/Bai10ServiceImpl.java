package com.example.JAVASPRING1.javaspring1_services.javacore2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Bai10ServiceImpl implements Bai10Service{
    private final List<Double> scoreList = new ArrayList<>();
    @Override
    public List<String> scoresCount(double score) {
        Map<Double, Integer> scoreMap = new HashMap<>();
        scoreList.add(score);

        for(double s : scoreList) {
            if (scoreMap.containsKey(s)) {
                int count = scoreMap.get(s);
                scoreMap.put(s, count + 1);
            } else {
                scoreMap.put(s, 1);
            }
        }

        List<String> results = new ArrayList<>();

        results.add("Số lượng sinh viên đạt điểm cao: " + getScoreCount(scoreMap, 8.0, Double.MAX_VALUE));
        results.add("Số lượng sinh viên đạt điểm trung bình: " + getScoreCount(scoreMap, 5.0, 8.0));
        results.add("Số lượng sinh viên trượt: " + getScoreCount(scoreMap, Double.MIN_VALUE, 5.0));

        return results;
    }

    public static int getScoreCount(Map<Double,Integer> scoreMap,double minScore, double maxScore){
        int count = 0;
        for(Map.Entry<Double, Integer> entry : scoreMap.entrySet()){
            double score = entry.getKey();
            if(score>= minScore && score<maxScore){
                count += entry.getValue();
            }
        }
        return count;
    }
}
