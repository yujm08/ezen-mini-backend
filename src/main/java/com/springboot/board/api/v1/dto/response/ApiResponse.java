package com.springboot.board.api.v1.dto.response;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }
} 