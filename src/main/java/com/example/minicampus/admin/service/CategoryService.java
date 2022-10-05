package com.example.minicampus.admin.service;

import com.example.minicampus.admin.dto.CategoryDto;
import com.example.minicampus.admin.model.CategoryInput;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> list();

    /**
     * 카테고리 신규 추가
     */
    boolean add(String categoryName);

    /**
     * 카테고리 수정
     */
    boolean update(CategoryInput parameter);

    /**
     * 카테고리 삭제
     */
    boolean del(long id);
}

