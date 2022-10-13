package com.example.minicampus.admin.category.mapper;

import com.example.minicampus.admin.category.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDto> select(CategoryDto parameter);

}
