package com.example.JAVASPRING1.javaspring1_services.javacore2;

import com.example.JAVASPRING1.models.SanPhamB12;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Bai12ServiceImpl implements Bai12Service{

    private final List<SanPhamB12> sanPhams = new ArrayList<>();

    public Bai12ServiceImpl(){
        sanPhams.add(new SanPhamB12("Sách","H01",8.0,new Date(2023,3,2)));
        sanPhams.add(new SanPhamB12("Vở","H02",8.5,new Date(2023,1,4)));
        sanPhams.add(new SanPhamB12("Bút","H03",7.0,new Date(2022,3,2)));
        sanPhams.add(new SanPhamB12("Tẩy","H04",4.0,new Date(2023,4,2)));
    }

    @Override
    public List<SanPhamB12> sortByName() {
        Collections.sort(sanPhams, Comparator.comparing(SanPhamB12::getName));
        return sanPhams;
    }

    @Override
    public List<SanPhamB12> sortByPrice() {
        Collections.sort(sanPhams, Comparator.comparing(SanPhamB12::getPrice));
        return sanPhams;
    }

    @Override
    public List<SanPhamB12> sortByDate() {
        Collections.sort(sanPhams,Comparator.comparing(SanPhamB12::getDate));
        return sanPhams;
    }

    @Override
    public List<SanPhamB12> sortByPriceAndDate() {
        Comparator<SanPhamB12> priceDateComparator = Comparator.comparing(SanPhamB12::getPrice)
                .thenComparing(SanPhamB12::getDate);
        Collections.sort(sanPhams,priceDateComparator);
        return sanPhams;
    }
}
