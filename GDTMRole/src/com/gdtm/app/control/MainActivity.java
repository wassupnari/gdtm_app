package com.gdtm.app.control;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.fragment.FragmentCC;
import com.gdtm.app.fragment.FragmentCL;
import com.gdtm.app.fragment.FragmentClubPage;
import com.gdtm.app.fragment.FragmentMain;
import com.gdtm.app.fragment.FragmentMeetingList;
import com.gdtm.app.fragment.FragmentSetting;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class MainActivity extends FragmentActivity {

	private Context mContext;

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private ArrayList<DrawerItem> mDrawerItem;

	// Navigation Drawer title
	private CharSequence mDrawerTitle;

	// App title
	private CharSequence mTitle;

	// Slide menu items
	private String[] mNavMenuTitle;
	private TypedArray mNavMenuIcon;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		mContext = this.getApplicationContext();

		setContentView(R.layout.control_drawer_menu);

		// Navigation Menu Setting
		mTitle = mDrawerTitle = getTitle();

		mNavMenuTitle = getResources().getStringArray(R.array.nav_drawer_items);
		mNavMenuIcon = getResources().obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.nav_menu);

		mDrawerItem = new ArrayList<DrawerItem>();
		InitDrawerItem();
		mNavMenuIcon.recycle(); // Recycle the TypedArray

		// Adapter Setting
		DrawerAdapter adapter = new DrawerAdapter(mContext, mDrawerItem);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setIcon(R.drawable.logo);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer,
				R.string.drawer_open, R.string.drawer_close) {

			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);

				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View view) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			DisplayView(0);
		}

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.menu_actionbar_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);

		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/**
	 * Init Drawer Item.
	 */
	public void InitDrawerItem() {
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(0, -1), mNavMenuTitle[0]));
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(1, -1), mNavMenuTitle[1]));
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(2, -1), mNavMenuTitle[2]));
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(3, -1), mNavMenuTitle[3]));
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(4, -1), mNavMenuTitle[4]));
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(5, -1), mNavMenuTitle[5]));

	}

	/**
	 * Slide Menu Click item Listener.
	 */
	private class SlideMenuClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// display view for selected nav drawer item
			DisplayView(position);
		}
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item.
	 * 
	 * @param position
	 */
	private void DisplayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new FragmentMain();
			break;
		case 1:
			fragment = new FragmentMeetingList();
			break;
		case 2:
			fragment = new FragmentCL();
			break;
		case 3:
			fragment = new FragmentCC();
			break;
		case 4:
			fragment = new FragmentClubPage();
			break;
		case 5:
			fragment = new FragmentSetting();
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.content_view, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(mNavMenuTitle[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("GDTM", "Error in creating fragment");
		}
	}

}
