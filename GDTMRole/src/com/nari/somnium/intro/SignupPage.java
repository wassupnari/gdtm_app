package com.nari.somnium.intro;

import java.util.Arrays;

//import com.facebook.FacebookException;
//import com.facebook.Request;
//import com.facebook.Response;
//import com.facebook.Session;
//import com.facebook.SessionState;
//import com.facebook.widget.LoginButton;
//import com.facebook.widget.LoginButton.OnErrorListener;
//import com.facebook.model.GraphUser;
import com.nari.somnium.R;
import com.nari.somnium.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 * 
 *         No longer use this class. - 2013. 10. 31
 */

public class SignupPage extends Activity {
	/*

	private LoginButton mLoginWithFacebook;
	private Button mLoginWithEmail;
	private Button mSignup;

	private PendingAction pendingAction = PendingAction.NONE;
	private GraphUser mUser;

	// private UserInfo mUserInfo;

	// private TextView mText;

	private enum PendingAction {
		NONE, POST_PHOTO, POST_STATUS_UPDATE
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); // Removes title bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // Removes
																// notification
																// bar
		setContentView(R.layout.intro_signup_page);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// mText = (TextView) findViewById(R.id.user_name);

		mLoginWithFacebook = (LoginButton) findViewById(R.id.login_button);
		mLoginWithFacebook.setOnErrorListener(new OnErrorListener() {

			@Override
			public void onError(FacebookException error) {

				Log.i("GDTM", "Error " + error.getMessage());
			}
		});

		// set permission list, Don't forget to add email
		mLoginWithFacebook.setReadPermissions(Arrays.asList("basic_info", "email"));
		// session state call back event
		mLoginWithFacebook.setSessionStatusCallback(new Session.StatusCallback() {

			@Override
			public void call(Session session, SessionState state, Exception exception) {

				if (session.isOpened()) {
					Log.i("GDTM", "Access Token" + session.getAccessToken());
					Request.executeMeRequestAsync(session, new Request.GraphUserCallback() {

						@Override
						public void onCompleted(GraphUser user, Response response) {

							if (user != null) {
								Log.i("GDTM", "User ID " + user.getId());
								Log.i("GDTM", "Email " + user.asMap().get("email"));

								mUser = user;

								UserInfo.getInstance().setID(user.getId());
								UserInfo.getInstance().setName(user.getName());
								// Log.d("GDTM", "User name in signUp : " +
								// UserInfo.getInstance().getName());

								Intent intent = new Intent(SignupPage.this, MainActivity.class);
								startActivity(intent);
								finish();
							}
						}
					});
				}
			}

		});

		Button mLoginWithEmail = (Button) findViewById(R.id.btn_login);
		mLoginWithEmail.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Start main view after sign in
				Intent intent = new Intent(SignupPage.this, MainActivity.class);
				startActivity(intent);
				finish();
			}

		});

		Button mSignup = (Button) findViewById(R.id.btn_signup);
		mSignup.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}

	private void updateUI() {

		Session session = Session.getActiveSession();
		boolean enableButtons = (session != null && session.isOpened());

		// postStatusUpdateButton.setEnabled(enableButtons);
		// postPhotoButton.setEnabled(enableButtons);
		// pickFriendsButton.setEnabled(enableButtons);
		// pickPlaceButton.setEnabled(enableButtons);
		//
		// if (enableButtons && user != null) {
		// profilePictureView.setProfileId(user.getId());
		// greeting.setText(getString(R.string.hello_user,
		// user.getFirstName()));
		// } else {
		// profilePictureView.setProfileId(null);
		// greeting.setText(null);
		// }
	}

	private void handlePendingAction() {

		PendingAction previouslyPendingAction = pendingAction;
		// These actions may re-set pendingAction if they are still pending, but
		// we assume they
		// will succeed.
		pendingAction = PendingAction.NONE;

		switch (previouslyPendingAction) {
		case POST_PHOTO:
			// postPhoto();
			break;
		case POST_STATUS_UPDATE:
			// postStatusUpdate();
			break;
		}
	}

	public GraphUser getUserInfo() {

		return mUser;
	}
	*/
}
