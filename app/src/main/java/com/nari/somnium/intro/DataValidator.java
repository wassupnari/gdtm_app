package com.nari.somnium.intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nari.toastmate.R;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;

/**
 * Data valication class for user input data in Signin/Signup page.
 * 
 * @author Nari Kim Shin (wassupnari@gmail.com)
 * 
 */
public class DataValidator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static Pattern mPattern;
	private static Matcher mMatcher;

	private static AlertDialog mDialog;
	private static String mPassword;

	public static boolean emailValidator(String email) {
		mPattern = Pattern.compile(EMAIL_PATTERN);
		mMatcher = mPattern.matcher(email);
		return mMatcher.matches();
	}

	public static boolean passwordValidator(EditText password) {
		return (password.getText().length() > 7) ? true : false;
	}

	public static boolean nameValidator(EditText name) {
		return (name.getText().length() > 0) ? true : false;
	}

	public static void showAlertDialog(Context context, int message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(message).setPositiveButton(R.string.dialog_btn_ok,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		mDialog = builder.create();
		mDialog.show();
	}
}
