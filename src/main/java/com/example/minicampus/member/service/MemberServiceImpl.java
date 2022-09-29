package com.example.minicampus.member.service;

import com.example.minicampus.member.entity.Member;
import com.example.minicampus.member.model.MemberInput;
import com.example.minicampus.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService { // 구현체

    private final MemberRepository memberRepository;

    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());

        if (optionalMember.isPresent()){
            // 현재 userId에 해당하는 데이터 존재
            return false;
        }

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPassword(parameter.getPassword());
        member.setPhone(parameter.getPhone());
        member.setRegDt(LocalDateTime.now());

        memberRepository.save(member); // user_id PrimaryKey라 중복 안 됨.
                                       // 동일 데이터 있을 경우, 기존 데이터 업데이트 => 다른 사람이 내 이메일로도 가입 가능.

        return false;
    }
}
