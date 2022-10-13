# MiniCampus-LMS

<!-- ABOUT THE PROJECT -->
## About The Project

👩‍💻 LMS 학습 관리 시스템

### 📁 Built With

<div align=center> 
<br>
    <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> 
    <img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=MariaDB&logoColor=white">
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
<br>
    <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
    <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
    <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
    <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
</div>
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### 🪟 Project Structure
```bash
└─java
    └─minicampus
       ├─admin
       │  ├─banner
       │  ├─category
       │  ├─course
       │  ├─main
       │  └─member
       │
       ├─common
       ├─configuration
       ├─main.controller
       │
       ├─member
       │  ├─controller
       │  ├─dto
       │  ├─entity
       │  ├─exception
       │  ├─mapper
       │  ├─model
       │  ├─repository
       │  └─service
       ├─util     
       └─MiniCampusApllication

```
```bash
└─resources
       ├─mybatis
       ├─static
       │  └─res
       │      └─se2
       │
       └─templates
          ├─admin
          │  ├─banner
          │  ├─category
          │  ├─course
          │  ├─member
          │  └─takecourse
          ├─common
          ├─course
          ├─error
          ├─fragments
          └─member
```

<!-- ROADMAP -->
### 📋 Implementation Function

- [x] 회원 가입 및 가입 인증메일 전송
  - [x] JavaMailSender 사용
  - [x] 우편번호 API 적용 [(📩 우편번호 서비스)](https://postcode.map.daum.net/guide)
- [x] 로그인 및 로그아웃
  - [x] Spring Security 설정
  - [x] 비밀번호 찾기 (비밀번호 초기화)
  - [x] Login History (Log) 남기기
- [x] 관리자(Back Office) 
  - [x] 회원 관리
  - [x] 카테고리 관리
  - [x] 강좌 관리
  - [x] 배너 관리
    - [x] 프론트 배너 노출 기능
- [x] DB (MariaDB) 설계
- [x] Paging 처리 (MyBatis)
- [ ] README.md 수정 (겪은 문제 + 프로젝트 설명)

<p align="right">(<a href="#readme-top">back to top</a>)</p>