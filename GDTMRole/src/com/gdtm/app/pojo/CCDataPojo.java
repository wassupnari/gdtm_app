package com.gdtm.app.pojo;

public class CCDataPojo {

	private int mId;
	private String mProjectTitle;
	private String mSpeechTitle;
	private String mEvaluator;
	private String mDate;

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

}
