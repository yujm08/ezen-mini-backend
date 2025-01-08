package com.springboot.board.api.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import com.springboot.board.application.service.AnswerService;
import com.springboot.board.common.response.ApiResponse;
import com.springboot.board.common.response.ErrorResponse;
import com.springboot.board.api.v1.dto.request.AnswerCreateRequest;
import com.springboot.board.api.v1.dto.response.AnswerResponse;
import jakarta.validation.Valid;

import java.util.List;

@Tag(name = "Answer", description = "답변 관련 API")
@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @Operation(summary = "답변 생성", description = "새로운 답변을 생성합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "생성 성공", content = @Content(schema = @Schema(implementation = AnswerResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "질문 없음", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<AnswerResponse> createAnswer(
            @Valid @RequestBody AnswerCreateRequest request) {
        return ApiResponse.success(answerService.createAnswer(request));
    }

    @Operation(summary = "질문 ID로 답변 조회", description = "특정 질문에 대한 모든 답변을 조회합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = AnswerResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "답변 없음", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })

    @GetMapping // /api/v1/answers?questionId=
    public ApiResponse<List<AnswerResponse>> getAnswersByQuestionId(
        @RequestParam(name = "questionId") Integer questionId) {
        // AnswerService에서 반환된 Answer 리스트를 가져옴
        List<AnswerResponse> answers = answerService.getAnswersByQuestionId(questionId);

        // 디버깅: Answer 리스트를 반복하며 Question 정보 확인
        answers.forEach(answer -> {
            System.out.println("Answer ID: " + answer.getId());
            System.out.println("Question ID: " + (answer.getQuestionId() != null ? answer.getQuestionId() : "null"));
        });

        // 최종 응답 반환
        return ApiResponse.success(answers);
    }

}
