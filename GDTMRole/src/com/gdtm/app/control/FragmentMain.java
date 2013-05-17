package com.gdtm.app.control;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * This is the main page of role signup.
 * @author Nari Kim (wassupnari@gmail.com)
 */
public class FragmentMain extends Fragment {
	private String arry[] = { "Theme", "Toastmaster", "General Evaluator", "Table Topic Master",
			"Guest Greeter", "Receptionist", "Word & Quote Master", "Quiz Master", "Timer",
			"Grammarian", "Ah Counter", "Speaker #1", "Evaluator #1", "Speaker #2", "Evaluator #2",
			"Speacker #3", "Evaluator #3", "Stanby Speaker", "Stanby Evaluator"};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ListView listView = new ListView(getActivity());
		ArrayAdapter<String> array = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
		for (String str : arry)
			array.add(str);
		listView.setAdapter(array);
		return listView;
	}
}
