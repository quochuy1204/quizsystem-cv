package com.quizsystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private int id;

	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_description")
	private String courseDescription;

	@OneToMany(mappedBy = "course")
	private List<Question> questions;

	public Course(int id, String courseName, String courseDescription, List<Question> questions) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.questions = questions;
	}

	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription
				+ ", questions=" + questions + "]";
	}

}
