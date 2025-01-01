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
        registry.addMapping("/api/**")  // API 경로에 대한 CORS 매핑
                .allowedOrigins("http://localhost:3000")  // Next.js 프론트엔드의 출처 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드
                .allowCredentials(true);  // 자격 증명 허용: 클라이언트가 쿠키, 인증 헤더 또는 TLS 인증서를 포함하여 요청을 보낼 수 있도록 허용
    }
} 