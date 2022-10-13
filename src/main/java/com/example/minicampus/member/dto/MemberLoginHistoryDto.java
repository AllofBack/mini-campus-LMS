package com.example.minicampus.member.dto;

import com.example.minicampus.member.entity.MemberLoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberLoginHistoryDto {
    Long id;

    String userId;
    String clientIp;
    String userAgent;
    LocalDateTime loginDt;

    long totalCount;
    long seq;

    public static MemberLoginHistoryDto of(MemberLoginHistory memberLoginHistory) {
        return MemberLoginHistoryDto.builder()
                .userId(memberLoginHistory.getUserId())
                .clientIp(memberLoginHistory.getClientIp())
                .userAgent(memberLoginHistory.getUserAgent())
                .loginDt(memberLoginHistory.getLoginDt())
                .build();
    }
}
