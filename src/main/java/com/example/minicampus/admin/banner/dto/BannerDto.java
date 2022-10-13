package com.example.minicampus.admin.banner.dto;

import com.example.minicampus.admin.banner.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BannerDto {

    Long id;

    String altText; // 대체 텍스트
    String linkBanner; // 배너링크
    String targetInfo; // 타겟 인포
    int sortNum;
    boolean frontYn;

    LocalDate regDt;

    String fileName;
    String urlFilename;

    //추가컬럼
    long totalCount;
    long seq;

    public static BannerDto of(Banner banner){
        return BannerDto.builder()
                .id(banner.getId())
                .altText(banner.getAltText())
                .linkBanner(banner.getLinkBanner())
                .targetInfo(banner.getTargetInfo())
                .sortNum(banner.getSortNum())
                .frontYn(banner.isFrontYn())
                .regDt(banner.getRegDt())
                .fileName(banner.getFileName())
                .urlFilename(banner.getUrlFilename())
                .build();
    }

    public static List<BannerDto> of(List<Banner> banners) {

        if (banners == null) {
            return null;
        }

        List<BannerDto> bannerDtoList = new ArrayList<>();
        for (Banner x : banners) {
            bannerDtoList.add(BannerDto.of(x));
        }
        return bannerDtoList;
    }
}
