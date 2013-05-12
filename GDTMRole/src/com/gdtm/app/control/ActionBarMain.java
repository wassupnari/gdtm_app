package com.gdtm.app.control;

import com.gdtm.app.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class ActionBarMain extends Activity implements TabListener {

	RelativeLayout rl;
	
	FragmentMain mFragMain;
	FragmentTransaction fragMentTra = null;
	FragmentSetting mFragSetting;
	FragmentMeetingList mFragMeetingList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     
				  WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar
		setContentView(R.layout.control_actionbar_main);
		try {
			rl = (RelativeLayout) findViewById(R.id.mainLayout);
			fragMentTra = getFragmentManager().beginTransaction();
			ActionBar bar = getActionBar();
			bar.addTab(bar.newTab().setText("Meeting List").setTabListener(this));
			bar.addTab(bar.newTab().setText("Upcoming Meeting").setTabListener(this));
			bar.addTab(bar.newTab().setText("Setting").setTabListener(this));

			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
					| ActionBar.DISPLAY_USE_LOGO);
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			bar.setDisplayShowHomeEnabled(true);
			bar.setDisplayShowTitleEnabled(false);
			bar.show();

		} catch (Exception e) {
			e.getMessage();
		}
		/**
		 * Hiding Action Bar
		 */
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_actionbar_main, menu);
		return true;
	}
	
	

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		if (tab.getText().equals("Meeting List")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragMeetingList = new FragmentMeetingList();
			fragMentTra.addToBackStack(null);
			fragMentTra = getFragmentManager().beginTransaction();
			fragMentTra.add(rl.getId(), mFragMeetingList);
			fragMentTra.commit();
		} else if (tab.getText().equals("Upcoming Meeting")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragMain = new FragmentMain();
			fragMentTra.addToBackStack(null);
			fragMentTra = getFragmentManager().beginTransaction();
			fragMentTra.add(rl.getId(), mFragMain);
			fragMentTra.commit();
		} else if (tab.getText().equals("Setting")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragSetting = new FragmentSetting();
			fragMentTra.addToBackStack(null);
			fragMentTra = getFragmentManager().beginTransaction();
			fragMentTra.add(rl.getId(), mFragSetting);
			fragMentTra.commit();
		}

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}
    
    
}
