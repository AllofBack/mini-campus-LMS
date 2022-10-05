package com.example.minicampus.admin.repository;

import com.example.minicampus.admin.entity.Category;
import com.example.minicampus.member.entity.Member;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { // 테이블, 키

}
