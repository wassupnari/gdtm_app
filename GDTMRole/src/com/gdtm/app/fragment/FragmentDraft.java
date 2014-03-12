package com.gdtm.app.fragment;

import com.gdtm.app.R;
import com.gdtm.app.adapter.CCListAdapter;
import com.gdtm.app.database.DBHandlerCC;
import com.gdtm.app.fragment.FragmentCC.CCDataPojo;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class FragmentDraft extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_draft, null);

		return view;
	}
}
