package com.gdtm.app.control;

import com.gdtm.app.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class FragmentCC extends Fragment {
	private String arry[] = { "Tofeeq", "Ahmad", "Fragment", "Example",
			"Tofeeq", "Ahmad", "Fragment", "Example" };
	
	

//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		
//		setContentView(R.layout.control_frag_cc);
//	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.control_frag_cc, null);
		//GridView listView = (GridView) view.findViewById(R.id.cc_scroll);
		//listView.setAdapter(new Adapter());
		return view;
	}

}
