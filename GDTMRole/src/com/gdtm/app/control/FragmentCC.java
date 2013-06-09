package com.gdtm.app.control;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.view.MyExpandableListAdapter;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class FragmentCC extends Fragment {

	private static final String PREFERENCE = "MyPrefFile";

	private final static int NUM_OF_CC_PJT = 10;

	private MyExpandableListAdapter mAdapter;

	private ArrayList<String> mGroupItem = new ArrayList<String>();
	private ArrayList<Object> mChildItem = new ArrayList<Object>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.control_frag_cc, null);

		SharedPreferences setting = this.getActivity().getSharedPreferences(PREFERENCE, 0);

		ExpandableListView expandableListView = (ExpandableListView) view
				.findViewById(R.id.expandable_list);

		setGroupData();
		setChildData();

		mAdapter = new MyExpandableListAdapter(mGroupItem, mChildItem);
		mAdapter.setInflater(inflater, getActivity());
		expandableListView.setAdapter(mAdapter);

		return view;
	}

	public void setGroupData() {

		for (int i = 1; i <= NUM_OF_CC_PJT; i++) {
			mGroupItem.add("Project " + i);
		}
	}

	public void setChildData() {

		ArrayList<String> child;
		for (int i = 0; i < NUM_OF_CC_PJT; i++) {
			child = new ArrayList<String>();
			child.add("Title : ");
			child.add("Date : ");
			child.add("Evaluator : ");
			mChildItem.add(child);
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
