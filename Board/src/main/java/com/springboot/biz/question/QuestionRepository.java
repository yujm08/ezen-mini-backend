package com.springboot.biz.question;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<Question, Integer>{
	/* 각종 메소드를 가지고 있음
	 * 
	 * save()         데이터를 저장 insert구문을 이용해서 만든 메소드 insert into answer
	 * findByAll()    select 메소드 해당 전체검색 select * from answer
	 * findById()     조건에 만족하는 값 검색   select
	 */
	
	/*제목을 기준으로 select 하는 sql문 작성
	 * select
	 */
	
	//findBy"이름규칙"에 의해 자동으로 method가 생성
	Question findBySubject(String subject); //select * from question where subject =? ;
	Question findBySubjectAndContent(String subject, String content);
	Question findBySubjectOrContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	Page<Question> findAll(Pageable pageable);
	
	

}
