package com.gdtm.app.activity;

import com.gdtm.app.R;
import com.gdtm.app.database.DBHandlerCC;
import com.gdtm.app.pojo.CCDataPojo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SpeechActivity extends BaseActivity {
	
	private TextView mTitleStatic;
	private TextView mDateStatic;
	private TextView mEvaluationStatic;
	private TextView mEvaluatorStatic;
	
	private TextView mTitleData;
	private TextView mEvaluationData;
	private TextView mEvaluatorData;
	
	private EditText mTitleEdit;
	private EditText mEvaluatorEdit;
	
	private BaseActivity mBaseActivity;
	
	private DBHandlerCC mDB;
	private CCDataPojo mData;
	
	private int mID;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech);
		
		showActionBar(this, "My Speech");
		
		UISetup();
		
		mDB = new DBHandlerCC(this);
		mID = getIntent().getIntExtra("cc_id", 0);
		Log.d("GDTM", "Selected id : " + mID);
		
	}
	
	public void UISetup() {
		mTitleStatic = (TextView) findViewById(R.id.speech_title_static);
		mTitleData = (TextView) findViewById(R.id.speech_title);
		mTitleStatic.setText("Project : ");
		mTitleEdit = (EditText) findViewById(R.id.speech_title_edit);
		
		mEvaluatorStatic = (TextView) findViewById(R.id.speech_evaluator_static);
		mEvaluatorStatic.setText("Evaluator : ");
		mEvaluatorData = (TextView) findViewById(R.id.speech_evaluator);
		mEvaluatorEdit = (EditText) findViewById(R.id.speech_evaluator_edit);
		
		mDateStatic = (TextView) findViewById(R.id.speech_date_static);
		mDateStatic.setText("Date : ");
		
		mEvaluationStatic = (TextView) findViewById(R.id.speech_eval_static);
		mEvaluationStatic.setText("Evaluation : ");
		mEvaluationData = (TextView) findViewById(R.id.speech_evaluation);
		
	}

	@Override
	public void onEdit() {
		super.onEdit();
		mTitleData.setVisibility(View.GONE);
		mEvaluatorData.setVisibility(View.GONE);
		mTitleEdit.setVisibility(View.VISIBLE);
		mEvaluatorEdit.setVisibility(View.VISIBLE);
	}

	@Override
	public void onEditDone() {
		super.onEditDone();
		mTitleData.setVisibility(View.VISIBLE);
		mEvaluatorData.setVisibility(View.VISIBLE);
		mTitleEdit.setVisibility(View.GONE);
		mEvaluatorEdit.setVisibility(View.GONE);
		
		// Hide keyboard
		
		// Save data to DB
		mData = new CCDataPojo();
		String title = mTitleEdit.getText().toString();
		mData.setSpeechTitle(title);
		mData.setEvaluator(mEvaluatorEdit.getText().toString());
		mTitleData.setText(title);
		mDB.addCCData(mID, mData);
	}
	
	
	
	

}
