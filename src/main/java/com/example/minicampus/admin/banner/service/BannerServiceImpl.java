package com.example.minicampus.admin.banner.service;

import com.example.minicampus.admin.banner.dto.BannerDto;
import com.example.minicampus.admin.banner.mapper.BannerMapper;
import com.example.minicampus.admin.banner.model.BannerInput;
import com.example.minicampus.admin.banner.model.BannerParam;
import com.example.minicampus.admin.banner.repository.BannerRepository;
import com.example.minicampus.admin.banner.entity.Banner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;

    @Override
    public boolean add(BannerInput parameter) {

        Banner banner = Banner.builder()
                .altText(parameter.getAltText())
                .linkBanner(parameter.getLinkBanner())
                .targetInfo(parameter.getTargetInfo())
                .sortNum(parameter.getSortNum())
                .frontYn(parameter.isFrontYn())
                .regDt(LocalDate.now())
                .fileName(parameter.getFileName())
                .urlFilename(parameter.getUrlFilename())
                .build();

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public boolean set(BannerInput parameter) {

        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());
        if (!optionalBanner.isPresent()) {
            //수정할 데이터가 없음
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setAltText(parameter.getAltText());
        banner.setLinkBanner(parameter.getLinkBanner());
        banner.setTargetInfo(parameter.getTargetInfo());
        banner.setSortNum(parameter.getSortNum());
        banner.setFrontYn(parameter.isFrontYn());
        banner.setRegDt(LocalDate.now());
        banner.setFileName(parameter.getFileName());
        banner.setUrlFilename(parameter.getUrlFilename());

        bannerRepository.save(banner);

        return true;
    }

    @Override
    public List<BannerDto> list(BannerParam parameter) {

        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }

        return list;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean del(String idList) {
        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }

    @Override
    public List<BannerDto> frontList() {
        List<BannerDto> bannerDtoList = null;

        Optional<List<Banner>> optionalBanners = bannerRepository.findByFrontYnOrderBySortNum(true);

        if (optionalBanners.isPresent()) {
            List<Banner> banners = optionalBanners.get();
            bannerDtoList = BannerDto.of(banners);
        }
        return  bannerDtoList;
    }

}