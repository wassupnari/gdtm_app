package com.gdtm.app.intro;

import java.security.MessageDigest;

import com.facebook.Session;
import com.facebook.widget.LoginButton;
import com.facebook.model.GraphUser;
import com.gdtm.app.R;
import com.gdtm.app.control.ActionBarMain;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class SignupPage extends FragmentActivity{
	
	private LoginButton loginButton;
	
	private PendingAction pendingAction = PendingAction.NONE;
	private GraphUser user;
	
	private enum PendingAction {
        NONE,
        POST_PHOTO,
        POST_STATUS_UPDATE
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     
				  WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
		setContentView(R.layout.intro_signup_page);
		
		loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {
            @Override
            public void onUserInfoFetched(GraphUser user) {
                SignupPage.this.user = user;
                updateUI();
                // It's possible that we were waiting for this.user to be populated in order to post a
                // status update.
                handlePendingAction();
            }
        });
		
		Button btn_login = (Button) findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Start main view after sign in
				Intent intent = new Intent(SignupPage.this, ActionBarMain.class);
				startActivity(intent);
				finish();
			}
			
		});
		
		Button btn_fb = (Button) findViewById(R.id.btn_signup_fb);
		btn_fb.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
			        PackageInfo info = getPackageManager().getPackageInfo(
			                "com.facebook.samples.hellofacebook", 
			                PackageManager.GET_SIGNATURES);
//			        for (Signature signature : info.signatures) {
//			            MessageDigest md = MessageDigest.getInstance("SHA");
//			            md.update(signature.toByteArray());
//			            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//			            }
			    } catch (NameNotFoundException e) {

			    }
			}
			
		});
	}
	
	private void updateUI() {
        Session session = Session.getActiveSession();
        boolean enableButtons = (session != null && session.isOpened());

//        postStatusUpdateButton.setEnabled(enableButtons);
//        postPhotoButton.setEnabled(enableButtons);
//        pickFriendsButton.setEnabled(enableButtons);
//        pickPlaceButton.setEnabled(enableButtons);
//
//        if (enableButtons && user != null) {
//            profilePictureView.setProfileId(user.getId());
//            greeting.setText(getString(R.string.hello_user, user.getFirstName()));
//        } else {
//            profilePictureView.setProfileId(null);
//            greeting.setText(null);
//        }
    }
	
	private void handlePendingAction() {
        PendingAction previouslyPendingAction = pendingAction;
        // These actions may re-set pendingAction if they are still pending, but we assume they
        // will succeed.
        pendingAction = PendingAction.NONE;

        switch (previouslyPendingAction) {
            case POST_PHOTO:
                //postPhoto();
                break;
            case POST_STATUS_UPDATE:
                //postStatusUpdate();
                break;
        }
    }
	
}
