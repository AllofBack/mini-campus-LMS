package com.example.minicampus.member.service;

import com.example.minicampus.admin.dto.MemberDto;
import com.example.minicampus.admin.model.MemberParam;
import com.example.minicampus.member.model.MemberInput;
import com.example.minicampus.member.model.ResetPasswordInput;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

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

    /***
     * 회원 목록 리턴(관리자에서만 사용 가능)
     */
    List<MemberDto> list(MemberParam parameter);

    /***
     * 회원 상세 정보
     */
    MemberDto detail(String userId);

    /***
     * 회원 상태 변경
     */
    boolean updateStatus(String userId, String userStatus);

    /***
     * 회원 비밀번호 변경
     */
    boolean updatePassword(String userId, String password);
}
