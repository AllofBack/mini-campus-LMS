package com.example.minicampus.configuration;

import com.example.minicampus.member.entity.MemberLoginHistory;
import com.example.minicampus.member.repository.MemberLoginHistoryRepository;
import com.example.minicampus.member.entity.Member;
import com.example.minicampus.member.repository.MemberRepository;
import com.example.minicampus.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;
    private final MemberLoginHistoryRepository memberLoginHistoryRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String userId = authentication.getName();

        Optional<Member> optionalMember = memberRepository.findById(userId);
        Member member = optionalMember.get();
        member.setLastLoginDt(LocalDateTime.now());
        memberRepository.save(member);


        String userAgent = RequestUtils.getUserAgent(request); // 접속 UserAgent
        String clientIp = RequestUtils.getClientIP(request); // Client IP

        memberLoginHistoryRepository.save(MemberLoginHistory.builder()
                .userId(userId)
                .userAgent(userAgent)
                .clientIp(clientIp)
                .loginDt(LocalDateTime.now())
                .build()
        );


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
