package com.example.JAVASPRING1.JAVASPRING1controllers.JAVACORE2;

import com.example.JAVASPRING1.models.SanPhamB8;
import com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2.Bai8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/javacore2/bai8")
public class Bai8Controller {
    @Autowired
    private Bai8Service bai8Service;

    @GetMapping("/add/{key}")
    public ResponseEntity<String> add(@PathVariable String key, @RequestBody SanPhamB8 sanPham){
        return new ResponseEntity<>(bai8Service.addSanPham(key,sanPham), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Map<String, SanPhamB8>> getAll() {
        Map<String, SanPhamB8> result = bai8Service.getAllSanPham();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/find/{key}")
    public ResponseEntity<String> findSanPhamByKey(@PathVariable String key){
        SanPhamB8 sanPham = bai8Service.findSanPhamByKey(key);
        if(sanPham!= null){
            return ResponseEntity.ok(sanPham.toString());
        }else {
            return new ResponseEntity<>("Không tìm thấy sản phẩm", HttpStatus.OK);
        }
    }

    @GetMapping("/remove/{key}")
    public ResponseEntity<String> removeSanPham(@PathVariable String key){
        return ResponseEntity.ok(bai8Service.removeSanPhamByKey(key));
    }

    @GetMapping("/update/{key}")
    public ResponseEntity<String> updateSanpham(@PathVariable String key, @RequestBody SanPhamB8 sanPhamUpdate){
        return ResponseEntity.ok(bai8Service.updateSanPham(key, sanPhamUpdate));
    }
}
