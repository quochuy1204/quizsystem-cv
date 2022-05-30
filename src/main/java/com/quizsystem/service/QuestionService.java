package com.quizsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizsystem.dto.QuestionList;
import com.quizsystem.model.Question;

import com.quizsystem.repository.QuestionRepository;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public void saveQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> getAllQuestionByCourseId(int course_id){
		List<Question> questions = new ArrayList<>();
		questions = questionRepository.findAllQuestionByCourseId(course_id);
		return questions;
	}
	
	public Question getQuestionById(int id) {
		Question question = new Question();
		question = questionRepository.getById(id);
		return question;
	}
	
	public void deleteQuestionById(int id) {
		questionRepository.deleteById(id);
	}
	
	// Name: QuocHuyDev
	// Date: 14/09/2021
	// Task: create function to get optional question object for admin to
	// handle the update question functionality
	public Optional<Question> getOptionalQuestionById(int id){
		return questionRepository.findById(id);
	}
	
	//End - 14/09/2021
	
	//Name: Quoc Huy
	//Date: 16/09/2021
	//Task: Get list question by course and return the QuestionList Model
	
	public QuestionList getQuestionAllByCourseId(int courseId) {
		List<Question> questions = new ArrayList<>();
		questions = questionRepository.findAllQuestionByCourseId(courseId);
		
		QuestionList questionList = new QuestionList();
		questionList.setQuestions(questions);
		
		return questionList;
	}
	
	//End - 16/09/2021
	
	//Name: Quoc Huy
	//Task: Get list of all questions
		public List<Question> getAllQuestion(){
			List<Question> questions = questionRepository.findAll();
			return questions;
		}
	//End
}
