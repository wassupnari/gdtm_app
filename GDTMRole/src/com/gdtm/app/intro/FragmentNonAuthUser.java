package com.gdtm.app.intro;

import com.facebook.*;
import com.facebook.model.*;
import com.gdtm.app.R;
import com.gdtm.app.control.ActionBarMain;
import com.gdtm.app.view.FacebookFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * This class view is for non-authenticated user
 * 
 * @author wassupnari
 * 
 */
public class FragmentNonAuthUser extends Fragment {

	private FacebookFragment mFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.intro_signup_page, container, false);
		return view;
	}

}
