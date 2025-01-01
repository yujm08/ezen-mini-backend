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


@Entity // 이 클래스가 JPA 엔티티임을 나타냄
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자를 protected로 설정하여 외부에서 직접 인스턴스를 생성하지 못하도록 함
@Getter // 모든 필드에 대한 getter 메서드를 자동 생성
public class Question {
    
    @Id // 이 필드가 엔티티의 식별자임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 식별자 값을 자동으로 생성하도록 설정
    private Integer id; // 질문의 고유 ID
    
    @Column(length = 200) // 데이터베이스에서 이 필드의 길이를 200자로 제한
    private String subject; // 질문의 제목
    
    @Column(columnDefinition = "TEXT") // 데이터베이스에서 이 필드의 타입을 TEXT로 설정
    private String content; // 질문의 내용
    
    private LocalDateTime createDate; // 질문이 생성된 날짜 및 시간
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 질문에 대한 답변 목록을 설정
    private List<Answer> answers; // 질문에 대한 답변 리스트

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