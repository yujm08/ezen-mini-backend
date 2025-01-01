package com.springboot.board.api.v1.dto.response;

import lombok.Getter;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
public class QuestionResponse {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createDate;
    private List<AnswerResponse> answers;
} 