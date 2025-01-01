package com.springboot.board.common.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.springboot.board.common.response.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice  // 모든 컨트롤러에서 발생하는 예외를 처리하기 위한 클래스
public class GlobalExceptionHandler {
    
    @ExceptionHandler(DataNotFoundException.class)  // DataNotFoundException 예외를 처리하는 메서드
    @ResponseStatus(HttpStatus.NOT_FOUND)  // HTTP 404 상태 코드 반환
    public ApiResponse<Void> handleDataNotFoundException(DataNotFoundException e) {
        return ApiResponse.error(e.getMessage());  // 예외 메시지를 포함한 에러 응답 반환
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)  // 유효성 검사 실패 예외를 처리하는 메서드
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // HTTP 400 상태 코드 반환
    public ApiResponse<Void> handleValidationException(MethodArgumentNotValidException e) {
        return ApiResponse.error("유효성 검사 실패");  // 유효성 검사 실패 메시지를 포함한 에러 응답 반환
    }
} 