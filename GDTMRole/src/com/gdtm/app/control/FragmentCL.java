package com.gdtm.app.control;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdtm.app.R;

public class FragmentCL extends Fragment {
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.control_frag_cl, null);
		//GridView listView = (GridView) view.findViewById(R.id.cc_scroll);
		//listView.setAdapter(new Adapter());
		return view;
	}

}
