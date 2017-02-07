package com.mobiledevices.miguel.activity4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;
import static android.R.attr.name;

public class DBHobbies extends SQLiteOpenHelper{

    private static final String DATABASE = "Hobbies";
    private static final int VERSION = 1;
    private static final String TABLE = "Hobbies";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_HOBBY = "hobby";

    public DBHobbies(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    // When the DB is created for the first time
    public void onCreate(SQLiteDatabase db) {

        String creation = "CREATE TABLE " + TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_HOBBY + " TEXT)";
        db.execSQL(creation);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Prepared statements!
        String[] tables = {TABLE};
        db.execSQL("DROP TABLE IF EXIST ?", tables);

        // After deletion, whe create a new one
        onCreate(db);
    }

    public void save(String hobby) {

        // Obtain a DB where I can write
        SQLiteDatabase db = getWritableDatabase();

        // Pre-insert name to a selected column, this will be the "value" to insert
        ContentValues values = new ContentValues();
        values.put(COLUMN_HOBBY, hobby);

        // Insert the values to the table
        // nullHack - If you want to save a NULL as a value of a column,
        // you can specify the name of the column in the middle parameter
        db.insert(TABLE, null, values);
    }

    public String find() {

        // Obtain DB that I can interact with
        SQLiteDatabase db = getReadableDatabase();

        // Query
        String clause = COLUMN_ID + " = ?";
        Cursor c = db.query(TABLE, null, null, null, null, null, null);

        String result = "-1";

        // Check for more than 0 rows in the select
        if(c.moveToFirst()) {

            // Obtain the first column (Column 2) of the row
            result = c.getString(1);

            while(c.moveToNext()) {
                result +=", " + c.getString(1);
            }
        }

        return result;
    }
}
