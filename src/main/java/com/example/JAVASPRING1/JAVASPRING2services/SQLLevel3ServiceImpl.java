package com.example.JAVASPRING1.JAVASPRING2services;

import com.example.JAVASPRING1.JAVASPRING2repositories.SQLLevel3Respository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQLLevel3ServiceImpl implements SQLLevel3Service{

    @Autowired
    public SQLLevel3Respository sqlLevel3Respository;

    @Override
    public List<Map<String, Object>> bai1(Pageable pageable) {
        return sqlLevel3Respository.bai1(pageable);
    }

    @Override
    public List<Map<String, Object>> bai2(Pageable pageable) {
        return sqlLevel3Respository.bai2(pageable);
    }

    @Override
    public List<Map<String, Object>> bai3(Pageable pageable) {
        return sqlLevel3Respository.bai3(pageable);
    }

    @Override
    public List<Map<String, Object>> bai5(Pageable pageable) {
        return sqlLevel3Respository.bai5(pageable);
    }

    @Override
    public List<Map<String, Object>> bai6(Pageable pageable) {
        return sqlLevel3Respository.bai6(pageable);
    }

    @Override
    public List<Map<String, Object>> bai7(Pageable pageable) {
        return sqlLevel3Respository.bai7(pageable);
    }

    @Override
    public List<Map<String, Object>> bai8(Pageable pageable) {
        return sqlLevel3Respository.bai8(pageable);
    }

    @Override
    public List<Map<String, Object>> bai9(Pageable pageable) {
        return sqlLevel3Respository.bai9(pageable);
    }

    @Override
    public List<Map<String, Object>> bai10(Pageable pageable) {
        return sqlLevel3Respository.bai10(pageable);
    }
}
