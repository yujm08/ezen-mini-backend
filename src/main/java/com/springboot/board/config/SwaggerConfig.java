package com.springboot.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * SwaggerConfig 클래스는 Swagger(OpenAPI) 설정을 위한 구성 클래스
 * 이 클래스는 API 문서화를 위한 OpenAPI 객체를 생성
 */
@Configuration
public class SwaggerConfig {
    
    /**
     * OpenAPI 객체를 생성하는 메서드
     * @return OpenAPI 객체로 API 문서화 정보를 포함합니다.
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Board API")  
                        .version("1.0")  
                        .description("Board API Documentation"));  
    }
} 