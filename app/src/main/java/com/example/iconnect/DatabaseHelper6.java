package com.example.iconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*************************************************************
 * Class: Database Helper6
 * Function: Store the information associated with the people
 * in the sixth group
 *************************************************************/
public class DatabaseHelper6 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "personList6.db";
    private static final String TABLE3 = "listGroup6";

    private static final String COL1 = "ID";
    private static final String COL2 = "NAME";
    private static final String COL3 = "IDENTITY";
    private static final String COL4 = "SUBTITLE";
    private static final String COL5 = "FREQUENCY";
    private static final String COL6 = "NOTE";
    private static final String COL7 = "SETCOUNT";


    public DatabaseHelper6(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT, IDENTITY TEXT, SUBTITLE TEXT, FREQUENCY TEXT, NOTE TEXT, SETCOUNT TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3);
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

        long result = db.insert(TABLE3, null, contentValues);

        //if data as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE3, null);
        return data;
    }
    public Cursor getItemID(String name, String identity, String subtitle, String frequency, String note, String setCount) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE3 +
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
        String query = "UPDATE " + TABLE3 + " SET " + COL7 +
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


