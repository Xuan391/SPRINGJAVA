package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import java.util.Set;

public interface Bai2Service {
    String add(String name);
    Set<String> getAll();
    String check(String name);
    String remover(String name);
    String quantity();
}
