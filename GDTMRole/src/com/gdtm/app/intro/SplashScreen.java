package com.gdtm.app.intro;

import com.gdtm.app.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class SplashScreen extends Activity{
	
	private static String TAG = SplashScreen.class.getName();
	 private static long SLEEP_TIME = 5;    // Sleep for some time

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
	  this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     
			  WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar

	  setContentView(R.layout.intro_splash_screen);

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
	        Thread.sleep(SLEEP_TIME*500);
	     } catch (Exception e) {
	        Log.e(TAG, e.getMessage());
	     }

	     // Start main activity
	     Intent intent = new Intent(SplashScreen.this, SignupPage.class);
	     SplashScreen.this.startActivity(intent);
	     SplashScreen.this.finish();
	  }
	}
	

}
	