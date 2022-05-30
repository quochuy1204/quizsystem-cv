package com.quizsystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizsystem.dto.QuestionList;
import com.quizsystem.model.Question;
import com.quizsystem.model.Result;
import com.quizsystem.repository.ResultRepository;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepository;
	
	//This method will check the answer of the user and increase the correct score if the answer is correct
	public int getCorrectScore(QuestionList questionList) {
		int correctScore = 0;
		for (Question question : questionList.getQuestions()) {
			if(question.getAnswer() == question.getChose()) {
				correctScore = correctScore + 1;
			}
		}
		
		return correctScore;
	}
	
	//This method will save the result into the Database
	public void saveResult(Result result) {
		resultRepository.save(result);
	}
	
	// This method will show list result due to course_id and user_id
	public List<Result> getResultByCourseIdAndUserId(int courseId , int userId){
		List<Result> results = new ArrayList<>();
		results = resultRepository.getResultByCourseIdAndUserId(courseId, userId);
		return results;
	}
}
