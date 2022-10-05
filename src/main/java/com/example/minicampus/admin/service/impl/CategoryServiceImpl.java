package com.example.minicampus.admin.service.impl;

import com.example.minicampus.admin.dto.CategoryDto;
import com.example.minicampus.admin.dto.MemberDto;
import com.example.minicampus.admin.entity.Category;
import com.example.minicampus.admin.mapper.MemberMapper;
import com.example.minicampus.admin.model.CategoryInput;
import com.example.minicampus.admin.model.MemberParam;
import com.example.minicampus.admin.repository.CategoryRepository;
import com.example.minicampus.admin.service.CategoryService;
import com.example.minicampus.component.MailComponents;
import com.example.minicampus.member.entity.Member;
import com.example.minicampus.member.entity.MemberCode;
import com.example.minicampus.member.exception.MemberNotEmailAuthException;
import com.example.minicampus.member.exception.MemberStopUserException;
import com.example.minicampus.member.model.MemberInput;
import com.example.minicampus.member.model.ResetPasswordInput;
import com.example.minicampus.member.repository.MemberRepository;
import com.example.minicampus.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService { // 구현체

    private final CategoryRepository categoryRepository;

    private Sort getSortBySortValueDesc() {
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }

    @Override
    public List<CategoryDto> list() {
        List<Category> categories = categoryRepository.findAll(getSortBySortValueDesc());
        return CategoryDto.of(categories);
    }

    @Override
    public boolean add(String categoryName) {

        // 카테고리명이 중복인지 체크
        Category category = Category.builder()
                .categoryName(categoryName)
                .usingYn(true)
                .sortValue(0)
                .build();
        categoryRepository.save(category);

        return true;
    }

    @Override
    public boolean update(CategoryInput parameter) {

        Optional<Category> optionalCategory = categoryRepository.findById(parameter.getId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryName(parameter.getCategoryName());
            category.setSortValue(parameter.getSortValue());
            category.setUsingYn(parameter.isUsingYn());
            categoryRepository.save(category);
        }

        return true;
    }

    @Override
    public boolean del(long id) {

        categoryRepository.deleteById(id);

        return true;
    }
}
