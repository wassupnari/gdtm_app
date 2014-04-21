package com.nari.somnium.adapter;

import com.gdtm.app.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class CLManualDialogAdapter extends BaseAdapter {

	private Activity mActivity;

	private LayoutInflater mInflater = null;

	private String[] mRole;
	private String[] mRoleDesc;

	public CLManualDialogAdapter(Activity activity) {
		mActivity = activity;
		mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mRole = mActivity.getResources().getStringArray(R.array.cl_manual_role);
		mRoleDesc = mActivity.getResources().getStringArray(R.array.cl_manual_role_desc);
	}

	@Override
	public int getCount() {
		return 7;
	}

	@Override
	public Object getItem(int position) {
		return mRole[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = mInflater.inflate(R.layout.adapter_cl_dialog, null);

		TextView role = (TextView) view.findViewById(R.id.cl_dialog_role);
		TextView desc = (TextView) view.findViewById(R.id.cl_dialog_role_desc);

		role.setText(mRole[position]);
		desc.setText(mRoleDesc[position]);

		return view;
	}

}
