package com.gdtm.app.fragment;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.gdtm.app.R;
import com.gdtm.app.adapter.CLExpandableListAdapter;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class FragmentCL extends Fragment {

	private static final int NUM_OF_CL_PJT = 10;

	private CLExpandableListAdapter mAdapter;

	private ArrayList<String> mGroupItem = new ArrayList<String>();
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_meeting_list, null);

		ExpandableListView expandableListView = (ExpandableListView) view
				.findViewById(R.id.expandable_list_meeting);

		setGroupData();
		setChildData();

		DisplayMetrics metrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;

		mAdapter = new CLExpandableListAdapter(mGroupItem, mChildItem);
		mAdapter.setInflater(inflater, getActivity());
		expandableListView.setAdapter(mAdapter);
		expandableListView.setIndicatorBounds(width - 70, width - 20);

		return view;
	}

	public void setGroupData() {

		// for (int i = 1; i <= NUM_OF_CL_PJT; i++) {
		// mGroupItem.add("Project " + i);
		// }
		mGroupItem.add("Project 1 : Listening");
		mGroupItem.add("Project 2 : Critical Thinking");
		mGroupItem.add("Project 3 : Giving Feedback");
		mGroupItem.add("Project 4 : Time Management");
		mGroupItem.add("Project 5 : Planning and Implementation");
		mGroupItem.add("Project 6 : Organization and Delegation");
		mGroupItem.add("Project 7 : Facilitation");
		mGroupItem.add("Project 8 : Motivation");
		mGroupItem.add("Project 9 : Mentoring");
		mGroupItem.add("Project 10 : Team Building");
	}

	public void setChildData() {

		ArrayList<String> child;

		// PJT #1
		child = new ArrayList<String>();
		child.add("Ah-Counter");
		child.add("Speech Evaluator");
		child.add("Grammarian");
		child.add("Table Topics Speaker");
		mChildItem.add(child);

		// PJT #2
		child = new ArrayList<String>();
		child.add("Speech Evaluator");
		child.add("Grammarian");
		child.add("General Evaluator");
		mChildItem.add(child);

		// PJT #3
		child = new ArrayList<String>();
		child.add("Speech Evaluator");
		child.add("Grammarian");
		child.add("General Evaluator");
		mChildItem.add(child);

		// PJT #4
		child = new ArrayList<String>();
		child.add("Timer");
		child.add("Toastmaster");
		child.add("Speaker");
		child.add("Topicmaster");
		child.add("Grammarian");
		mChildItem.add(child);

		// PJT #5
		child = new ArrayList<String>();
		child.add("Speaker");
		child.add("General Evaluator");
		child.add("Toastmaster");
		child.add("Topicsmaster");
		mChildItem.add(child);

		// PJT #6
		child = new ArrayList<String>();
		child.add("Help Organize a Club Speech Contest");
		child.add("Help Organize a Clup Special Event");
		child.add("Help Organize a Membership Campaign or Contest");
		child.add("Help Organize a Club PR Campaign");
		child.add("Help Produce a Club Newsletter");
		child.add("Assist the Club's Webmaster");
		mChildItem.add(child);

		// PJT #7
		child = new ArrayList<String>();
		child.add("Toastmaster");
		child.add("General Evaluator");
		child.add("Topicsmaster");
		child.add("Befreind a guest");
		mChildItem.add(child);

		// PJT #8
		child = new ArrayList<String>();
		child.add("Membership Compaign or Contest Chair");
		child.add("PR Campaign Chair");
		child.add("Toastmaster");
		child.add("Speech Evaluator");
		child.add("General Evaluator");
		mChildItem.add(child);

		// PJT #9
		child = new ArrayList<String>();
		child.add("Mentor for a New Member");
		child.add("Mentor for an Existing Member");
		child.add("HPL Guidance Committee Member");
		mChildItem.add(child);

		// PJT #10
		child = new ArrayList<String>();
		child.add("Toastmaster");
		child.add("General Evaluator");
		child.add("Membership Campaign Chair");
		child.add("Club PR Campaign Chair");
		child.add("Club Speech Contest Chair");
		child.add("Club Special Event Chair");
		child.add("Club Newsletter Chair");
		child.add("Club Webmaster");
		mChildItem.add(child);

	}
}
