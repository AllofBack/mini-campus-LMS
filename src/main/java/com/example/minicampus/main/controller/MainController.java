package com.example.minicampus.main.controller;

import com.example.minicampus.admin.banner.dto.BannerDto;
import com.example.minicampus.admin.banner.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model) {
        List<BannerDto> bannerList = bannerService.frontList();
        model.addAttribute("bannerList", bannerList);

        return "index";
    }


    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }

}
