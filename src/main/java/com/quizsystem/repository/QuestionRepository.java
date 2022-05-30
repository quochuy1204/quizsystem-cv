package com.quizsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizsystem.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	@Query(value = "SELECT * FROM question WHERE question.course_course_id = :course_id" , nativeQuery = true)
	List<Question> findAllQuestionByCourseId(@Param("course_id") int course_id);
}
