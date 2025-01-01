package com.springboot.board.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.board.common.response.ApiResponse;

@RestController
public class MainController {
    
    @GetMapping("/")
    public ApiResponse<String> root() {
        return ApiResponse.success("Redirecting to /question/list");
    }
} 