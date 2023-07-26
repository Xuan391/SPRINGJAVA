package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Bai11ServiceImpl implements Bai11Service{
    public final HashMap<String, String> tuDiens = new HashMap<>();
    @Override
    public String addWord(String word, String mean) {
        if(tuDiens.containsKey(word)){
            return  "Từ vựng đã có trong từ điển";
        } else {
            tuDiens.put(word, mean);
            return "Thêm từ vựng thành công";
        }
    }

    @Override
    public String findWord(String word) {
        if(tuDiens.containsKey(word)){
            return word + " : " + tuDiens.get(word);
        } else {
            return "không tìm thấy từ vựng";
        }
    }
}
