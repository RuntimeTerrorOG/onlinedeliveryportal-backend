package com.example.fullstack_backend.controller;

import com.example.fullstack_backend.model.SalesData;
import com.example.fullstack_backend.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")

public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping
    public List<SalesData> getSalesData() {
        return salesService.getSalesData();
    }
}
