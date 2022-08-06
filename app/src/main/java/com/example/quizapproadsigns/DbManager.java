package com.example.quizapproadsigns;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {
    private DbHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DbManager(Context c) {
        context = c;
    }

    public DbManager open() throws SQLException {
        dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String percentage, String score, String status) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DbHelper.PERCENTAGE, percentage);
        contentValue.put(DbHelper.SCORE, score);
        contentValue.put(DbHelper.STATUS, status);
        database.insert(DbHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DbHelper._ID, DbHelper.PERCENTAGE, DbHelper.SCORE, DbHelper.STATUS};
        Cursor cursor = database.query(DbHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(Long _id, String percentage, String score, String status) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.PERCENTAGE, percentage);
        contentValues.put(DbHelper.SCORE, score);
        contentValues.put(DbHelper.STATUS, status);
        int i = database.update(DbHelper.TABLE_NAME, contentValues, DbHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DbHelper.TABLE_NAME, DbHelper._ID + "=" + _id, null);
    }
}
