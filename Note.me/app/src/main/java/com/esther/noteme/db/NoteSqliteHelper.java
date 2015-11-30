package com.esther.noteme.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Esther on 30/11/2015.
 */
public class NoteSqliteHelper extends SQLiteOpenHelper {

    // database version
    public static final int database_VERSION = 1;
    // database name
    public static final String database_NAME = "notes";
    public static final String table_notes = "notes_t";
    public static final String note_ID = "id";
    public static final String note_TITLE = "title";
    public static final String note_DESCRIPTION = "description";
    public static final String note_STATE = "state";

    public static final String note_DATE = "date";
    public static final String note_PRIORITY = "priority";


    public NoteSqliteHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dropAndCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    protected void dropAndCreate(SQLiteDatabase db) {
        db.execSQL("drop table if exists " + table_notes + ";");
        createTables(db);
    }

    protected void createTables(SQLiteDatabase db) {
        db.execSQL(
                "create table " + table_notes +" (" +
                        note_ID + " integer primary key autoincrement " +
                        "not null," +
                        note_TITLE + " text not null," +
                        note_DESCRIPTION + " text," +
                        note_STATE + " text," +
                        note_DATE + " text, " +
                        note_PRIORITY + " real " +
                        ");"
        );
    }

}
