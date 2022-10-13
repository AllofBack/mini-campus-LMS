package com.example.minicampus.admin.member.controller;

import com.example.minicampus.member.dto.MemberDto;
import com.example.minicampus.member.dto.MemberLoginHistoryDto;
import com.example.minicampus.admin.member.model.MemberParam;
import com.example.minicampus.admin.model.MemberInput;
import com.example.minicampus.admin.course.controller.BaseController;
import com.example.minicampus.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminMemberController extends BaseController {

    private final MemberService memberService;

    @GetMapping("/admin/member/list.do")
    public String list(Model model, MemberParam parameter) {

        parameter.init();
        List<MemberDto> members = memberService.list(parameter);

        long totalCount = 0;
        if (members != null && members.size() > 0) {
            totalCount = members.get(0).getTotalCount();
        }
        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);

        model.addAttribute("list", members);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);

        return "admin/member/list";
    }

    @GetMapping("/admin/member/detail.do")
    public String detail(Model model, MemberParam parameter, @PageableDefault(size = 5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {

        parameter.init();

        MemberDto member = memberService.detail(parameter.getUserId());
        List<MemberLoginHistoryDto> list = memberService.listLogIn(parameter.getUserId(), pageable);
        model.addAttribute("member", member);
        model.addAttribute("list", list);

        return "admin/member/detail";
    }

    @PostMapping("/admin/member/status.do")
    public String status(Model model, MemberInput parameter) {


        boolean result = memberService.updateStatus(parameter.getUserId(), parameter.getUserStatus());

        return "redirect:/admin/member/detail.do?userId=" + parameter.getUserId();
    }


    @PostMapping("/admin/member/password.do")
    public String password(Model model, MemberInput parameter) {


        boolean result = memberService.updatePassword(parameter.getUserId(), parameter.getPassword());

        return "redirect:/admin/member/detail.do?userId=" + parameter.getUserId();
    }


}
