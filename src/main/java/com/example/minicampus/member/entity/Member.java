package com.example.minicampus.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Member { // 테이블 의미
    @Id
    private String userId;

    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;
    
    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey; // 회원가입할 때 만들어준 인증키
    
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt; // 비민번호 변경 유효 기간

    // 관리자 여부 확인
    private boolean adminYn;
}
