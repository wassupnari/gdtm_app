package com.gdtm.app.fragment;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;
import com.gdtm.app.R;
import com.gdtm.app.intro.SplashScreen;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */
public class FragmentSetting extends Fragment {

	private Context mContext;

	private TextView mName;
	private TextView mNameField;
	private TextView mEmail;
	private Button mEmailField;
	private TextView mPhone;
	private TextView mPhoneField;
	private Button mLogout;

	private ProfilePictureView mProfilePicture;

	private UiLifecycleHelper mUIHelper;

	private Session.StatusCallback callback = new Session.StatusCallback() {

		@Override
		public void call(final Session session, final SessionState state, final Exception exception) {

			onSessionStateChange(session, state, exception);
		}
	};

	// For new permission request
	private static final int REAUTH_ACTIVITY_CODE = 100;

	private GraphUser mUser;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_setting, null);
		mContext = view.getContext();

		// Find the user's profile custom view
		mProfilePicture = (ProfilePictureView) view.findViewById(R.id.profilePicture);
		mProfilePicture.setCropped(true);

		// Find user name view
		mName = (TextView) view.findViewById(R.id.profile_name);
		mName.setText("User name");
		mName.setTextSize(20);
		mNameField = (TextView) view.findViewById(R.id.profile_name_field);

		mEmail = (TextView) view.findViewById(R.id.profile_email);
		mEmail.setText("User Email");
		mEmail.setTextSize(20);
		mEmailField = (Button) view.findViewById(R.id.profile_email_field);
		mEmailField.setText("wassupnari@gmail.com");

		mPhone = (TextView) view.findViewById(R.id.profile_phone);
		mPhone.setText("Phone");
		mPhone.setTextSize(20);
		mPhoneField = (Button) view.findViewById(R.id.profile_phone_field);
		mPhoneField.setText("010-9925-1234");

		mLogout = (Button) view.findViewById(R.id.profile_logout);
		mLogout.setText("Logout");
		mLogout.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
				builder.setMessage(R.string.app_logout)
						.setTitle(R.string.app_name)
						.setPositiveButton(R.string.dialog_btn_ok,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog, int id) {

										// User clicked OK button
										// Clear User Preference and Session Out
										Session session = Session.getActiveSession();
										if (session != null && !session.isClosed()) {
											session.closeAndClearTokenInformation();
											startActivity(new Intent(mContext, SplashScreen.class));
											getActivity().finish();
										}
									}
								})
						.setNegativeButton(R.string.dialog_btn_cancel,
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog, int id) {

										// User cancelled the dialog
										// Do nothing
									}
								});
				AlertDialog dialog = builder.create();
				dialog.show();
			}

		});

		// Check for an open session
		Session session = Session.getActiveSession();
		if (session != null && session.isOpened()) {
			// Get the user's data
			makeMeRequest(session);
		}

		return view;
	}

	/**
	 * Initialize UILifecycleHelper.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		mUIHelper = new UiLifecycleHelper(getActivity(), callback);
		mUIHelper.onCreate(savedInstanceState);
	}

	/**
	 * Call the corresponding UiLifecycleHelper method if the
	 * REAUTH_ACTIVITY_CODE request code is passed in.
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REAUTH_ACTIVITY_CODE) {
			mUIHelper.onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public void onResume() {

		super.onResume();
		mUIHelper.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle bundle) {

		super.onSaveInstanceState(bundle);
		mUIHelper.onSaveInstanceState(bundle);
	}

	@Override
	public void onPause() {

		super.onPause();
		mUIHelper.onPause();
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
		mUIHelper.onDestroy();
	}

	/**
	 * Request user data.
	 * 
	 * @param session
	 */
	private void makeMeRequest(final Session session) {

		// Make an API call to get user data and define a new callback to handle
		// the response.
		Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {

			@Override
			public void onCompleted(GraphUser user, Response response) {

				// If the response is successful
				if (session == Session.getActiveSession()) {
					if (user != null) {
						// Set the id for the ProfilePictureView
						// view that in turn displays the profile picture.
						mProfilePicture.setProfileId(user.getId());
						// Set the Textview's text to the user's name.
						mNameField.setText(user.getName());
					}
				}
				if (response.getError() != null) {
					// Handle errors, will do so later.
				}
			}

		});
		request.executeAsync();
	}

	/**
	 * Respond to session changes and call the makeMeRequest(), if the session
	 * is open.
	 * 
	 * @param session
	 * @param state
	 * @param exception
	 */
	private void onSessionStateChange(final Session session, SessionState state, Exception exception) {

		if (session != null && session.isOpened()) {
			// Get the user's data.
			makeMeRequest(session);
		}
	}
}
