package com.gdtm.app.adapter;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.activity.CLDetailActivity;
import com.gdtm.app.activity.CCDetailActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CLExpandableListAdapter extends BaseExpandableListAdapter {

	private ArrayList<String> mGroupItem;
	private ArrayList<String> mTempChild;
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	private LayoutInflater mInflater;
	private Activity mActivity;
	
	TextView text;

	public CLExpandableListAdapter(ArrayList<String> grList, ArrayList<Object> childItem) {

		mGroupItem = grList;
		mChildItem = childItem;
	}

	public void setInflater(LayoutInflater inflater, Activity activity) {

		mInflater = inflater;
		mActivity = activity;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {

		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {

		return 0;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild,
			View convertView, ViewGroup parent) {

		mTempChild = (ArrayList<String>) mChildItem.get(groupPosition);
		//TextView text = null;
		// ImageView img = null;

		if (convertView == null) {
			// LayoutInflater inflater = null;
			convertView = mInflater.inflate(R.layout.adapter_list_child_row, null);
		}
		text = (TextView) convertView.findViewById(R.id.child_row);
		// img = (ImageView) convertView.findViewById(R.id.childImage);
		text.setText(mTempChild.get(childPosition));
		convertView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				//Toast.makeText(mActivity, mTempChild.get(childPosition), Toast.LENGTH_SHORT).show();
				Intent speechView = new Intent(mActivity, CLDetailActivity.class);
				speechView.putExtra("cl_group_id", groupPosition);
				speechView.putExtra("cl_child_id", childPosition);
				speechView.putExtra("cl_detail_title", mTempChild.get(childPosition));
				mActivity.startActivity(speechView);
			}
		});
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {

		return ((ArrayList<String>) mChildItem.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {

		return null;
	}

	@Override
	public int getGroupCount() {

		return mGroupItem.size();
	}

	@Override
	public long getGroupId(int groupPosition) {

		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup arg3) {

		mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.adapter_list_group_row, null);
		}
		TextView text = (TextView) convertView.findViewById(R.id.group_row);
		text.setText(mGroupItem.get(groupPosition));
		TextView complete = (TextView) convertView.findViewById(R.id.group_complete);
		complete.setText("complete");
//		((CheckedTextView) convertView).setText(mGroupItem.get(groupPosition));
//		((CheckedTextView) convertView).setChecked(isExpanded);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {

		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {

		return false;
	}

	@Override
	public void onGroupCollapsed(int groupPosition) {

		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) {

		super.onGroupExpanded(groupPosition);
	}

}
