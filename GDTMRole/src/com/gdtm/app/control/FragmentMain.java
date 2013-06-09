package com.gdtm.app.control;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.view.MyExpandableListAdapter;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

/**
 * This is the main page of role signup.
 * 
 * @author Nari Kim (wassupnari@gmail.com)
 */
public class FragmentMain extends Fragment {

	private final static int NUM_OF_ROLE = 18;

	private MyExpandableListAdapter mAdapter;

	private ArrayList<String> mGroupItem = new ArrayList<String>();
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.control_frag_upcoming_meeting, null);

		ExpandableListView expandableListView = (ExpandableListView) view
				.findViewById(R.id.expandable_list_main);

		setGroupData();
		setChildData();

		mAdapter = new MyExpandableListAdapter(mGroupItem, mChildItem);
		mAdapter.setInflater(inflater, getActivity());
		expandableListView.setAdapter(mAdapter);

		return view;
	}

	public void setGroupData() {

		mGroupItem.add("Toastmaster");
		mGroupItem.add("General Evaluator");
		mGroupItem.add("Table Topic Master");
		mGroupItem.add("Guest Greeter");
		mGroupItem.add("Receptionist");
		mGroupItem.add("Word & Quote Master");
		mGroupItem.add("Quiz Master");
		mGroupItem.add("Timer");
		mGroupItem.add("Grammarian");
		mGroupItem.add("Ah Counter");
		mGroupItem.add("Speaker #1");
		mGroupItem.add("Speaker #2");
		mGroupItem.add("Speaker #3");
		mGroupItem.add("Speaker #4");
		mGroupItem.add("Evaluator #1");
		mGroupItem.add("Evaluator #2");
		mGroupItem.add("Evaluator #3");
		mGroupItem.add("Evaluator $4");
	}

	public void setChildData() {

		ArrayList<String> child;

		for (int i = 0; i < NUM_OF_ROLE; i++) {
			child = new ArrayList<String>();
			child.add("Role taker : ");
			mChildItem.add(child);
		}
	}
}
