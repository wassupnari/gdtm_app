package com.gdtm.app.intro;

import com.facebook.*;
import com.gdtm.app.R;
import com.gdtm.app.view.FacebookFragment;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

/**
 * This class view is for non-authenticated user
 * 
 * @author wassupnari
 * 
 */
public class FragmentNonAuthUser extends Fragment {

	private FacebookFragment mFragment;

	private Button mLoginButton;
	private TextView mSignUpButton;

	private Context mContext;
	private View mView;

	private AlertDialog mDialog;

	private EditText mSigninEmail;
	private EditText mSigninPW;
	private String mEmailText;
	private boolean mIsEmailValid;

	private DataValidator mValidator;

	DialogInterface.OnClickListener mOnDialogOkClickListener;
	DialogInterface.OnClickListener mOnDialogCancelClickListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		mView = inflater.inflate(R.layout.intro_signup_page, container, false);
		mContext = mView.getContext();

		mOnDialogOkClickListener = new SigninOKListener();

		mSigninEmail = (EditText) mView.findViewById(R.id.signin_email);
		mSigninPW = (EditText) mView.findViewById(R.id.signin_pw);

		mLoginButton = (Button) mView.findViewById(R.id.btn_login);
		mLoginButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mIsEmailValid = mValidator.emailValidator(mSigninEmail.getText().toString());
				if (mIsEmailValid && mSigninPW.getText().length() > 5) {
					// Send data to backend
				} else {
					mValidator.showAlertDialog(mContext, R.string.invalid_email);
				}
			}

		});

		mSignUpButton = (TextView) mView.findViewById(R.id.btn_signup);
		mSignUpButton.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), SignupWithEmail.class);
				getActivity().startActivity(intent);

				// AlertDialog.Builder builder = new
				// AlertDialog.Builder(mContext);
				// LayoutInflater inflater = (LayoutInflater)
				// mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
				// mView = inflater.inflate(R.layout.intro_dialog_signup, null);
				// builder.setView(mView)
				// .setTitle("Signup")
				// .setCancelable(false)
				// .setPositiveButton(R.string.dialog_btn_signup,
				// mOnDialogOkClickListener)
				// .setNegativeButton(R.string.dialog_btn_cancel,
				// mOnDialogCancelClickListener);
				// mDialog = builder.create();
				// mDialog.setInverseBackgroundForced(true);
				//
				// mDialog.show();
			}

		});

		return mView;
	}

	private final class SigninOKListener implements DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			Toast.makeText(mContext, "Signin OK", Toast.LENGTH_SHORT);
		}

	}

	private class SigninCancelListener implements DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			dialog.dismiss();
		}

	}

}
