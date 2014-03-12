package com.gdtm.app.view;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;
import com.gdtm.app.MainActivity;
import com.gdtm.app.R;
import com.gdtm.app.intro.SignupPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FacebookFragment extends Fragment {
/*
	private UiLifecycleHelper uiHelper;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.intro_signup_page, container, false);

		LoginButton authButton = (LoginButton) view.findViewById(R.id.login_button);
		authButton.setFragment(this);

		Button mLoginWithEmail = (Button) view.findViewById(R.id.btn_login);
		mLoginWithEmail.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Start main view after sign in
				Intent intent = new Intent(getActivity().getApplicationContext(),
						MainActivity.class);
				startActivity(intent);
				getActivity().finish();
			}

		});

		Button mSignup = (Button) view.findViewById(R.id.btn_signup_email);
		mSignup.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

			}
		});

		return view;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {

		super.onResume();

		// For scenarios where the main activity is launched and user
		// session is not null, the session state change notification
		// may not be triggered. Trigger it if it's open/closed.
		Session session = Session.getActiveSession();
		if (session != null && (session.isOpened() || session.isClosed())) {
			onSessionStateChange(session, session.getState(), null);
		}

		uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {

		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	private void onSessionStateChange(Session session, SessionState state, Exception exception) {

		if (state.isOpened()) {
			Log.i("GDTM", "Logged in...");
		} else if (state.isClosed()) {
			Log.i("GDTM", "Logged out...");
		}
	}

	private Session.StatusCallback callback = new Session.StatusCallback() {

		@Override
		public void call(Session session, SessionState state, Exception exception) {

			onSessionStateChange(session, state, exception);
		}
	}; */
}
