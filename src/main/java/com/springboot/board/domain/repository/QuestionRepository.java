import com.springboot.board.domain.entity.Question;

package com.springboot.board.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    //@NonNull 어노테이션은 Spring Data JPA의 인터페이스에서 요구되는 사항으로, 
    //이를 통해 코드의 명확성과 안정성을 높일 수 있음.
    @NonNull
    Page<Question> findAll(@NonNull Pageable pageable);
} 