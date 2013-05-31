package com.gdtm.app.control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class FragmentMeetingList extends Fragment {

	private String arry[] = {};

	private static final String DEFAULT_MIN_DATE = "01/01/2013";

	private static final String DATE_FORMAT = "MM/dd/yyyy";

	private static final int NUM_OF_DAY = 7;

	private static final int NUM_OF_WEEK = 10;

	private final java.text.DateFormat mDateFormat = new SimpleDateFormat(DATE_FORMAT);

	private Calendar mMinDate;
	private Calendar mMaxDate;
	private Calendar mCurDate;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		ListView listView = new ListView(getActivity());
		ArrayAdapter<String> array = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1);

		mMinDate = Calendar.getInstance();
		parseDate(DEFAULT_MIN_DATE, mMinDate);

		mCurDate = Calendar.getInstance(Locale.getDefault());

		for (int index = 0; index < NUM_OF_DAY * NUM_OF_WEEK; index++) {
			int dayOfWeek = mCurDate.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek == Calendar.SATURDAY) {
				array.add(mCurDate.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US) + ". "
						+ mCurDate.get(Calendar.DAY_OF_MONTH));
			}
			mCurDate.add(Calendar.DATE, 1);
		}

		listView.setAdapter(array);
		return listView;
	}

	private boolean parseDate(String date, Calendar outDate) {

		try {
			outDate.setTime(mDateFormat.parse(date));
			return true;
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			return false;
		}
	}
}
