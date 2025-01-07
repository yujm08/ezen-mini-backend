package com.springboot.board.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig 클래스는 Swagger(OpenAPI) 설정을 위한 구성 클래스
 * 이 클래스는 API 문서화를 위한 OpenAPI 객체를 생성
 */
@Configuration
public class SwaggerConfig {

        /**
         * OpenAPI 객체를 생성하는 메서드
         * 
         * @return OpenAPI 객체로 API 문서화 정보를 포함합니다.
         */
        @Bean
        public OpenAPI openAPI() {
                Info info = new Info()
                                .title("EZEN학원 A조 API 설명서")
                                .version("v2.0.0")
                                .description("Spring Boot Board REST API 문서")
                                .contact(new Contact()
                                                .name("깃허브소스코드 바로가기")
                                                // .email("stable.luckychu@gmail.com")
                                                .url("https://github.com/yujm08/ezen-mini-backend.git"));
                // .license(new License()
                // .name("Apache License Version 2.0")
                // .url("http://www.apache.org/licenses/LICENSE-2.0"));

                return new OpenAPI()
                                .info(info)
                                .components(new Components()
                                                .addSecuritySchemes("bearer-key",
                                                                new SecurityScheme()
                                                                                .type(SecurityScheme.Type.HTTP)
                                                                                .scheme("bearer")
                                                                                .bearerFormat("JWT")));
        }
}