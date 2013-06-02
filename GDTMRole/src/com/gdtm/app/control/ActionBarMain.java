package com.gdtm.app.control;

import com.gdtm.app.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class ActionBarMain extends Activity implements TabListener {

	private RelativeLayout rl;

	private FragmentMain mFragMain;
	private FragmentCL mFragCL;
	private FragmentSetting mFragSetting;
	private FragmentCC mFragCC;
	private FragmentMeetingList mFragMeetingList;

	private FragmentTransaction mFragTransaction = null;

	private final static String TAB_MEETING_LIST = "Meeting List";
	private final static String TAB_CL = "CL";
	private final static String TAB_UPCOMING = "Upcoming Meeting";
	private final static String TAB_CC = "CC";
	private final static String TAB_SETTING = "Setting";

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.control_actionbar_main);
		try {
			rl = (RelativeLayout) findViewById(R.id.mainLayout);
			mFragTransaction = getFragmentManager().beginTransaction();
			ActionBar bar = getActionBar();
			bar.addTab(bar.newTab().setText(TAB_MEETING_LIST).setTabListener(this));
			bar.addTab(bar.newTab().setText(TAB_CL).setTabListener(this));
			bar.addTab(bar.newTab().setText(TAB_UPCOMING).setTabListener(this));
			bar.addTab(bar.newTab().setText(TAB_CC).setTabListener(this));
			bar.addTab(bar.newTab().setText(TAB_SETTING).setTabListener(this));

			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_USE_LOGO);
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

		if (tab.getText().equals(TAB_MEETING_LIST)) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragMeetingList = new FragmentMeetingList();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragMeetingList);
			mFragTransaction.commit();
		} else if (tab.getText().equals(TAB_CL)) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragCL = new FragmentCL();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragCL);
			mFragTransaction.commit();
		} else if (tab.getText().equals(TAB_UPCOMING)) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragMain = new FragmentMain();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragMain);
			mFragTransaction.commit();
		} else if (tab.getText().equals(TAB_CC)) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragCC = new FragmentCC();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragCC);
			mFragTransaction.commit();
		} else if (tab.getText().equals(TAB_SETTING)) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragSetting = new FragmentSetting();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragSetting);
			mFragTransaction.commit();
		}

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

}
