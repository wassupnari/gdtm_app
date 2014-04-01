package com.gdtm.app.activity;

import com.gdtm.app.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CLDetailActivity extends BaseActivity {
	
	private TextView mEvaluatorStatic;
	private TextView mEvaluator;
	private EditText mEvaluatorEdit;
	
	private TextView mCommentStatic;
	private TextView mComment;
	private EditText mCommentEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cl_detail);
		
		showActionBar(this, "Project ");
		
		setupUI();
		
	}
	
	public void setupUI() {
		mEvaluatorStatic = (TextView) findViewById(R.id.cl_evaluator_static);
		mEvaluator = (TextView) findViewById(R.id.cl_evaluator);
		mEvaluatorEdit = (EditText) findViewById(R.id.cl_evaluator_edit);
		
		mCommentStatic = (TextView) findViewById(R.id.cl_comment_static);
		mComment = (TextView) findViewById(R.id.cl_comment);
		mCommentEdit = (EditText) findViewById(R.id.cl_comment_edit);
		
		mEvaluatorStatic.setText("Evaluator : ");
		mCommentStatic.setText("Comment : ");
		
	}

	@Override
	public void onEdit() {
		super.onEdit();
		mEvaluator.setVisibility(View.GONE);
		mComment.setVisibility(View.GONE);
		mEvaluatorEdit.setVisibility(View.VISIBLE);
		mCommentEdit.setVisibility(View.VISIBLE);
	}

	@Override
	public void onEditDone() {
		super.onEditDone();
		
		mEvaluator.setVisibility(View.VISIBLE);
		mComment.setVisibility(View.VISIBLE);
		mEvaluatorEdit.setVisibility(View.GONE);
		mComment.setVisibility(View.GONE);
	}
	
	

}
