package com.example.fullstack_backend.service;

import com.example.fullstack_backend.model.SalesData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    public List<SalesData> getSalesData() {
        List<SalesData> salesData = new ArrayList<>();
        salesData.add(new SalesData("January", 1000));
        salesData.add(new SalesData("February", 2000));
        salesData.add(new SalesData("March", 3000));
        salesData.add(new SalesData("April", 4000));
        salesData.add(new SalesData("May", 5000));
        salesData.add(new SalesData("June", 6000));
        return salesData;
    }
}
