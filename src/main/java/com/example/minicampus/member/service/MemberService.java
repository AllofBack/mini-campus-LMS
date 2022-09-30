package com.example.minicampus.member.service;

import com.example.minicampus.member.model.MemberInput;

public interface MemberService {

    boolean register(MemberInput parameter);

    /**
     * uuid에 해당하는 계정 활성화
     * @param uuid
     * @return
     */
    boolean emailAuth(String uuid);

}
