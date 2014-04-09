package com.gdtm.app.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class PreferenceHelper {

	private SharedPreferences sharedPreferences;
	private Editor editor;

	public PreferenceHelper(Context context) {
		this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		this.editor = sharedPreferences.edit();
	}

	public void putStringInPreferences(String key, String value) {
		editor.putString(key, value);
		editor.commit();
	}

	public void putLongInPreferences(String key, long value) {
		editor.putLong(key, value);
		editor.commit();
	}
	
	public String getStringFromPreferences(String key, String blank) {
		return sharedPreferences.getString(key, blank);
	}

	public long getLongFromPreferences(String key, long blank) {
		return sharedPreferences.getLong(key, blank);
	}

}
