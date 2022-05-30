package com.quizsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "score")
	private int score;

	public Result(int id, int userId, String userName, int courseId, String courseName, int score) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.score = score;
	}

	public Result(int userId, String userName, int courseId, String courseName, int score) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.score = score;
	}

	public Result() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", userId=" + userId + ", userName=" + userName + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", score=" + score + "]";
	}

}
