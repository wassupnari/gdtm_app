package com.gdtm.app.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CLDataPojo {
	@Expose
	private int id;
	@Expose
	private String projectTitle;
	@Expose
	private ArrayList<CLSubDataPojo> subData = new ArrayList<CLSubDataPojo>();
	@Expose
	private boolean complete;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProjectTitle() {
		return projectTitle;
	}
	
	public void setProjectTitle(String title) {
		this.projectTitle = title;
	}
	
	public ArrayList<CLSubDataPojo> getSubData() {
		return subData;
	}
	
	public void setSubData(ArrayList<CLSubDataPojo> data) {
		this.subData = data;
	}
	
	public boolean getComplete() {
		return complete;
	}
	
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
