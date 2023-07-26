package com.example.JAVASPRING1.JAVASPRING2services;

import com.example.JAVASPRING1.JAVASPRING2repositories.SQLLevel2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQLLevel2ServiceImpl implements SQLLevel2Service{
    @Autowired
    private SQLLevel2Repository sqlLevel2Repository;

    @Override
    public List<Map<String, Object>> bai1(Pageable pageable) {
        return sqlLevel2Repository.bai1(pageable);
    }

    @Override
    public List<Map<String, Object>> bai2(Pageable pageable) {
        return sqlLevel2Repository.bai2(pageable);
    }

    @Override
    public List<Map<String, Object>> bai3(Pageable pageable) {
        return sqlLevel2Repository.bai3(pageable);
    }

    @Override
    public List<Map<String, Object>> bai4(Pageable pageable) {
        return sqlLevel2Repository.bai4(pageable);
    }

    @Override
    public List<Map<String, Object>> bai5(Pageable pageable) {
        return sqlLevel2Repository.bai5(pageable);
    }

    @Override
    public List<Map<String, Object>> bai6(Pageable pageable) {
        return sqlLevel2Repository.bai6(pageable);
    }

    @Override
    public List<Map<String, Object>> bai7(Pageable pageable) {
        return sqlLevel2Repository.bai7(pageable);
    }

    @Override
    public List<Map<String, Object>> bai8(Pageable pageable) {
        return sqlLevel2Repository.bai8(pageable);
    }

    @Override
    public List<Map<String, Object>> bai9(Pageable pageable) {
        return sqlLevel2Repository.bai9(pageable);
    }

    @Override
    public List<Map<String, Object>> bai10(Pageable pageable) {
        return sqlLevel2Repository.bai10(pageable);
    }
}
