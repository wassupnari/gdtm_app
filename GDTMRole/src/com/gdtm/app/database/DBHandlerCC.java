package com.gdtm.app.database;

import java.util.ArrayList;
import java.util.List;

import com.gdtm.app.pojo.CCDataPojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHandlerCC extends SQLiteOpenHelper {

	private final static int NUM_OF_CC_PJT = 10;

	// Database version
	private static final int DATABASE_VER = 1;

	// Database name
	private static final String DATABASE_NAME = "Toastmaster_database";

	// Table name
	private static final String TABLE_NAME = "CC";

	// Table column names
	private static final String KEY_ID = "id";
	private static final String KEY_PJT_TITLE = "project_title";
	private static final String KEY_SPEECH_TITLE = "speech_title";
	private static final String KEY_EVALUATOR = "evaluator";
	private static final String KEY_DATE = "date";
	private static final String KEY_OBJECT = "object";

	CCDataPojo[] data = new CCDataPojo[NUM_OF_CC_PJT];

	public DBHandlerCC(Context context) {

		super(context, DATABASE_NAME, null, DATABASE_VER);
	}
	
	public DBHandlerCC(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	// Create table
	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_CC_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID
				+ " INTEGER PRIMARY KEY," + KEY_OBJECT + " TEXT" + ")";
		

		db.execSQL(CREATE_CC_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {

		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

		onCreate(db);
	}

	/**
	 * Add new CC data.
	 * 
	 * @param cc
	 */
	public void addCCData(int id, CCDataPojo cc) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		///String jsonObj = gson.toJson(cc);
		values.put(KEY_ID, id);
		values.put(KEY_OBJECT, cc.getProjectTitle());

		db.insert(TABLE_NAME, null, values);
		db.close();
	}

	/**
	 * Getting single CC data.
	 * 
	 * @param id
	 * @return
	 */
	public CCDataPojo getUserCCData(int id) {

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID, KEY_PJT_TITLE,
				KEY_SPEECH_TITLE, KEY_EVALUATOR, KEY_DATE }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null) {

			cursor.moveToFirst();
		}

		CCDataPojo cc = new CCDataPojo(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
				cursor.getString(2), cursor.getString(3), cursor.getString(4));

		return cc;
	}

	/**
	 * Getting all CC data.
	 * 
	 * @return
	 */
	public List<CCDataPojo> getAllData() {

		List<CCDataPojo> ccList = new ArrayList<CCDataPojo>();

		String selectQuery = "SELECT * FROM " + TABLE_NAME;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				CCDataPojo cc = new CCDataPojo();
				cc.setId(Integer.parseInt(cursor.getString(0)));
				cc.setProjectTitle(cursor.getString(1));
				cc.setSpeechTitle(cursor.getString(2));
				cc.setEvaluator(cursor.getString(3));
				cc.setDate(cursor.getString(4));

				ccList.add(cc);
			} while (cursor.moveToNext());
		}

		return ccList;
	}

	/**
	 * Update single CC data.
	 * 
	 * @param cc
	 * @return
	 */
	public int updateCC(CCDataPojo cc) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_SPEECH_TITLE, cc.getSpeechTitle());
		values.put(KEY_EVALUATOR, cc.getEvaluator());

		return db.update(TABLE_NAME, values, KEY_ID + " =?",
				new String[] { String.valueOf(cc.getId()) });
	}

	/**
	 * Delete single CC data.
	 * 
	 * @param cc
	 */
	public void deleteCC(CCDataPojo cc) {

		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME, KEY_ID + " =?", new String[] { String.valueOf(cc.getId()) });
		db.close();

	}

	public int getCCCount() {

		String countQuery = "SELECT * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		return cursor.getCount();
	}

	
}
