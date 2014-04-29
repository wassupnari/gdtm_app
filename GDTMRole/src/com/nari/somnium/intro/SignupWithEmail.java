package com.nari.somnium.intro;

import com.nari.toastmate.R;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class SignupWithEmail extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro_signup_with_email);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

}
