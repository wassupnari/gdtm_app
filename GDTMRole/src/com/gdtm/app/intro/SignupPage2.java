package com.gdtm.app.intro;

import com.gdtm.app.R;
import com.gdtm.app.control.ActionBarMain;
import com.gdtm.app.view.FacebookFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SignupPage2 extends FragmentActivity {

	private FacebookFragment mFragment;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // Removes
																// notification
																// bar

		if (savedInstanceState == null) {
			// Add the fragment on initial activity setup
			mFragment = new FacebookFragment();
			getSupportFragmentManager().beginTransaction().add(android.R.id.content, mFragment)
					.commit();
		} else {
			// Or set the fragment from restored state info
			mFragment = (FacebookFragment) getSupportFragmentManager().findFragmentById(
					android.R.id.content);
		}

	}
}
