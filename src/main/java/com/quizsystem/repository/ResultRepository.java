package com.quizsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quizsystem.model.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer>{
	
	@Query(value = "Select * from result where course_id = :courseId and user_id = :userId", nativeQuery = true)
	List<Result> getResultByCourseIdAndUserId(@Param("courseId") int courseId, @Param("userId") int useId);
}
