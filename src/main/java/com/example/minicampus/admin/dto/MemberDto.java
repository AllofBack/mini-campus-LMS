package com.example.minicampus.admin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    String userId;
    String userName;
    String phone;
    String password;
    LocalDateTime regDt;

    String emailAuthKey;
    boolean emailAuthYn;
    LocalDateTime emailAuthDt;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;

    // 추가 컬럼
    long totalCount;
    // 시퀀스 처리
    long seq;
}
