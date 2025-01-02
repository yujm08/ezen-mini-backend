package com.springboot.board.api.v1.controller;

import com.springboot.board.application.service.AnswerService;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import com.springboot.board.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Tag(name = "Answer", description = "답변 관련 API")
@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    
    @Operation(summary = "답변 생성", description = "새로운 답변을 생성합니다.")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "생성 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "질문 없음")
    })
    @PostMapping
    // HTTP POST 요청을 처리하여 새로운 답변을 생성하는 메서드
    @ResponseStatus(HttpStatus.CREATED) // 성공적으로 생성된 경우 201 CREATED 상태 코드를 반환
    public ApiResponse<AnswerResponse> createAnswer(@Valid @RequestBody AnswerCreateRequest request) {
        
        // 요청을 기반으로 답변을 생성하고 ApiResponse로 성공 결과를 반환
        return ApiResponse.success(answerService.createAnswer(request));
    }
} 