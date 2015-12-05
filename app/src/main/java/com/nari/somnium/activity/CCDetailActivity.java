package com.nari.somnium.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.nari.toastmate.R;
import com.nari.somnium.helper.DatabaseHelper;
import com.nari.somnium.pojo.CCDataPojo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CCDetailActivity extends BaseActivity implements OnFocusChangeListener {

    @Bind(R.id.speech_title_static)
	public TextView mTitleStatic;
    @Bind(R.id.speech_date_static)
	public TextView mDateStatic;
    @Bind(R.id.speech_eval_static)
	public TextView mEvaluationStatic;
    @Bind(R.id.speech_evaluator_static)
	public TextView mEvaluatorStatic;
    @Bind(R.id.speech_title)
	public TextView mTitleData;
    @Bind(R.id.speech_evaluation)
	public TextView mEvaluationData;
    @Bind(R.id.speech_date)
	public TextView mDateData;
    @Bind(R.id.speech_evaluator)
	public TextView mEvaluatorData;
    @Bind(R.id.speech_title_edit)
	public EditText mTitleEdit;
    @Bind(R.id.speech_evaluator_edit)
	public EditText mEvaluatorEdit;
    @Bind(R.id.speech_date_edit)
	public EditText mDateEdit;
    @Bind(R.id.speech_evaluation_edit)
	public EditText mEvaluationEdit;

	private DatabaseHelper mDB;
	private CCDataPojo mData;

    @Bind(R.id.footer_toggle_cc)
	public ToggleButton mComplete;
	private boolean isComplete;

	private int mID;

	private String[] mDesc;
	private String[] mTime;
	
	private DatePickerDialog.OnDateSetListener mDateSetListener = new OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDate();
		}
	};;
	private int mYear, mMonth, mDay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cc_detail);
        ButterKnife.bind(this);
		mID = getIntent().getIntExtra("cc_id", 0);

		showActionBar(this, "Project " + (mID + 1));

		mDB = new DatabaseHelper(this);
		mData = mDB.getUserCCData(mID);
		mData.setId(mID);
		
		mDesc = getResources().getStringArray(R.array.cc_manual_desc);
		mTime = getResources().getStringArray(R.array.cc_manual_time);
		
		Calendar calendar = Calendar.getInstance();
		mYear = calendar.get(Calendar.YEAR);
		mMonth = calendar.get(Calendar.MONTH);
		mDay = calendar.get(Calendar.DAY_OF_MONTH);

		UISetup();

	}

	public void UISetup() {
		mTitleStatic.setText("Project : ");
		mEvaluatorStatic.setText("Evaluator : ");
		mDateStatic.setText("Date : ");
		mEvaluationStatic.setText("Evaluation : ");

		if (mData != null) {
			mTitleData.setText(mData.getSpeechTitle());
			mEvaluatorData.setText(mData.getEvaluator());
			mDateData.setText(mData.getDate());
			mEvaluationData.setText(mData.getEvaluation());
		}
		
		mDateEdit.setOnFocusChangeListener(this);

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

	@Override
	public void onInfo() {
		super.onInfo();
		final Dialog dialog = new Dialog(CCDetailActivity.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_cc_manual);
		
		TextView desc = (TextView) dialog.findViewById(R.id.dialog_cc_desc);
		desc.setText("Summary : " + mDesc[mID]);
		
		TextView time = (TextView) dialog.findViewById(R.id.dialog_cc_time);
		time.setText("Time : " + mTime[mID]);
		
		Button gotit = (Button) dialog.findViewById(R.id.dialog_cc_gotit);
		gotit.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
			
		});
		
		dialog.show();
	}
	
	
	public void createDatePopup() {
		DatePickerDialog datePicker = new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
		datePicker.show();
	}
	
	public void updateDate() {
		SimpleDateFormat format = new SimpleDateFormat("MMM");
		Calendar setCal = Calendar.getInstance();
		setCal.set(mYear, mMonth, mDay);
		mDateEdit.setText(format.format(setCal.getTime()) + ". " + mDay + ". " + mYear);
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		switch(v.getId()) {
		case R.id.speech_date_edit:
			if(hasFocus) {
				createDatePopup();
			}
			break;
		}
	}

}
