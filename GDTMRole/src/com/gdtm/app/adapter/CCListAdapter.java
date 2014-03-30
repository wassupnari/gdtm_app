package com.gdtm.app.adapter;

import java.util.ArrayList;

import com.gdtm.app.database.DBHandlerCC;

import com.gdtm.app.R;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CCListAdapter extends BaseAdapter {

	private Activity mActivity;

	private LayoutInflater mInflater = null;
	
	private DBHandlerCC mDB;

	public CCListAdapter(Activity activity) {
		this.mActivity = activity;
		mDB = new DBHandlerCC(activity);
		mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

		project.setText("");
		number.setText("Project " + String.valueOf(position + 1));
		title.setText("Title : " + mDB.getUserCCData(position).getSpeechTitle());
		return vi;

	}

}
