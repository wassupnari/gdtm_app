package com.gdtm.app.activity;

import com.gdtm.app.R;
import com.gdtm.app.helper.DatabaseHelper;
import com.gdtm.app.pojo.CLDataPojo;
import com.gdtm.app.pojo.CLSubDataPojo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CLDetailActivity extends BaseActivity {
	
	private TextView mEvaluatorStatic;
	private TextView mEvaluator;
	private EditText mEvaluatorEdit;
	
	private TextView mDateStatic;
	private TextView mDate;
	private EditText mDateEdit;
	
	private TextView mCommentStatic;
	private TextView mComment;
	private EditText mCommentEdit;
	
	private int mProjectNumber;
	private int mSubNumber;
	
	private CLDataPojo mDataList;
	private CLSubDataPojo mData;
	
	private DatabaseHelper mDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cl_detail);
		String title = getIntent().getExtras().getString("cl_detail_title");
		mProjectNumber = getIntent().getIntExtra("cl_group_id", 0);
		mSubNumber = getIntent().getIntExtra("cl_child_id", 0);
		showActionBar(this, title);
		
		mDB = new DatabaseHelper(this);
		
		Log.d("GDTM", "Project number : " + mProjectNumber + ", sub number : " + mSubNumber);
		mDataList = mDB.getUserCLData(mProjectNumber);
		mData = mDataList.getSubData().get(mSubNumber);
		
		setupUI();
		
	}
	
	public void setupUI() {
		mEvaluatorStatic = (TextView) findViewById(R.id.cl_evaluator_static);
		mEvaluator = (TextView) findViewById(R.id.cl_evaluator);
		mEvaluatorEdit = (EditText) findViewById(R.id.cl_evaluator_edit);
		
		mDateStatic = (TextView) findViewById(R.id.cl_date_static);
		mDate = (TextView) findViewById(R.id.cl_date);
		mDateEdit = (EditText) findViewById(R.id.cl_date_edit);
		
		mCommentStatic = (TextView) findViewById(R.id.cl_comment_static);
		mComment = (TextView) findViewById(R.id.cl_comment);
		mCommentEdit = (EditText) findViewById(R.id.cl_comment_edit);
		
		mEvaluatorStatic.setText("Evaluator : ");
		mDateStatic.setText("Date : ");
		mCommentStatic.setText("Comment : ");
		
	}

	@Override
	public void onEdit() {
		super.onEdit();
		mEvaluator.setVisibility(View.GONE);
		mDate.setVisibility(View.GONE);
		mComment.setVisibility(View.GONE);
		
		mEvaluatorEdit.setVisibility(View.VISIBLE);
		mEvaluatorEdit.setText(mData.getEvaluator());
		mDateEdit.setVisibility(View.VISIBLE);
		mDateEdit.setText(mData.getDate());
		mCommentEdit.setVisibility(View.VISIBLE);
		mCommentEdit.setText(mData.getComment());
	}

	@Override
	public void onEditDone() {
		super.onEditDone();
		
		// Hide keyboard
		InputMethodManager inputManager = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
		if (inputManager.isAcceptingText()) {
			inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
		
		mEvaluator.setVisibility(View.VISIBLE);
		mDate.setVisibility(View.VISIBLE);
		mComment.setVisibility(View.VISIBLE);
		
		mEvaluatorEdit.setVisibility(View.GONE);
		mDateEdit.setVisibility(View.GONE);
		mCommentEdit.setVisibility(View.GONE);
		
		String evaluator = mEvaluatorEdit.getText().toString();
		String date = mDateEdit.getText().toString();
		String comment = mCommentEdit.getText().toString();
		
		mData.setEvaluator(evaluator);
		mData.setDate(date);
		mData.setComment(comment);
		
		mEvaluator.setText(evaluator);
		mDate.setText(date);
		mComment.setText(comment);
		
		mDataList.getSubData().set(mProjectNumber, mData);
		
		mDB.updateCL(mDataList);
		
	}
	
	

}
