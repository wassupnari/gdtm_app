package com.nari.somnium.fragment;

import com.nari.somnium.R;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentAboutMe extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_about_me, null);
		
//		TextView email = (TextView) view.findViewById(R.id.about_email);
//		final String emailText = email.getText().toString();
//		email.setOnClickListener(new TextView.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent intent = new Intent(Intent.ACTION_VIEW);
//				StringBuilder uri = new StringBuilder("mailto:");
//				uri.append(emailText);
//				uri.append("?subject=").append(Uri.encode(""));
//				uri.append("&body=").append(Uri.encode(""));
//				intent.setData(Uri.parse(uri.toString()));
//				startActivity(intent);
//			}
//			
//		});
		
		return view;
	}
}
