package com.example.JAVASPRING1.javaspring1_services.javacore4;

import com.example.JAVASPRING1.models.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BangCongService {
    public String storeFile(MultipartFile file);
    List<Employee> bangCong (String fileName);

}
