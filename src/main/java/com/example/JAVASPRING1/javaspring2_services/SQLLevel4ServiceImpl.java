package com.example.JAVASPRING1.javaspring2_services;

import com.example.JAVASPRING1.javaspring2_repositories.SQLLevel4Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SQLLevel4ServiceImpl implements SQLLevel4Service{
    @Autowired
    private SQLLevel4Repository sqlLevel4Repository;

    @Override
    public void bai1() {
        sqlLevel4Repository.bai1();
    }

    @Override
    public void bai2() {
        sqlLevel4Repository.bai2();
    }

    @Override
    public void bai3() {
        sqlLevel4Repository.bai3();
    }

    @Override
    public void bai4() {
        sqlLevel4Repository.bai4();
    }

    @Override
    public void bai5() {
        sqlLevel4Repository.bai5();
    }

    @Override
    public void bai6() {
        sqlLevel4Repository.bai6();
    }

    @Override
    public void bai7() {
        sqlLevel4Repository.bai7();
    }

    @Override
    public void bai8() {
        sqlLevel4Repository.bai8();
    }

    @Override
    public void bai9() {
        sqlLevel4Repository.bai9();
    }

    @Override
    public void bai10() {
        sqlLevel4Repository.bai10();
    }
}
