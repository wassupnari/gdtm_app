package com.nari.somnium.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;

//import com.facebook.Session;
//import com.facebook.SessionState;
//import com.facebook.UiLifecycleHelper;
import com.nari.somnium.MainActivity;

/**
 * 
 * @author Nari Kim Shin (wassupnari@gmail.com)
 * 
 */

public class SignupFragment extends FragmentActivity {
/*
	private static final int NONAUTH = 0;
	// private static final int AUTH = 1;
	// private static final int FRAGMENT_COUNT = AUTH +1;

	// private Fragment[] fragments = new Fragment[1];

	private Fragment nonAuthFrag;

	private boolean isResumed = false;

	private UiLifecycleHelper uiHelper;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		uiHelper = new UiLifecycleHelper(this, callback);
		uiHelper.onCreate(savedInstanceState);

		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // Removes
																// notification
																// bar
		setContentView(R.layout.intro_signup_fragment);

		FragmentManager fm = getSupportFragmentManager();
		nonAuthFrag = fm.findFragmentById(R.id.nonauthfrag);
		// fragments[NONAUTH] = fm.findFragmentById(R.id.nonauthfrag);
		// fragments[AUTH] = fm.findFragmentById(R.id.authfrag);

		FragmentTransaction transaction = fm.beginTransaction();
		
//		  for(int i = 0; i < fragments.length; i++) {
//		  transaction.hide(fragments[i]); }
		 
		transaction.commit();

	}

	private void showFragment(int fragmentIndex, boolean addToBackStack) {

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		transaction.show(nonAuthFrag);
		
//		  for (int i = 0; i < fragments.length; i++) { if (i == fragmentIndex)
//		  { transaction.show(fragments[i]); } else {
//		  transaction.hide(fragments[i]); } }
		 
		if (addToBackStack) {
			transaction.addToBackStack(null);
		}
		transaction.commit();
	}

	@Override
	public void onResume() {

		super.onResume();
		uiHelper.onResume();
		isResumed = true;
	}

	@Override
	public void onPause() {

		super.onPause();
		uiHelper.onPause();
		isResumed = false;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {

		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	private void onSessionStateChange(Session session, SessionState state, Exception exception) {

		// Only make changes if the activity is visible
		if (isResumed) {
			FragmentManager manager = getSupportFragmentManager();
			// Get the number of entries in the back stack
			int backStackSize = manager.getBackStackEntryCount();
			// Clear the back stack
			for (int i = 0; i < backStackSize; i++) {
				manager.popBackStack();
			}
			if (state.isOpened()) {
				// If the session state is open:
				// Go to main page
				// showFragment(AUTH, false);
				Intent intent = new Intent(SignupFragment.this, MainActivity.class);
				startActivity(intent);
				finish();
			} else if (state.isClosed()) {
				// If the session state is closed:
				// Show the login fragment
				showFragment(NONAUTH, false);
			}
		}
	}

	@Override
	protected void onResumeFragments() {

		super.onResumeFragments();
		Session session = Session.getActiveSession();

		if (session != null && session.isOpened()) {
			// if the session is already open,
			// Go to main page
			// showFragment(AUTH, false);
			Intent intent = new Intent(SignupFragment.this, MainActivity.class);
			startActivity(intent);
			finish();
		} else {
			// otherwise present the splash screen
			// and ask the person to login.
			showFragment(NONAUTH, false);
		}
	}

	private Session.StatusCallback callback = new Session.StatusCallback() {

		@Override
		public void call(Session session, SessionState state, Exception exception) {

			onSessionStateChange(session, state, exception);
		}
	};*/
}
