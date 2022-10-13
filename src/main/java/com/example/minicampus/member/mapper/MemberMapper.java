package com.example.minicampus.member.mapper;

import com.example.minicampus.member.dto.MemberDto;
import com.example.minicampus.admin.member.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // MyBatis Annotation
public interface MemberMapper {

    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);


}
