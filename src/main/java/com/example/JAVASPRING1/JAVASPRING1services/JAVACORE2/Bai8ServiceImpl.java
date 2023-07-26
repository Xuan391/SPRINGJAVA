package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE2;

import com.example.JAVASPRING1.models.SanPhamB8;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Bai8ServiceImpl implements Bai8Service {
    private final HashMap<String, SanPhamB8> sanPhamList = new HashMap<>();
    @Override
    public String addSanPham(String key, SanPhamB8 newSanPham) {
        if(sanPhamList.containsKey(key)){
            return "Sản phẩm đã tồn tại!";
        } else {
            sanPhamList.put(key, newSanPham);
        }
        return "Thêm sản phẩm thành công";
    }

    @Override
    public Map<String, SanPhamB8> getAllSanPham() {
        return sanPhamList;
    }

    @Override
    public SanPhamB8 findSanPhamByKey(String key) {
        if(sanPhamList.containsKey(key)){
            SanPhamB8 sanPham = sanPhamList.get(key);
            return sanPham;
        } else {
            return null;
        }
    }

    @Override
    public String removeSanPhamByKey(String key) {
        if(sanPhamList.containsKey(key)){
            sanPhamList.remove(key);
            return "Xóa sản phẩm thành công";
        } else{
            return "Sản phẩm không tồn tại";
        }
    }

    @Override
    public String updateSanPham(String key, SanPhamB8 sanPhamUpdate) {
        if(sanPhamList.containsKey(key)){
            SanPhamB8 sanPham = sanPhamList.get(key);
            sanPham.setName(sanPhamUpdate.getName());
            sanPham.setPrice(sanPhamUpdate.getPrice());
            sanPham.setQuality(sanPhamUpdate.getQuality());

            return "Cập nhật thành công: "+ sanPham.toString();
        } else {
            return "Không tìm thấy sản phẩm";
        }
    }
}
