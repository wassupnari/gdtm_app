package com.gdtm.app.control;

import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;
import com.gdtm.app.R;
import com.gdtm.app.intro.SignupPage;
import com.gdtm.app.intro.UserInfo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */
public class FragmentSetting extends Fragment {

	private TextView mName;
	private TextView mNameField;
	private TextView mEmail;
	private Button mEmailField;
	private TextView mPhone;
	private TextView mPhoneField;
	private Button mLogout;

	private ProfilePictureView mProfilePicture;

	private GraphUser mUser;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.control_frag_setting, null);

		// Should check session before caching user data!

		mProfilePicture = (ProfilePictureView) view.findViewById(R.id.profilePicture);
		mProfilePicture.setProfileId(UserInfo.getInstance().getID());

		mName = (TextView) view.findViewById(R.id.profile_name);
		mName.setText("User name");
		mName.setTextSize(20);
		mNameField = (TextView) view.findViewById(R.id.profile_name_field);
		mNameField.setText(UserInfo.getInstance().getName());
		// Log.d("GDTM", "User name : " + UserInfo.getInstance().getName());

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

				// Clear User Preference

				// Session Out
				Session session = Session.getActiveSession();
				session.closeAndClearTokenInformation();
				startActivity(new Intent(getActivity().getApplicationContext(), SignupPage.class));
				getActivity().finish();
			}

		});
		return view;
	}
}
