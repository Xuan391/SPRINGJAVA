package com.example.JAVASPRING1.javaspring1_services.javacore2;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class Bai4ServiceImpl implements Bai4Service {
    ArrayList<Integer> integers = new ArrayList<>();
    public Bai4ServiceImpl() {
        integers.add(16);
        integers.add(12);
        integers.add(32);
        integers.add(6);
        integers.add(14);
    }
    @Override
    public String sortAsc() {
        Collections.sort(integers);
        return "sorted asc: " + integers;
    }

    @Override
    public String sortDesc() {
        Collections.sort(integers, Collections.reverseOrder());
        return "sorted desc: " + integers;
    }
}
