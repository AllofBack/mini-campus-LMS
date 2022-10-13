package com.example.minicampus.admin.banner.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String altText; // 대체 텍스트 (배너명)
    String linkBanner; // 배너링크
    String targetInfo; // 타겟 인포 (현재 창인지, 새 창인지)
    int sortNum; // 정렬 순서
    boolean frontYn; // 프론트 표시 여부

    LocalDate regDt;

    String fileName;
    String urlFilename;
}
