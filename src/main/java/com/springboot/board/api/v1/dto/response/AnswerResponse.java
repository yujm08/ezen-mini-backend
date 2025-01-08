package com.springboot.board.api.v1.dto.response;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.springboot.board.domain.entity.Answer;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponse {
    private Integer id;
    private String content;
    private LocalDateTime createDate; // LocalDateTime으로 변경
    private Integer questionId;

    // Answer 엔티티를 AnswerResponse로 변환
    public static AnswerResponse fromEntity(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .createDate(answer.getCreateDate())
                .questionId(
                    answer.getQuestion() != null ? answer.getQuestion().getId() : null
                )
                .build();
    }
    
}
