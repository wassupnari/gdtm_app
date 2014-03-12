package com.gdtm.app.activity;

import com.gdtm.app.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class SpeechActivity extends BaseActivity {
	
	private TextView mProjectTitle;
	private TextView mProjectDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech);
		
		showActionBar(this, "My Speech");
		
		
		mProjectTitle = (TextView) findViewById(R.id.speech_title_static);
		mProjectTitle.setText("Project : ");
		
		mProjectDate = (TextView) findViewById(R.id.speech_date_static);
		mProjectDate.setText("Date : ");
	}

}
