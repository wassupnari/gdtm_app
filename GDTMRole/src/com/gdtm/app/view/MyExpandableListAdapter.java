package com.gdtm.app.view;

import java.util.ArrayList;

import com.gdtm.app.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {

	private ArrayList<String> mGroupItem;
	private ArrayList<String> mTempChild;
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	private LayoutInflater mInflater;
	private Activity mActivity;

	public MyExpandableListAdapter(ArrayList<String> grList, ArrayList<Object> childItem) {

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
	public View getChildView(int groupPosition, final int childPosition, boolean isLastChild,
			View convertView, ViewGroup parent) {

		mTempChild = (ArrayList<String>) mChildItem.get(groupPosition);
		TextView text = null;
		// ImageView img = null;

		if (convertView == null) {
			// LayoutInflater inflater = null;
			convertView = mInflater.inflate(R.layout.view_list_child_row, null);
		}
		text = (TextView) convertView.findViewById(R.id.child_row);
		// img = (ImageView) convertView.findViewById(R.id.childImage);
		text.setText(mTempChild.get(childPosition));
		if (childPosition == (mTempChild.size() - 1)) {
			// img.setImageResource(R.drawable.dh);
		}
		if (childPosition == mTempChild.size()) {
			// img.setImageResource(R.drawable.dj);
		}
		convertView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(mActivity, mTempChild.get(childPosition), Toast.LENGTH_SHORT).show();
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

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.view_list_group_row, null);
		}
		((CheckedTextView) convertView).setText(mGroupItem.get(groupPosition));
		((CheckedTextView) convertView).setChecked(isExpanded);
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
