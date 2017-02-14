package com.mobiledevices.miguel.repasop1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper{
    static private String DB_NAME = "DemoDB";
    static private String DB_Table = "DemoTable";
    static private String COLUMN_ID = "ID";
    static private String COLUMN_NAME = "Name";


    public DBClass(Context context){
        super(context, DB_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {
        String creation = "CREATE TABLE " + DB_Table + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_NAME + " TEXT)";
        db.execSQL(creation);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String[] tablesToDrop = {DB_Table};
        db.execSQL("DROP TABLE IF EXIST ?", tablesToDrop);
        this.onCreate(db);
    }

    public void insert(String name){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COLUMN_NAME, name);
        db.insert(DB_Table, null, val);
    }

    public String select(String name){
        SQLiteDatabase db = getReadableDatabase();
        String clause = COLUMN_NAME + "= ?";
        String[] values = {name};
        Cursor c = db.query(DB_Table, null, clause, values, null, null, null, null);
        String returning = "-1";
        if(c.moveToFirst()) {
            returning = c.getString(0);
        }
        c.close();
        return returning;
    }

    public void remove(String id){
        SQLiteDatabase db = getWritableDatabase();
        String clause = COLUMN_ID + " = ?";
        String[] value = {id};
        db.delete(DB_Table, clause, value);
    }
}
