package com.springboot.board.api.v1.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerResponse {
    private Long id; // 답변의 고유 ID
    private String content; // 답변 내용
    // 필요한 필드 추가
} 