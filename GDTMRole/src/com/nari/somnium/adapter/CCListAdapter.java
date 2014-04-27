package com.nari.somnium.adapter;

import java.util.ArrayList;

import com.nari.somnium.R;
import com.nari.somnium.helper.DatabaseHelper;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CCListAdapter extends BaseAdapter {

	private Activity mActivity;

	private LayoutInflater mInflater = null;

	private DatabaseHelper mDB;
	
	private String[] mProject;

	public CCListAdapter(Activity activity) {
		this.mActivity = activity;
		mDB = new DatabaseHelper(activity);
		mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mProject = mActivity.getResources().getStringArray(R.array.cc_manual_title);
	}

	@Override
	public int getCount() {
		return mDB.getCCCount();
	}

	@Override
	public Object getItem(int position) {
		return mDB.getUserCCData(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = mInflater.inflate(R.layout.adapter_cc_row, null);

		TextView project = (TextView) vi.findViewById(R.id.cc_project_title);
		TextView number = (TextView) vi.findViewById(R.id.cc_number);
		TextView title = (TextView) vi.findViewById(R.id.cc_title);
		ImageView complete = (ImageView) vi.findViewById(R.id.cc_complete_img);

		project.setText("");
		number.setText(String.valueOf(position + 1) + ". " + mProject[position]);
		title.setText("Title : " + mDB.getUserCCData(position).getSpeechTitle());

		if (mDB.getUserCCData(position).getComplete()) {
			complete.setImageDrawable(mActivity.getResources().getDrawable(R.drawable.complete_active));
		} else {
			complete.setImageDrawable(mActivity.getResources().getDrawable(R.drawable.complete_inactive));
		}
		return vi;

	}

}
