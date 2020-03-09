package com.example.myapp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * react와 axios 통신을 위함.
 * CORS는 Cross Origin Resource Sharing의 약자로 도메인 또는 포트가 다른 서버의 자원을 요청하는 매커니즘
 * block을 풀려면 서버측에서 작업 필요...여기서...
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/api/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:3000")
        ;
    }
}

