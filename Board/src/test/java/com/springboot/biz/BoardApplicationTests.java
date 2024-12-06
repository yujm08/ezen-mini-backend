package com.springboot.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
		
//		Question q1 = new Question();
//		q1.setSubject("주제");
//		q1.setContent("내용");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//		
//		Question q2 = new Question();
//		q2.setSubject("스프링 부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요? ");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
		
//		List<Question> all = this.questionRepository.findAll();
//		System.out.println("총 객체수" + all.size());
//		
//		assertEquals(4, all.size());
//		Question q = all.get(0);
//		System.out.println(q.getSubject());
//		System.out.println(q.getContent());
//		System.out.println(q.getCreateDate());
//		System.out.println(q.getId());
//		
//		assertEquals("게시판이 무엇인가요?", q.getSubject());
		
		//Question q = this.questionRepository.findBySubject("주제");
		Question q = this.questionRepository.findBySubjectAndContent("주제", "내용");
		System.out.println(q.getId());
		System.out.println(q.getCreateDate());
		System.out.println(q.getSubject());
		System.out.println(q.getContent());
		
	}

}
