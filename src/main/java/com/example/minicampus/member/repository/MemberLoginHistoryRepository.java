package com.example.minicampus.member.repository;

import com.example.minicampus.member.entity.MemberLoginHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberLoginHistoryRepository extends JpaRepository<MemberLoginHistory, Long> {
    List<MemberLoginHistory> findByUserId(String userId, Pageable pageable);
}
