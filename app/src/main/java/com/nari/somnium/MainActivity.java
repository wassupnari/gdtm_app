package com.nari.somnium;

import java.util.ArrayList;

import com.nari.toastmate.R;
import com.nari.somnium.adapter.DrawerAdapter;
import com.nari.somnium.fragment.FragmentAboutMe;
import com.nari.somnium.fragment.FragmentCC;
import com.nari.somnium.fragment.FragmentCL;
import com.nari.somnium.fragment.FragmentClubPage;
import com.nari.somnium.fragment.FragmentDraft;
import com.nari.somnium.fragment.FragmentMain;
import com.nari.somnium.fragment.FragmentSetting;
import com.nari.somnium.helper.DatabaseHelper;
import com.nari.somnium.helper.PreferenceHelper;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ToggleButton;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class MainActivity extends Activity {

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
	
	private DatabaseHelper mDB;
	
	private PreferenceHelper mPreferences;
	
	private static boolean showEditButton = false;
	
	public interface OnMainMenuEditButtonListener{
		public void onMainMenuEditButtonListener(boolean isChecked);
	}
	
	private static OnMainMenuEditButtonListener mOnMainMenuEditButtonListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		Log.d("GDTM", "Main Activity");

		super.onCreate(savedInstanceState);

        Parse.initialize(this, "4rQ0MCZC21dEAKWZuEy8jyrl6ZI5siPH7DB8Ys4G", "YXUhv0qNm9ilIoRhsrJtxhohmCVnihmSBGz295LA");
//		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		mPreferences = new PreferenceHelper(MainActivity.this);
		String isStarted = mPreferences.getStringFromPreferences("started", "");

//		if(isStarted.equalsIgnoreCase("")) {
//			Intent intent = new Intent(MainActivity.this, SplashScreen.class);
//			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			startActivity(intent);
//			
//			MainActivity.this.finish();
//		} else {
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
			getActionBar().setIcon(R.drawable.actionbar_logo);

			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer,
					R.string.drawer_open, R.string.drawer_close) {

				public void onDrawerClosed(View view) {
					getActionBar().setTitle(mTitle);
					invalidateOptionsMenu();
				}

				public void onDrawerOpened(View view) {
					getActionBar().setTitle(mDrawerTitle);
					invalidateOptionsMenu();
					setShowEditButton(false);
				}
			};
			mDrawerLayout.setDrawerListener(mDrawerToggle);

			if (savedInstanceState == null) {
				// on first time display view for first nav item
				DisplayView(0);
			}

			mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
			
			mDB = new DatabaseHelper(MainActivity.this);

            // Parse test
        final ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "nari");
        testObject.saveInBackground();

        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                String id = testObject.getObjectId();
                Log.d("GDTM", "object id : " + id);
            }
        });
        Log.d("GDTM", "here");
        Log.d("GDTM", "object id : " + testObject.getObjectId());
//		}

	}
	
	

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("GDTM", "Main activity onResume");
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.d("GDTM", "onCreateOptionsMenu");
		if(showEditButton) {
			getMenuInflater().inflate(R.menu.menu_actionbar_main, menu);
			MenuItem menuItem = menu.findItem(R.id.actionbar_custom_menu);
			
			View actionView = menuItem.getActionView();
			LinearLayout layout = (LinearLayout) actionView.findViewById(R.id.menu_custom_layout);
			
			ToggleButton editBtn = (ToggleButton) layout.findViewById(R.id.actionbar_edit_btn_main);
			editBtn.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(mOnMainMenuEditButtonListener != null) {
						mOnMainMenuEditButtonListener.onMainMenuEditButtonListener(isChecked);
					}
				}
				
			});
		}
		
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
		mDrawerItem.add(new DrawerItem(mNavMenuIcon.getResourceId(6, -1), mNavMenuTitle[6]));

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
//		case 1:
//			fragment = new FragmentMeetingList();
//			break;
		case 1:
			fragment = new FragmentCL();
			break;
		case 2:
			fragment = new FragmentCC();
			break;
		case 3:
			fragment = new FragmentDraft();
			break;
		case 4:
			fragment = new FragmentClubPage();
			break;
		case 5:
			fragment = new FragmentAboutMe();
			break;
		case 6:
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
	
	public static void setShowEditButton(boolean show) {
		showEditButton = show;
	}
	
	public static void setOnMainMenuEditButtonListener(OnMainMenuEditButtonListener listener) {
		mOnMainMenuEditButtonListener = listener;
	}

}
