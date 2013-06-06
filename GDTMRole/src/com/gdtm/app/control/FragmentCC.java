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

	private String arry[] = { "Tofeeq", "Ahmad", "Fragment", "Example", "Tofeeq", "Ahmad",
			"Fragment", "Example" };

	private static final String PREFERENCE = "MyPrefFile";

	private MyExpandableListAdapter mAdapter;
	// private ExpandableListView mListview;

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

		mGroupItem.add("Project 1");
		mGroupItem.add("Project 2");
		mGroupItem.add("Project 3");
	}

	public void setChildData() {

		ArrayList<String> child = new ArrayList<String>();
		child.add("1-Title");
		child.add("1-Date");
		child.add("1-Evaluator");
		mChildItem.add(child);
		child = new ArrayList<String>();
		child.add("2-Title");
		child.add("2-Date");
		child.add("2-Evaluator");
		mChildItem.add(child);
		child = new ArrayList<String>();
		child.add("3-Title");
		child.add("3-Date");
		child.add("3-Evaluator");
		mChildItem.add(child);
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
