package com.nari.somnium.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.nari.toastmate.R;
import com.nari.somnium.adapter.CLManualDialogAdapter;
import com.nari.somnium.helper.DatabaseHelper;
import com.nari.somnium.pojo.CLDataPojo;
import com.nari.somnium.pojo.CLSubDataPojo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CLDetailActivity extends BaseActivity implements OnFocusChangeListener{

    @Bind(R.id.cl_evaluator)
	public TextView mEvaluator;
    @Bind(R.id.cl_evaluator_edit)
	public EditText mEvaluatorEdit;
    @Bind(R.id.cl_date)
	public TextView mDate;
    @Bind(R.id.cl_date_edit)
	public EditText mDateEdit;
    @Bind(R.id.cl_comment)
	public TextView mComment;
    @Bind(R.id.cl_comment_edit)
	public EditText mCommentEdit;

	private int mSubNumber;

	private CLDataPojo mDataList;
	private CLSubDataPojo mData;

	private DatabaseHelper mDB;
	
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
		setContentView(R.layout.activity_cl_detail);
        ButterKnife.bind(this);
		String title = getIntent().getExtras().getString("cl_detail_title");
        int mProjectNumber = getIntent().getIntExtra("cl_group_id", 0);
		mSubNumber = getIntent().getIntExtra("cl_child_id", 0);
		showActionBar(this, title);

		mDB = new DatabaseHelper(this);

		mDataList = mDB.getUserCLData(mProjectNumber);
		mDataList.setId(mProjectNumber);
		mData = mDataList.getSubData().get(mSubNumber);
		
		Calendar calendar = Calendar.getInstance();
		mYear = calendar.get(Calendar.YEAR);
		mMonth = calendar.get(Calendar.MONTH);
		mDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		setupUI();

	}

	public void setupUI() {
        TextView mEvaluatorStatic = (TextView) findViewById(R.id.cl_evaluator_static);
        TextView mDateStatic = (TextView) findViewById(R.id.cl_date_static);
		mDateEdit.setOnFocusChangeListener(this);
        TextView mCommentStatic = (TextView) findViewById(R.id.cl_comment_static);
		mEvaluatorStatic.setText("Evaluator : ");
		mDateStatic.setText("Date : ");
		mCommentStatic.setText("Comment : ");

		if (mData != null) {
			mEvaluator.setText(mData.getEvaluator());
			mDate.setText(mData.getDate());
			mComment.setText(mData.getComment());
		}

        ToggleButton mComplete = (ToggleButton) findViewById(R.id.footer_toggle_cl);
		if (mData.getComplete()) {
			mComplete.setChecked(true);
		} else {
			mComplete.setChecked(false);
		}

		mComplete.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mData.setComplete(isChecked);
				mDataList.getSubData().set(mSubNumber, mData);
				mDB.updateCL(mDataList);
			}

		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mData = null;
		mDataList = null;
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
			inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}

		mEvaluator.setVisibility(View.VISIBLE);
		mDate.setVisibility(View.VISIBLE);
		mComment.setVisibility(View.VISIBLE);

		String evaluator = mEvaluatorEdit.getText().toString();
		String date = mDateEdit.getText().toString();
		String comment = mCommentEdit.getText().toString();

		mEvaluatorEdit.setVisibility(View.GONE);
		mDateEdit.setVisibility(View.GONE);
		mCommentEdit.setVisibility(View.GONE);

		mData.setEvaluator(evaluator);
		mData.setDate(date);
		mData.setComment(comment);

		mEvaluator.setText(evaluator);
		mDate.setText(date);
		mComment.setText(comment);

		mDataList.getSubData().set(mSubNumber, mData);
		
		mDB.updateCL(mDataList);

	}

	@Override
	public void onInfo() {
		super.onInfo();
		final Dialog dialog = new Dialog(CLDetailActivity.this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_cl_manual);

		ListView list = (ListView) dialog.findViewById(R.id.dialog_cl_list);
		list.setAdapter(new CLManualDialogAdapter(this));

		Button gotit = (Button) dialog.findViewById(R.id.dialog_cl_gotit);
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
		case R.id.cl_date_edit:
			if(hasFocus) {
				createDatePopup();
			}
			break;
		}
	}

}
