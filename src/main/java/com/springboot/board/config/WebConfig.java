package com.springboot.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.lang.NonNull;

/**
 * WebConfig 클래스는 CORS 설정을 위한 구성 클래스
 * 이 클래스는 WebMvcConfigurer 인터페이스를 구현하여
 * 웹 애플리케이션의 CORS 정책을 정의
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    /**
     * CORS 매핑을 추가하는 메서드
     * @param registry CORS 설정을 위한 CorsRegistry 객체
     */
    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        // 모든 경로에 대한 CORS 설정
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
} 