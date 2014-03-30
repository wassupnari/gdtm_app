package com.gdtm.app.database;

import java.util.ArrayList;
import java.util.List;

import com.gdtm.app.pojo.CCDataPojo;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

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
	private static final String KEY_OBJECT = "object";

	CCDataPojo[] data = new CCDataPojo[NUM_OF_CC_PJT];
	
	private Gson gson = new Gson();
	private JsonParser jsonParser = new JsonParser();

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
		String jsonObj = gson.toJson(cc);
		values.put(KEY_ID, id);
		values.put(KEY_OBJECT, jsonObj);

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

		Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID, KEY_OBJECT }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
		}
		if(cursor.getString(1) != null) {
			CCDataPojo cc = gson.fromJson(jsonParser.parse(cursor.getString(1))
					.getAsJsonObject(), CCDataPojo.class);
			return cc;
		}

		return null;
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
				cc = gson.fromJson(jsonParser.parse(cursor.getString(1)).getAsJsonObject(), CCDataPojo.class);
				cc.setId(Integer.parseInt(cursor.getString(0)));
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
		String jsonObj = gson.toJson(cc);
		values.put(KEY_OBJECT, jsonObj);

		return db.update(TABLE_NAME, values, KEY_ID + " = ?",
				new String[] { String.valueOf(cc.getId()) });
	}

	/**
	 * Delete single CC data.
	 * 
	 * @param cc
	 */
	public void deleteCC(CCDataPojo cc) {

		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(cc.getId()) });
		db.close();

	}

	public int getCCCount() {

		int count;
		String countQuery = "SELECT * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		count = cursor.getCount();
		cursor.close();
		return count;
	}

	
}
