package com.example.JAVASPRING1.javaspring1_services.javacore2;

import org.springframework.stereotype.Service;

@Service
public class Bai6ServiceImpl implements Bai6Service{
    @Override
    public String maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i< prices.length; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return "Lợi nhuận tối đa: " + maxProfit;
    }
}
