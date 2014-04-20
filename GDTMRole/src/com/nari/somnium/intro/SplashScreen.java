package com.nari.somnium.intro;

import com.gdtm.app.R;
import com.nari.somnium.helper.PreferenceHelper;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class SplashScreen extends Activity {

	private static String TAG = SplashScreen.class.getName();
	private static long SLEEP_TIME = 5; // Sleep for some time
	
	private PreferenceHelper mPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		mPreferences = new PreferenceHelper(SplashScreen.this);
		mPreferences.putStringInPreferences("started", "true");

		// Removes title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Removes notification bar
//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.intro_splash_screen);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// Create Hash Tag for facebook
		// printHashKey();

		// Start timer and launch main activity
		IntentLauncher launcher = new IntentLauncher();
		launcher.start();
		
	}

	private class IntentLauncher extends Thread {

		@Override
		/**
		 * Sleep for some time and than start new activity.
		 */
		public void run() {

			try {
				// Sleeping
				Thread.sleep(SLEEP_TIME * 200);
			} catch (Exception e) {
				Log.e(TAG, e.getMessage());
			}

			// Start main activity
			Intent intent = new Intent(SplashScreen.this, IntroSwipeActivity.class);
			SplashScreen.this.startActivity(intent);
			SplashScreen.this.finish();
		}
	}

	// Create Hash Tag for facebook
	// public void printHashKey() {
	//
	// try {
	// PackageInfo info = getPackageManager().getPackageInfo("com.gdtm.app",
	// PackageManager.GET_SIGNATURES);
	// for (Signature signature : info.signatures) {
	// MessageDigest md = MessageDigest.getInstance("SHA");
	// md.update(signature.toByteArray());
	// Log.d("GDTM", "HashTag : " + Base64.encodeToString(md.digest(),
	// Base64.DEFAULT));
	// }
	// } catch (NameNotFoundException e) {
	//
	// } catch (NoSuchAlgorithmException e) {
	//
	// }
	//
	// }

}
