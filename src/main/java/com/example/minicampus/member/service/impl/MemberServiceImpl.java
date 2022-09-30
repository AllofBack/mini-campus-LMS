package com.example.minicampus.member.service.impl;

import com.example.minicampus.component.MailComponents;
import com.example.minicampus.member.entity.Member;
import com.example.minicampus.member.model.MemberInput;
import com.example.minicampus.member.repository.MemberRepository;
import com.example.minicampus.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService { // 구현체

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());

        if (optionalMember.isPresent()){
            // 현재 userId에 해당하는 데이터 존재
            return false;
        }

        String uuid = UUID.randomUUID().toString(); // 랜덤 키

        // 생성자말고 builder를 통한 효율성 증가
        Member member = Member.builder()
                .userId(parameter.getUserId())
                .userName(parameter.getUserName())
                .password(parameter.getPassword())
                .phone(parameter.getPhone())
                .regDt(LocalDateTime.now())
                .emailAuthYn(false)
                .emailAuthKey(uuid)
                .build();


        memberRepository.save(member); // user_id PrimaryKey라 중복 안 됨.
                                       // 동일 데이터 있을 경우, 기존 데이터 업데이트 => 다른 사람이 내 이메일로도 가입 가능.

        String email = parameter.getUserId();
        String subject = "miniCampus 사이트 가입을 축하드립니다. ";
        String text = "<p> miniCampus 사이트 가입을 축하드립니다. </p> <p> 아래 링크를 클릭하셔서 가입을 완료하세요. </p>"
                + "<div><a href = 'http://localhost:8080/member/email-auth?id=" + uuid + "'> 가입 완료 </a></div>";

        mailComponents.sendMail(email, subject, text);

        return true;
    }

    @Override
    public boolean emailAuth(String uuid) {

        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);
        if (!optionalMember.isPresent()) {
            return false;
        }

        Member member = optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
