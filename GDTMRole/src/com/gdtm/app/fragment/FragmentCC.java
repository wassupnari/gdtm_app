package com.gdtm.app.fragment;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.activity.CCDetailActivity;
import com.gdtm.app.adapter.CCListAdapter;
import com.gdtm.app.adapter.CLExpandableListAdapter;
import com.gdtm.app.database.DBHandlerCC;
import com.gdtm.app.pojo.CCDataPojo;

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
	private ListView mListView;

	private String[] mProject;

	private DBHandlerCC mDB;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_cc, null);

		SharedPreferences setting = this.getActivity().getSharedPreferences(PREFERENCE, 0);

		mProject = getResources().getStringArray(R.array.cc_project);
		mDB = new DBHandlerCC(getActivity());
		for (int i = 0; i < NUM_OF_CC_PJT; i++) {
			CCDataPojo data = new CCDataPojo();
			data.setSpeechTitle("None");
			mDB.addCCData(i, data);
		}

		mListView = (ListView) view.findViewById(R.id.cc_listview);
		mListView.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent speechView = new Intent(getActivity(), CCDetailActivity.class);
				speechView.putExtra("cc_id", position);
				startActivity(speechView);
			}

		});

		// Database
		DBHandlerCC db = new DBHandlerCC(this.getActivity());

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		mAdapter = new CCListAdapter(getActivity());
		mListView.setAdapter(mAdapter);
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
