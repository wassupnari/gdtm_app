package com.gdtm.app.intro;

import java.util.ArrayList;
import java.util.List;

import com.gdtm.app.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class IntroSwipeActivity extends FragmentActivity {

	private SwipePageAdapter mPageAdapter;
	private List<Fragment> mFragments;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.intro_swipe_activity);

		mFragments = getFragments();
		mPageAdapter = new SwipePageAdapter(getSupportFragmentManager(), mFragments);
		ViewPager pager = (ViewPager) findViewById(R.id.intro_viewpager);
		pager.setAdapter(mPageAdapter);

	}

	public class SwipePageAdapter extends FragmentPagerAdapter {

		private List<Fragment> fragments;

		public SwipePageAdapter(FragmentManager fm, List<Fragment> fragment) {
			super(fm);
			this.fragments = fragment;
		}

		@Override
		public Fragment getItem(int position) {
			return this.fragments.get(position);
		}

		@Override
		public int getCount() {
			return this.fragments.size();
		}

	}

	public List<Fragment> getFragments() {
		List<Fragment> fList = new ArrayList<Fragment>();

		fList.add(SwipeFragment.newInstance(R.layout.intro_swipe_fragment_1));
		fList.add(SwipeFragment.newInstance(R.layout.intro_swipe_fragment_2));
		fList.add(SwipeFragment.newInstance(R.layout.intro_swipe_fragment_3));
		fList.add(SwipeFragment.newInstance(R.layout.intro_swipe_fragment_4));

		return fList;
	}

	public static class SwipeFragment extends Fragment {

		public static final String IMG_SOURCE = "IMG_SOURCE";

		public final static SwipeFragment newInstance(int layoutId) {
			SwipeFragment f = new SwipeFragment();
			Bundle bdl = new Bundle(1);
			bdl.putInt(IMG_SOURCE, layoutId);
			f.setArguments(bdl);
			return f;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			int layoutId = getArguments().getInt(IMG_SOURCE);
			View v = inflater.inflate(layoutId, container, false);

			return v;
		}
	}

}
