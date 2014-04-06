package com.gdtm.app.fragment;

import com.gdtm.app.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;


public class FragmentDraft extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_draft, null);
		
		EditText draft = (EditText) view.findViewById(R.id.draft_edittext);
		draft.setImeOptions(EditorInfo.IME_ACTION_DONE);

		return view;
	}
}
