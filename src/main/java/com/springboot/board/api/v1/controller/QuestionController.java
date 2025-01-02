package com.springboot.board.api.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import com.springboot.board.application.service.QuestionService;
import com.springboot.board.common.response.ApiResponse;
import com.springboot.board.api.v1.dto.request.QuestionCreateRequest;
import com.springboot.board.api.v1.dto.response.QuestionResponse;
import org.springframework.data.domain.Page;
import jakarta.validation.Valid;


//Restful API 설계의 원칙에 따라 수정함.

//@RestController는 @Controller와 @ResponseBody의 조합임
//모든 메서드의 반환값이 자동으로 JSON 형식으로 변환되어 클라이언트에 응답. 
//이는 RESTful API를 구현하는 데 적합합니다.
//questionCreate(GET) method는 NextJS가 처리할 것임.


@Tag(name = "Question", description = "질문 관련 API")
@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    
    @Operation(summary = "질문 목록 조회", description = "페이지네이션된 질문 목록을 조회합니다.")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @GetMapping
    public ApiResponse<Page<QuestionResponse>> getQuestions(
            @RequestParam(defaultValue = "0") int page) {
        // 질문 목록을 가져와서 ApiResponse로 감싸서 반환
        return ApiResponse.success(questionService.getQuestions(page));
    }
    
    @Operation(summary = "질문 생성", description = "새로운 질문을 생성합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "생성 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 생성 성공 시 201 상태 코드 반환
    public ApiResponse<QuestionResponse> createQuestion(
            @Valid @RequestBody QuestionCreateRequest request) {
        // 질문 생성 후 ApiResponse로 감싸서 반환
        return ApiResponse.success(questionService.createQuestion(request));
    }
    
    @Operation(summary = "질문 상세 조회", description = "특정 ID의 질문을 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "조회 성공"),
        @ApiResponse(responseCode = "404", description = "질문 없음")
    })
    @GetMapping("/{id}")
    public ApiResponse<QuestionResponse> getQuestion(@PathVariable Long id) {
        // 질문을 가져와서 ApiResponse로 감싸서 반환
        return ApiResponse.success(questionService.getQuestion(id));
    }
} 