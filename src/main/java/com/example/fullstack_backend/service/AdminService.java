package com.example.fullstack_backend.service;

import com.example.fullstack_backend.model.Admin;
import com.example.fullstack_backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
}