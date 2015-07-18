package com.nari.somnium;

/**
 * 
 * @author Nari Kim Shin (wassupnari@gmail.com)
 *
 */

public class DrawerItem {

	private int mIcon;
	private String mTitle;
	private String mCount = "0";
	
	private boolean mIsCounterVisible = false;
	
	public DrawerItem() {}
	
	public DrawerItem(String title) {
		this.mTitle = title;
		mIsCounterVisible = true;
	}
	public DrawerItem(int icon, String title) {
		super();
		this.mIcon = icon;
		this.mTitle = title;
		
	}
	// Setters
	public void setIcon(int icon) {
		this.mIcon = icon;
	}
	public void setTitle(String title) {
		this.mTitle = title;
	}
	public void setCount(String count) {
		this.mCount = count;
	}
	
	public void setCounterVisibility(boolean isCounterVisible) {
		this.mIsCounterVisible = isCounterVisible;
	}
	// Getters
	public int getIcon() {
		return mIcon;
	}
	public String getTitle() {
		return mTitle;
	}
	
	public boolean isGroupHeader() {
		return mIsCounterVisible;
	}
}
