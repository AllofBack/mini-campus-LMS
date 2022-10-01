package com.example.minicampus.member.service;

import com.example.minicampus.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput parameter);

    /**
     * uuid에 해당하는 계정 활성화
     * @param uuid
     * @return
     */
    boolean emailAuth(String uuid);

}
