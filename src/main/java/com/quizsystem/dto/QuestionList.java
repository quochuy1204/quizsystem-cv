package com.quizsystem.dto;

import java.util.List;

import com.quizsystem.model.Question;

public class QuestionList {
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
