package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import java.util.Map;

public interface Bai3Service {
    void addPerson (String name, int age);
    Map<String, Integer> getAllPersons();
    int findAgeByName(String name);
    String removePerson(String name);
    String checkPerson(String name);
}
