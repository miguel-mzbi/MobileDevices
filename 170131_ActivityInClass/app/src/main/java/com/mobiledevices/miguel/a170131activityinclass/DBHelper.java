package com.mobiledevices.miguel.a170131activityinclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE = "laBazezita";
    private static final int VERSION = 1;
    private static final String TABLE = "students";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    public DBHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    // When the DB is created for the first time
    public void onCreate(SQLiteDatabase db) {

        String creation = "CREATE TABLE " + TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT)";
        db.execSQL(creation);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Prepared statements!
        String[] tables = {TABLE};
        db.execSQL("DROP TABLE IF EXIST ?", tables);

        // After deletion, whe create a new one
        onCreate(db);
    }

    public void save(String name) {

        // Obtain a DB where I can write
        SQLiteDatabase db = getWritableDatabase();

        // Pre-insert name to a selected column, this will be the "value" to insert
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);

        // Insert the values to the table
        // nullHack - If you want to save a NULL as a value of a column,
        // you can specify the name of the column in the middle parameter
        db.insert(TABLE, null, values);
    }

    public int find(String name) {

        // Obtain DB that I can interact with
        SQLiteDatabase db = getReadableDatabase();

        // Query
        String clause = COLUMN_NAME + " = ?";
        String[] values = {name};
        Cursor c = db.query(TABLE, null, clause, values, null, null, null);

        int result = -1;

        // Check for more than 0 rows in the select
        if(c.moveToFirst()) {

            // Obtain the first column (Column 0) of the row
            result = c.getInt(0);
        }

        return result;
    }

    public int delete(int id) {

        // Obtain a DB where I can write
        SQLiteDatabase db = getWritableDatabase();

        // Query
        String clause = COLUMN_ID + " = ?";
        String[] args = {id + ""};

        return db.delete(TABLE, clause, args);
    }
}
