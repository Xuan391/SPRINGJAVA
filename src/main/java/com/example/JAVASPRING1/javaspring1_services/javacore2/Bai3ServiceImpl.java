package com.example.JAVASPRING1.javaspring1_services.javacore2;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bai3ServiceImpl implements Bai3Service {
    private final HashMap<String, Integer> persons = new HashMap<>();
    @Override
    public void addPerson(String name, int age) {
        persons.put(name,age);
    }

    @Override
    public Map<String, Integer> getAllPersons() {
        return persons;
    }

    @Override
    public int findAgeByName(String name) {
        return persons.get(name);
    }

    @Override
    public String removePerson(String name) {
        if(persons.containsKey(name)){
            persons.remove(name);
            return "Remove person successfully";
        } else {
            return "Person name not exist, remove fail";
        }
    }

    @Override
    public String checkPerson(String name) {
        if(persons.containsKey(name)){
            return "contain " + name;
        } else {
            return name +" not exist";
        }
    }


}
