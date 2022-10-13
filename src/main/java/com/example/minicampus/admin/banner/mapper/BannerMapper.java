package com.example.minicampus.admin.banner.mapper;

import com.example.minicampus.admin.banner.dto.BannerDto;
import com.example.minicampus.admin.banner.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);
}
