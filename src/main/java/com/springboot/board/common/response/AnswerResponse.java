package com.springboot.board.common.response;

import lombok.Builder;
import lombok.Getter;
import com.springboot.board.domain.entity.Answer;

@Getter
@Builder
public class AnswerResponse {
    private Integer id; // 답변 ID
    private String content; // 답변 내용
    private String createDate; // 생성 날짜
    private Integer questionId; // 질문 ID

    // Answer -> AnswerResponse 변환
    public static AnswerResponse fromEntity(Answer answer) {
        return AnswerResponse.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .createDate(answer.getCreateDate().toString()) // 필요 시 DateTimeUtil.format 사용
                .questionId(answer.getQuestion().getId())
                .build();
    }
}

