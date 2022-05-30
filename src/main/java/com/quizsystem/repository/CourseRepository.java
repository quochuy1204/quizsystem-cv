package com.quizsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizsystem.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
