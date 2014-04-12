package com.gdtm.app.fragment;

import com.gdtm.app.MainActivity;
import com.gdtm.app.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class FragmentDraft extends Fragment {
	
	private TextView mDraft;
	private EditText mDraftEdit;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_draft, null);
		
		MainActivity.setShowEditButton(true);
		
		mDraft = (TextView) view.findViewById(R.id.draft_data);
		mDraftEdit = (EditText) view.findViewById(R.id.draft_edittext);
		mDraftEdit.setImeOptions(EditorInfo.IME_ACTION_DONE);
		
//		View actionbarView = getActivity().getActionBar().getCustomView();
//		ToggleButton editButton = (ToggleButton) actionbarView.findViewById(R.id.actionbar_edit_btn_main);
//		editButton.setOnClickListener(new ToggleButton.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				mDraftEdit.setVisibility(View.VISIBLE);
//				mDraft.setVisibility(View.GONE);
//			}
//			
//		});
		
		

		return view;
	}
}
