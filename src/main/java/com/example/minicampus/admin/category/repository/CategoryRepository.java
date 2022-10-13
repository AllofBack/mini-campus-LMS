package com.example.minicampus.admin.category.repository;

import com.example.minicampus.admin.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { // 테이블, 키

}
