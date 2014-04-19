package com.gdtm.app.activity;

import com.gdtm.app.R;
import com.gdtm.app.helper.DatabaseHelper;
import com.gdtm.app.pojo.CCDataPojo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CCDetailActivity extends BaseActivity {

	private TextView mTitleStatic;
	private TextView mDateStatic;
	private TextView mEvaluationStatic;
	private TextView mEvaluatorStatic;

	private TextView mTitleData;
	private TextView mEvaluationData;
	private TextView mDateData;
	private TextView mEvaluatorData;

	private EditText mTitleEdit;
	private EditText mEvaluatorEdit;
	private EditText mDateEdit;
	private EditText mEvaluationEdit;

	private DatabaseHelper mDB;
	private CCDataPojo mData;

	private ToggleButton mComplete;
	private boolean isComplete;

	private int mID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cc_detail);

		mID = getIntent().getIntExtra("cc_id", 0);

		showActionBar(this, "Project " + (mID + 1));

		mDB = new DatabaseHelper(this);
		mData = mDB.getUserCCData(mID);
		mData.setId(mID);

		UISetup();

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
		mDateData = (TextView) findViewById(R.id.speech_date);
		mDateEdit = (EditText) findViewById(R.id.speech_date_edit);

		mEvaluationStatic = (TextView) findViewById(R.id.speech_eval_static);
		mEvaluationStatic.setText("Evaluation : ");
		mEvaluationData = (TextView) findViewById(R.id.speech_evaluation);
		mEvaluationEdit = (EditText) findViewById(R.id.speech_evaluation_edit);

		if (mData != null) {
			mTitleData.setText(mData.getSpeechTitle());
			mEvaluatorData.setText(mData.getEvaluator());
			mDateData.setText(mData.getDate());
			mEvaluationData.setText(mData.getEvaluation());
		}

		mComplete = (ToggleButton) findViewById(R.id.footer_toggle_cc);
		if (mData.getComplete()) {
			mComplete.setChecked(true);
		} else {
			mComplete.setChecked(false);
		}

		mComplete.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mData.setComplete(isChecked);
				mDB.updateCC(mData);
				//CCDetailActivity.this.finish();
			}

		});

	}

	@Override
	public void onEdit() {
		super.onEdit();
		mTitleData.setVisibility(View.GONE);
		mEvaluatorData.setVisibility(View.GONE);
		mDateData.setVisibility(View.GONE);
		mEvaluationData.setVisibility(View.GONE);

		mTitleEdit.setVisibility(View.VISIBLE);
		if (mData.getSpeechTitle().equalsIgnoreCase("None")) {
			// Show place holder
		} else {
			mTitleEdit.setText(mData.getSpeechTitle());
		}

		mEvaluatorEdit.setVisibility(View.VISIBLE);
		mEvaluatorEdit.setText(mData.getEvaluator());

		mDateEdit.setVisibility(View.VISIBLE);
		mDateEdit.setText(mData.getDate());

		mEvaluationEdit.setVisibility(View.VISIBLE);
		mEvaluationEdit.setText(mData.getEvaluation());
	}

	@Override
	public void onEditDone() {
		super.onEditDone();

		// Hide keyboard
		InputMethodManager inputManager = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
		if (inputManager.isAcceptingText()) {
			inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}

		mTitleData.setVisibility(View.VISIBLE);
		mEvaluatorData.setVisibility(View.VISIBLE);
		mDateData.setVisibility(View.VISIBLE);
		mEvaluationData.setVisibility(View.VISIBLE);

		mTitleEdit.setVisibility(View.GONE);
		mEvaluatorEdit.setVisibility(View.GONE);
		mDateEdit.setVisibility(View.GONE);
		mEvaluationEdit.setVisibility(View.GONE);

		// Save data to DB
		String title = mTitleEdit.getText().toString();
		String evaluator = mEvaluatorEdit.getText().toString();
		String date = mDateEdit.getText().toString();
		String evaluation = mEvaluationEdit.getText().toString();

		if (title.equalsIgnoreCase("")) {
			mData.setSpeechTitle("None");
		} else {
			mData.setSpeechTitle(title);
		}

		mData.setEvaluator(evaluator);
		mData.setDate(date);
		mData.setEvaluation(evaluation);

		mEvaluatorData.setText(evaluator);
		mEvaluationData.setText(evaluation);
		mTitleData.setText(title);
		mDateData.setText(date);

		mDB.updateCC(mData);

	}

}
