package com.springboot.board.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AccessLevel;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject; //

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate; // 질문이 생성된 날짜 및 시간

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answers;

    // 원본코드는 setter를 사용하고 있어 객체의 상태를 변경할 수 있어 불안정하다.
    // 따라서 생성자를 사용하여 객체를 생성하는 것이 좋다.
    // 그래서 Builder 패턴을 사용하여 질문 객체를 생성하기 위한 생성자를 추가한다.
    @Builder
    public Question(String subject, String content) {
        this.subject = subject; // 제목 설정
        this.content = content; // 내용 설정
        this.createDate = LocalDateTime.now(); // 현재 시간으로 생성일 설정
    }
}