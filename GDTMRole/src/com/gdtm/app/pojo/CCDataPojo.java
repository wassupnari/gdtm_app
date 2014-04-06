package com.gdtm.app.pojo;

import com.google.gson.annotations.Expose;

public class CCDataPojo {

	@Expose
	private int mId;
	@Expose
	private String mProjectTitle;
	@Expose
	private String mSpeechTitle;
	@Expose
	private String mEvaluator;
	@Expose
	private String mDate;
	@Expose
	private String mEvaluation;
	@Expose
	private boolean complete;

	// Later, I'll change all these constructor to Builder Pattern
	public CCDataPojo() {

	}

	public CCDataPojo(int id, String pTitle) {
		mId = id;
		mProjectTitle = pTitle;
	}

	public CCDataPojo(int id, String pTitle, String sTitle, String eval, String date) {

		mId = id;
		mProjectTitle = pTitle;
		mSpeechTitle = sTitle;
		mEvaluator = eval;
		mDate = date;
	}

	public void setId(int id) {

		mId = id;
	}

	public void setProjectTitle(String pTitle) {

		mProjectTitle = pTitle;
	}

	public void setSpeechTitle(String sTitle) {

		mSpeechTitle = sTitle;
	}

	public void setEvaluator(String eval) {

		mEvaluator = eval;
	}

	public void setDate(String date) {

		mDate = date;
	}
	
	public void setEvaluation(String evaluation) {
		mEvaluation = evaluation;
	}
	
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public int getId() {

		return mId;
	}

	public String getProjectTitle() {

		return mProjectTitle;
	}

	public String getSpeechTitle() {

		return mSpeechTitle;
	}

	public String getEvaluator() {

		return mEvaluator;
	}

	public String getDate() {

		return mDate;
	}

	public String getEvaluation() {
		return mEvaluation;
	}
	
	public boolean getComplete() {
		return complete;
	}

}
