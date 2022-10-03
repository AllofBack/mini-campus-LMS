package com.example.minicampus.member.controller;

import com.example.minicampus.member.model.MemberInput;
import com.example.minicampus.member.model.ResetPasswordInput;
import com.example.minicampus.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/member/login")
    public String login() { // get & post 둘 다 받아야함

        return "member/login";
    }

    @GetMapping("/member/find/password")
    public String findPassword() {
        return "/member/find_password";
    }

    @PostMapping("/member/find/password")
    public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {

        boolean result = false;

        try {
            result = memberService.sendResetPassword(parameter);
        } catch (Exception e) {}

        model.addAttribute("result", result);
        return "member/find_password_result";
    }

    @GetMapping("/member/register")
    public String register() {

        return "member/register";
    }

    // request WEB -> SERVER
    // response SERVER -> WEB
    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request,
                                 MemberInput parameter) {

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);


        return "/member/register_complete";
    }

    @GetMapping("/member/email_auth")
    public String emailAuth(Model model, HttpServletRequest request){

        String uuid = request.getParameter("id");
        System.out.println(uuid);

        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);

        return "/member/email_auth";
    }

    @GetMapping("/member/info")
    public String memberInfo() {

        return "/member/info";
    }

    @GetMapping("/member/reset/password")
    public String resetPassword(Model model, HttpServletRequest request) {

        String uuid = request.getParameter("id");

        boolean result = memberService.checkResetPassword(uuid);
        model.addAttribute("result", result);

        return "/member/reset_password";
    }

    @PostMapping("/member/reset/password")
    public String resetPasswordSubmit(Model model, ResetPasswordInput parameter){

        boolean result = false;

        try {
            result = memberService.resetPassword(parameter.getId(), parameter.getPassword());
        } catch (Exception e) {}

        model.addAttribute("result", result); // 파라미터 가져오기

        return "/member/reset_password_result";
    }
}
