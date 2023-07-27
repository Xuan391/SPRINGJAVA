package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.models.SanPhamB12;
import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springjava1/javacore2/bai12")
public class Bai12Controller {
    @Autowired
    private Bai12Service bai12Service;

    @GetMapping("/sortByName")
    public ResponseEntity<List<SanPhamB12>> sortByName(){
        return ResponseEntity.ok(bai12Service.sortByName());
    }

    @GetMapping("/sortByPrice")
    public ResponseEntity<List<SanPhamB12>> sortByPrice(){
        return ResponseEntity.ok(bai12Service.sortByPrice());
    }

    @GetMapping("/sortByDate")
    public ResponseEntity<List<SanPhamB12>> sortByDate(){
        return ResponseEntity.ok(bai12Service.sortByDate());
    }

    @GetMapping("/sortByPriceDate")
    public ResponseEntity<List<SanPhamB12>> sortByPriceDate(){
        return ResponseEntity.ok(bai12Service.sortByPriceAndDate());
    }
}
