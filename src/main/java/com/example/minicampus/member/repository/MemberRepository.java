package com.example.minicampus.member.repository;

import com.example.minicampus.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> { // 테이블, 키
}