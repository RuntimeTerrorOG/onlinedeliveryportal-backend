package com.example.fullstack_backend.controller;

import com.example.fullstack_backend.model.Admin;
import com.example.fullstack_backend.repository.AdminRepository;
import com.example.fullstack_backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @PostMapping("/postAdmin")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.saveAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }


//    @GetMapping("/users")
//    List<Admin>getAllUsers(){
//        return AdminService.fingall();
//    }



}
