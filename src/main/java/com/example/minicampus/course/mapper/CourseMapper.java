package com.example.minicampus.course.mapper;

import com.example.minicampus.course.dto.CourseDto;
import com.example.minicampus.course.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    
    long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);
    
}
