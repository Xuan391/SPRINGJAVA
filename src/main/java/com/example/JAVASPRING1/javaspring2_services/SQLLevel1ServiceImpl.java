package com.example.JAVASPRING1.javaspring2_services;

import com.example.JAVASPRING1.javaspring2_repositories.SQLLevel1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SQLLevel1ServiceImpl implements SQLLevel1Service{

    @Autowired
    private SQLLevel1Repository sqlLevel1Repository;

    @Override
    public List<Map<String, Object>> bai1(Pageable pageable) {
        return sqlLevel1Repository.bai1(pageable);
    }

    @Override
    public List<Map<String, Object>> bai2(Pageable pageable) {
        return sqlLevel1Repository.bai2(pageable);
    }

    @Override
    public List<Map<String, Object>> bai3() {
        return sqlLevel1Repository.bai3();
    }

    @Override
    public List<Map<String, Object>> bai4(Pageable pageable) {
        return sqlLevel1Repository.bai4(pageable);
    }

    @Override
    public List<Map<String, Object>> bai5(Pageable pageable) {
        return sqlLevel1Repository.bai5(pageable);
    }

    @Override
    public List<Map<String, Object>> bai6() {
        return sqlLevel1Repository.bai6();
    }

    @Override
    public List<Map<String, Object>> bai7(Pageable pageable) {
        return sqlLevel1Repository.bai7(pageable);
    }

    @Override
    public List<Map<String, Object>> bai8(Pageable pageable) {
        return sqlLevel1Repository.bai8(pageable);
    }
}
