package com.example.JAVASPRING1.javaspring1_controllers.javacore3;

import com.example.JAVASPRING1.javaspring1_services.javacore3.PostfixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springjava1/javacore3/postfix")
public class PostfixController {
    @Autowired
    private PostfixService postfixService;

    @GetMapping
    public ResponseEntity<Double> postfixCalculate(@RequestParam("expression") String expression){
        return ResponseEntity.ok(postfixService.postfixCalculate(expression));
    }

}
