package com.nari.somnium.activity;

import com.nari.somnium.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	public void showActionBar(final Activity activity, String title) {
		getActionBar().setDisplayShowCustomEnabled(true);
		getActionBar().setDisplayShowTitleEnabled(false);
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayUseLogoEnabled(false);
		
		LayoutInflater inflator = (LayoutInflater)getSystemService(getApplicationContext().LAYOUT_INFLATER_SERVICE);
		View v = inflator.inflate(R.layout.actionbar_layout, null);
		
		TextView actionbarTitle = (TextView) v.findViewById(R.id.actionbar_title);
		actionbarTitle.setText(title);
		
		getActionBar().setCustomView(v);
		
		ImageView backButton = (ImageView) v.findViewById(R.id.actionbar_back_btn);
		backButton.setOnClickListener(new ImageView.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Go back to previous page
				activity.finish();
			}
			
		});
		
		final ToggleButton editBtn = (ToggleButton) v.findViewById(R.id.actionbar_edit_btn);
		editBtn.setChecked(false);
		editBtn.setOnClickListener(new ToggleButton.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(editBtn.isChecked()) {
					onEdit();
				} else {
					onEditDone();
				}
				
			}
			
		});
		
		ImageButton infoBtn = (ImageButton) v.findViewById(R.id.actionbar_info_btn);
		infoBtn.setOnClickListener(new ImageButton.OnClickListener() {

			@Override
			public void onClick(View v) {
				onInfo();
			}
			
		});
	}
	
	public void onEdit() {};
	public void onEditDone() {};
	public void onInfo() {};
	
}
