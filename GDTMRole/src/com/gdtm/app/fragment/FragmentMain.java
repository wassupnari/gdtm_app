package com.gdtm.app.fragment;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.adapter.MyExpandableListAdapter;

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
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */
public class FragmentMain extends Fragment {

	private static final int NUM_OF_ROLE = 18;

	private MyExpandableListAdapter mAdapter;

	private ArrayList<String> mGroupItem = new ArrayList<String>();
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_upcoming_meeting, null);


		return view;
	}

	
}
