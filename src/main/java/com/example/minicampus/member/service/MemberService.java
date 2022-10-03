package com.example.minicampus.member.service;

import com.example.minicampus.member.model.MemberInput;
import com.example.minicampus.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);

    /**
     * uuid에 해당하는 계정 활성화
     */
    boolean emailAuth(String uuid);

    /***
     * 입력한 이메일로 비밀번호 초기화 정보를 전송
     */
    boolean sendResetPassword(ResetPasswordInput parameter);

    /***
     * 입력받은 uuid에 대해서 password 초기화 진행
     */
    boolean resetPassword(String uuid, String password);

    /***
     * 입력받은 uuid 값이 유효한지 확인
     */
    boolean checkResetPassword(String uuid);
}
