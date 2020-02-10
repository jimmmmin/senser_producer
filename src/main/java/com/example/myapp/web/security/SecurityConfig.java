package com.example.myapp.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()    //경로에 따른 권한을 지정할 수 있음.
                .antMatchers("/", "/login","/service","/resources/**","/create").permitAll()
                .antMatchers("/admin").hasRole("ADMIN") //()안 권한을 가진 유저만 경로에 접근
                .anyRequest().authenticated()
                .and()
            .formLogin() //.loginPage(), .defaultSuccessPage() 등으로 내가 직접 구현한 로그인 폼, 로그인 성공 시 이동할 경로를 설정할 수 있다. 이때 로그인 폼의 아이디, 패스워드 부분 아이디는 username, password로 일치시켜주어야
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
