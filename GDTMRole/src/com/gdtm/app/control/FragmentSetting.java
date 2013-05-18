package com.gdtm.app.control;

import com.facebook.widget.ProfilePictureView;
import com.gdtm.app.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
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

	private ProfilePictureView mProfilePicture;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.control_frag_setting, null);

		mProfilePicture = (ProfilePictureView) view.findViewById(R.id.profilePicture);
		// mProfilePicker.setProfileId()

		mName = (TextView) view.findViewById(R.id.profile_name);
		mName.setText("User name");
		mName.setTextSize(20);
		mNameField = (TextView) view.findViewById(R.id.profile_name_field);
		mNameField.setText("Nari Kim");

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

		return view;
	}
}
