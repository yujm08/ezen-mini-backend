package com.springboot.board.common.exception;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleDataNotFoundException(DataNotFoundException e) {
        return ApiResponse.error(e.getMessage());
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleValidationException(MethodArgumentNotValidException e) {
        return ApiResponse.error("유효성 검사 실패");
    }
} 