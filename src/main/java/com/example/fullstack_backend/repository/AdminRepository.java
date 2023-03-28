package com.example.fullstack_backend.repository;

import com.example.fullstack_backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {


}
