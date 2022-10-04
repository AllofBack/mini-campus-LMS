package com.example.minicampus.admin.mapper;

import com.example.minicampus.admin.dto.MemberDto;
import com.example.minicampus.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // MyBatis Annotation
public interface MemberMapper {

    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);


}
