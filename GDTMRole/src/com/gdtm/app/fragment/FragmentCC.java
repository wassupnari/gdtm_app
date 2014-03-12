package com.gdtm.app.fragment;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.activity.SpeechActivity;
import com.gdtm.app.adapter.CCListAdapter;
import com.gdtm.app.adapter.MyExpandableListAdapter;
import com.gdtm.app.database.DBHandlerCC;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

/**
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */

public class FragmentCC extends Fragment {

	private static final String PREFERENCE = "MyPrefFile";

	private static final int NUM_OF_CC_PJT = 10;

	// private MyExpandableListAdapter mAdapter;
	private CCListAdapter mAdapter;

	// private ArrayList<String> mGroupItem = new ArrayList<String>();
	// private ArrayList<Object> mChildItem = new ArrayList<Object>();
	private ArrayList<CCDataPojo> data = new ArrayList<CCDataPojo>();

	private String[] mProject;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_cc, null);

		SharedPreferences setting = this.getActivity().getSharedPreferences(PREFERENCE, 0);

		mProject = getResources().getStringArray(R.array.cc_project);

		for (int i = 0; i < NUM_OF_CC_PJT; i++) {
			data.add(new CCDataPojo(mProject[i], i, false));
		}

		ListView listView = (ListView) view.findViewById(R.id.cc_listview);
		listView.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent speechView = new Intent(getActivity(), SpeechActivity.class);
				startActivity(speechView);
			}
			
		});

		// Database
		DBHandlerCC db = new DBHandlerCC(this.getActivity());
		// db.addCCData(new UserCC(1, "Icebreaker Speech", "My First Speech",
		// "Peter Shin", "2013. 11. 15"));

		// Adapter for listview
		mAdapter = new CCListAdapter(getActivity(), data);
		// mAdapter.setInflater(inflater, getActivity());
		listView.setAdapter(mAdapter);

		return view;
	}

	public class CCDataPojo {

		public String project;
		public Integer productNumber;
		public boolean isCompleted;

		public CCDataPojo(String title, Integer productNumber, boolean isCompleted) {
			this.project = title;
			this.productNumber = productNumber;
			this.isCompleted = isCompleted;
		}

		public String getProject() {
			return this.project;
		}
	}

	public class CCDataOpenHelper extends SQLiteOpenHelper {

		private static final int DATABASE_VERSION = 0;

		private static final String KEY_WORD = "Role";
		private static final String KEY_DEFINITION = "Achieved";

		private static final String CC_TABLE_NAME = "CC Database";
		private static final String CC_TABLE_CREATE = "CREATE_TABLE" + CC_TABLE_NAME + " ("
				+ KEY_WORD + " TEXT, " + KEY_DEFINITION + " Text);";

		public CCDataOpenHelper(Context context, String name, CursorFactory factory, int version) {

			super(context, CC_TABLE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			db.execSQL(CC_TABLE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

		}

	}

}
