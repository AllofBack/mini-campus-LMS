package com.example.minicampus.course.mapper;

import com.example.minicampus.course.dto.TakeCourseDto;
import com.example.minicampus.course.model.TakeCourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TakeCourseMapper { // 페이징 처리

    long selectListCount(TakeCourseParam parameter);
    List<TakeCourseDto> selectList(TakeCourseParam parameter);

    List<TakeCourseDto> selectListMyCourse(TakeCourseParam parameter);
    
}
