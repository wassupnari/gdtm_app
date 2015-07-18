package com.nari.somnium.fragment;

import com.nari.toastmate.R;
import com.nari.somnium.MainActivity;
import com.nari.somnium.MainActivity.OnMainMenuEditButtonListener;
import com.nari.somnium.helper.DatabaseHelper;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;


public class FragmentDraft extends Fragment {
	
	private TextView mDraft;
	private EditText mDraftEdit;
	
	private DatabaseHelper mDB;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_draft, null);
		
		mDB = new DatabaseHelper(getActivity());
		
		
		mDraft = (TextView) view.findViewById(R.id.draft_data);
		mDraftEdit = (EditText) view.findViewById(R.id.draft_edittext);
		mDraftEdit.setImeOptions(EditorInfo.IME_ACTION_DONE);
		
		if(!mDB.checkDraftExists(0)) {
			Log.d("GDTM", "Not exist!");
			mDB.addDraftData(0, "");
		} else {
			String dbString = mDB.getDraftData(0);
			mDraft.setText(dbString);
		}
		
		MainActivity.setShowEditButton(true);
		MainActivity.setOnMainMenuEditButtonListener(new OnMainMenuEditButtonListener() {

			@Override
			public void onMainMenuEditButtonListener(boolean isChecked) {
				if(isChecked) {
					mDraftEdit.setVisibility(View.VISIBLE);
					mDraft.setVisibility(View.GONE);
					String dbDraft = mDB.getDraftData(0);
					if(!dbDraft.equalsIgnoreCase("")) {
						mDraftEdit.setText(dbDraft);
					}
				} else {
					hideKeyboard();
					mDraftEdit.setVisibility(View.GONE);
					mDraft.setVisibility(View.VISIBLE);
					
					String draft = mDraftEdit.getText().toString();
					
					mDraft.setText(draft);
					
					mDB.updateDraft(0, draft);
				}
				
			}
			
		});
		
		return view;
	}

	public void hideKeyboard() {
		InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(getActivity().getApplicationContext().INPUT_METHOD_SERVICE);
		if (inputManager.isAcceptingText()) {
			inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
}
