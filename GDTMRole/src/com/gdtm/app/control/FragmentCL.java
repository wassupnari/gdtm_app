package com.gdtm.app.control;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.gdtm.app.R;
import com.gdtm.app.view.MyExpandableListAdapter;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class FragmentCL extends Fragment {

	private static final int NUM_OF_CL_PJT = 10;

	private MyExpandableListAdapter mAdapter;

	private ArrayList<String> mGroupItem = new ArrayList<String>();
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.control_frag_meeting_list, null);

		ExpandableListView expandableListView = (ExpandableListView) view
				.findViewById(R.id.expandable_list_meeting);

		setGroupData();
		setChildData();

		mAdapter = new MyExpandableListAdapter(mGroupItem, mChildItem);
		mAdapter.setInflater(inflater, getActivity());
		expandableListView.setAdapter(mAdapter);

		return view;
	}

	public void setGroupData() {

		for (int i = 1; i <= NUM_OF_CL_PJT; i++) {
			mGroupItem.add("Project " + i);
		}
	}

	public void setChildData() {

		ArrayList<String> child;

		// PJT #1
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #2
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #3
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #4
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #5
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #6
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #7
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #8
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #9
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

		// PJT #10
		child = new ArrayList<String>();
		child.add("Temp : ");
		mChildItem.add(child);

	}
}
