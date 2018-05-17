package com.beitian.adminuijava.repository;

import com.beitian.adminuijava.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    public Admin findByAccountAndPassword(String account,String password);
}
