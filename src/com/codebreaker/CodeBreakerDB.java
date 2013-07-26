package com.codebreaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CodeBreakerDB {

	public static final String KEY_ROWID = "_id"; //Referencing a specific row in the database.
	public static final String KEY_NAME = "player_name"; 
	public static final String KEY_SCORE = "player_score"; 

	private static final String DATABASE_NAME = "PlayerScoresdb"; //Labeling the database 
	private static final String DATABASE_TABLE = "playerTable"; //Labeling the table

	private static final int DATABASE_VERSION = 1; 

	private DbHelper scoreHelper;
	private final Context scoreContext;
	private SQLiteDatabase scoreDb;

	//databaseHelper to help set up database
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME , null, DATABASE_VERSION);

		}

		@Override
		public void onCreate(SQLiteDatabase db) { //Method only called on first use to generate db.

			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " +
					KEY_SCORE + " TEXT NOT NULL);");


		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //Method called after first use

			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}

	}

	public CodeBreakerDB(Context c){
		scoreContext = c;
	}

	public CodeBreakerDB open() throws SQLException{
		scoreHelper = new DbHelper(scoreContext); //Gets aspects set up for the database including name and version.
		scoreDb = scoreHelper.getWritableDatabase(); //Opening of database through scoreHelper.
		return this;
	}

	public void close (){
		scoreHelper.close(); //Closes the scoreHelper class. 
	}

	public long createScoreEntry(String name, String score) { // Writing to the actual database. 

		ContentValues cv = new ContentValues(); 
		cv.put(KEY_NAME, name);
		cv.put(KEY_SCORE, score);
		return scoreDb.insert(DATABASE_TABLE, null, cv);

	}

	public String getData() {

		String[] scoreColumns = new String[]{ KEY_ROWID, KEY_NAME, KEY_SCORE};
		Cursor c = scoreDb.query(DATABASE_TABLE, scoreColumns, null, null, null, null, null);	//reading information from db.
		String result = "";

		int iRow = c.getColumnIndex(KEY_ROWID); //Cursor looking for column setting equal to these ints.
		int iName = c.getColumnIndex(KEY_NAME);
		int iScore = c.getColumnIndex(KEY_SCORE);

		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) { 
			//Move to first row - where cursor starts and moves to next row as long it is not after last row.
			result = result + c.getString(iRow) + "\t" + c.getString(iName) + "\t" + c.getString(iScore) + "\n" ; 
			//Returning value of row that it is currently on.
		}
		return result;	//returning result
	}
}