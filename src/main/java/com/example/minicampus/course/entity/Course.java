package com.example.minicampus.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    long categoryId;
    
    String imagePath;
    String keyword;
    String subject;
    
    @Column(length = 1000)
    String summary;
    
    @Lob // 많은 데이터 저장
    String contents;
    long price;
    long salePrice; // 현재판매가
    LocalDate saleEndDt; // 할인 기간
    
    LocalDateTime regDt;//등록일(추가날짜)
    LocalDateTime udtDt;//수정일(수정날짜)
}
