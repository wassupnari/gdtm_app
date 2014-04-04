package com.gdtm.app.pojo;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;


public class CLDataPojo {
	@Expose
	private int id;
	@Expose
	private String projectTitle;
	@Expose
	private ArrayList<CLSubDataPojo> subData;
	@Expose
	private String complete;
	
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
	
	public String getComplete() {
		return complete;
	}
	
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
}
