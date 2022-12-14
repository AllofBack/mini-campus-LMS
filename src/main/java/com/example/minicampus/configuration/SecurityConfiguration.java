package com.example.minicampus.configuration;

import com.example.minicampus.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/files/**");

        super.configure(web);
    }

    private final MemberService memberService;

    @Bean
    PasswordEncoder getPasswordEncoder() { // 비밀번호 저장시 encode
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserAuthenticationFailureHandler getFailureHandler() {
        return new UserAuthenticationFailureHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); // 로그인과 같은 기능에서 정보가 내 페이지에서 만들어진게 맞는지 확인하는 기술 CSRF (잠시 DISABLE 처리)
        http.headers().frameOptions().sameOrigin(); // frameOption deny 문제 해결

        // 페이지 권한 설정 - 주소 매칭 (아래 주소에 대해 접근 가능하게 처리)
        http.authorizeRequests()
                .antMatchers(
                        "/"
                        , "/member/register"
                        , "/member/email_auth"
                        , "/member/find/password"
                        , "/member/reset/password"
                )
                        .permitAll();

        // ROLE_ADMIN 권한 있어야 접근 가능
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasAuthority("ROLE_ADMIN");

        // 로그인 페이지 설정
        http.formLogin()
                .loginPage("/member/login")
                .failureHandler(getFailureHandler()) // ** 핸들러 주입하기
                .permitAll();

        // 로그아웃 페이지 설정
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        // 권한 예외 처리
        http.exceptionHandling()
                .accessDeniedPage("/error/denied");


        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // SpringSecurity에 MemberService에 대해 등록하기
        auth.userDetailsService(memberService)
                .passwordEncoder(getPasswordEncoder());

        super.configure(auth);
    }

}
