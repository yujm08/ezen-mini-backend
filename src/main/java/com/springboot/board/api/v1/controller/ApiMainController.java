package com.springboot.board.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.board.common.response.ApiResponse;

@RestController
public class ApiMainController {
    
    //사용자가 / 경로로 접근하면, "Redirecting to /question/list"라는 성공 메시지가 JSON 형태로 반환
    @GetMapping("/question/list")
    public ApiResponse<String> root() {
        return ApiResponse.success("Redirecting to /question/list");
    }
} 