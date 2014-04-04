package com.gdtm.app.pojo;

import com.google.gson.annotations.Expose;


public class CLSubDataPojo {
	@Expose
	private String subProjectTitle;
	@Expose
	private String evaluator;
	@Expose
	private String date;
	@Expose
	private String comment;
	
	public String getSubProjectTitle() {
		return subProjectTitle;
	}
	
	public void setSubProjectTitle(String title) {
		this.subProjectTitle = title;
	}
	
	public String getEvaluator() {
		return evaluator;
	}
	
	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
