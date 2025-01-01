package com.springboot.board.api.v1.controller;

import com.springboot.board.application.service.AnswerService;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    
    @PostMapping
    // HTTP POST 요청을 처리하여 새로운 답변을 생성하는 메서드
    @ResponseStatus(HttpStatus.CREATED) // 성공적으로 생성된 경우 201 CREATED 상태 코드를 반환
    public ApiResponse<AnswerResponse> createAnswer(@Valid @RequestBody AnswerCreateRequest request) {
        
        // 요청을 기반으로 답변을 생성하고 ApiResponse로 성공 결과를 반환
        return ApiResponse.success(answerService.createAnswer(request));
    }
} 