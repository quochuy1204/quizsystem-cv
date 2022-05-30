package com.quizsystem.dto;

public class QuestionDto {
	private int id;
	private String title;
	private int courseId;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private int answer;
	private int chose;

	public QuestionDto(int id, String title, int courseId, String optionA, String optionB, String optionC,
			String optionD, int answer, int chose) {
		super();
		this.id = id;
		this.title = title;
		this.courseId = courseId;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.chose = chose;
	}

	public QuestionDto(String title, int courseId, String optionA, String optionB, String optionC, String optionD,
			int answer, int chose) {
		super();
		this.title = title;
		this.courseId = courseId;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.chose = chose;
	}

	public QuestionDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public int getChose() {
		return chose;
	}

	public void setChose(int chose) {
		this.chose = chose;
	}

	@Override
	public String toString() {
		return "QuestionDto [id=" + id + ", title=" + title + ", courseId=" + courseId + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", answer=" + answer
				+ ", chose=" + chose + "]";
	}

}
