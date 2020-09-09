package com.example.iconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/************************************************************
 * Class: DatabaseHelper
 * Function: Store information about each person or group displayed
 * in the activity_main.xml layout
 ************************************************************/
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mylist.db";
    public static final String TABLE_NAME = "mylist_data";
    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "IDENTITY";
    private static final String COL4 = "SUBTITLE";
    private static final String COL5 = "FREQUENCY";
    private static final String COL6 = "NOTE";
    private static final String COL7 = "SETCOUNT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT, IDENTITY TEXT, SUBTITLE TEXT, FREQUENCY TEXT, NOTE TEXT, SETCOUNT TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String id, String subtitle, String frequency, String note, String setCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, id);
        contentValues.put(COL4, subtitle);
        contentValues.put(COL5, frequency);
        contentValues.put(COL6, note);
        contentValues.put(COL7, setCount);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public Cursor getItemID(String name, String identity, String subtitle, String frequency, String note, String setCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'" +
                " AND " + COL3 + " = '" + identity + "'" +
                " AND " + COL4 + " = '" + subtitle + "'" +
                " AND " + COL5 + " = '" + frequency + "'" +
                " AND " + COL6 + " = '" + note + "'" +
                " AND " + COL7 + " = '" + setCount + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateDays(String name, String identity, String subtitle, String frequency, String note, String updatedSetCount, int id, String oldSetCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL7 +
                " = '" + updatedSetCount + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'" +
                " AND " + COL3 + " = '" + identity + "'" +
                " AND " + COL4 + " = '" + subtitle + "'" +
                " AND " + COL5 + " = '" + frequency + "'" +
                " AND " + COL6 + " = '" + note + "'" +
                " AND " + COL7 + " = '" + oldSetCount + "'";
        db.execSQL(query);
    }
}

