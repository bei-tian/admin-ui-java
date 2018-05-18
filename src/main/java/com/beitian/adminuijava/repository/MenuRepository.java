package com.beitian.adminuijava.repository;

import com.beitian.adminuijava.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Integer> {
    public List<Menu> findByParentId(int parentId);
}
