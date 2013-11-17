package com.gdtm.app.intro;

import com.facebook.*;
import com.gdtm.app.R;
import com.gdtm.app.view.FacebookFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * This class view is for non-authenticated user
 * 
 * @author wassupnari
 * 
 */
public class FragmentNonAuthUser extends Fragment {

	private FacebookFragment mFragment;

	private Button mLoginButton;

	private Context mContext;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.intro_signup_page, container, false);
		mContext = view.getContext();

		mLoginButton = (Button) view.findViewById(R.id.btn_login);
		mLoginButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Login button", Toast.LENGTH_SHORT).show();
			}

		});
		return view;
	}

}
