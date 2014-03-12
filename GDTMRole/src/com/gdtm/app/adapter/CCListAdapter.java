package com.gdtm.app.adapter;

import java.util.ArrayList;

import com.gdtm.app.fragment.FragmentCC.CCDataPojo;

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

	private ArrayList<CCDataPojo> mData = new ArrayList<CCDataPojo>();

	private LayoutInflater mInflater = null;

	public CCListAdapter(Activity activity, ArrayList<CCDataPojo> data) {
		this.mActivity = activity;
		this.mData = data;
		mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
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
		TextView compeleted = (TextView) vi.findViewById(R.id.cc_title);

		project.setText(mData.get(position).getProject());
		number.setText("Project " + String.valueOf(position + 1));
		return vi;

	}

}
