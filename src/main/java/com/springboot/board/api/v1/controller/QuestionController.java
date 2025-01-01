package com.springboot.board.api.v1.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import com.springboot.board.application.service.QuestionService;
import com.springboot.board.api.v1.dto.response.ApiResponse;
import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import org.springframework.data.domain.Page;
import jakarta.validation.Valid;


//Restful API 설계의 원칙에 따라 수정함.

//@RestController는 @Controller와 @ResponseBody의 조합임
//모든 메서드의 반환값이 자동으로 JSON 형식으로 변환되어 클라이언트에 응답. 
//이는 RESTful API를 구현하는 데 적합합니다.
//questionCreate(GET) method는 NextJS가 처리할 것임.


@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    
    // 모든 질문을 페이지네이션하여 가져오는 method
    @GetMapping
    public ApiResponse<Page<QuestionResponse>> getQuestions(
            @RequestParam(defaultValue = "0") int page) {
        // 질문 목록을 가져와서 ApiResponse로 감싸서 반환
        return ApiResponse.success(questionService.getQuestions(page));
    }
    
    // 새로운 질문을 생성하는 method
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 생성 성공 시 201 상태 코드 반환
    public ApiResponse<QuestionResponse> createQuestion(
            @Valid @RequestBody QuestionCreateRequest request) {
        // 질문 생성 후 ApiResponse로 감싸서 반환
        return ApiResponse.success(questionService.createQuestion(request));
    }
    
    // 특정 ID에 해당하는 질문을 가져오는 method
    @GetMapping("/{id}")
    public ApiResponse<QuestionResponse> getQuestion(@PathVariable Long id) {
        // 질문을 가져와서 ApiResponse로 감싸서 반환
        return ApiResponse.success(questionService.getQuestion(id));
    }
} 