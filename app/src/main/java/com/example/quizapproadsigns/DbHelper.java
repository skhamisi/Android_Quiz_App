package com.example.quizapproadsigns;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.NumberFormat;

public class DbHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "ATTEMPTS";

    // Table columns
    public static final String _ID = "_id";
    public static final String PERCENTAGE = "percentage";
    public static final String SCORE = "score";
    public static final String STATUS = "status";

    // Database Information
    static final String DB_NAME = "QUIZ_RECORDS.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PERCENTAGE + " TEXT,"
            + SCORE + " TEXT,"
            + STATUS + " TEXT)";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}