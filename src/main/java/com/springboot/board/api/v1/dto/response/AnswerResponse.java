package com.springboot.board.api.v1.dto.response;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponse {
    private Integer id;
    private String content;
    private LocalDateTime createDate;
}