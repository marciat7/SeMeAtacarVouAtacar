package com.example.marciacavalcante.semeatacarvouatacar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcia Cavalcante on 01/07/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DB_MEMES";
    //TABELAS
    private static final String TB_MEME = "MEME";

    //ATRIBUTOS
    private static final String KEY_ID = "ID";
    private static final String KEY_URL = "URL";
    private static final String KEY_FORCE = "FORCE";


    public DataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEME_TB = "CREATE TABLE " + TB_MEME +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_URL + " TEXT,"
                + KEY_FORCE + " INTEGER"
                + ")";
        db.execSQL(CREATE_MEME_TB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertMeme(Meme meme){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_URL, meme.getUrl());
        values.put(KEY_FORCE, meme.getForce());

        db.insert(TB_MEME, null, values);
    }

    public List<Meme> getMemes() {
        List<Meme> temp = new ArrayList<Meme>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TB_MEME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cu = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cu.moveToFirst()) {
            do {
                // Adding contact to list
                temp.add(new Meme(cu.getString(1), cu.getInt(2)));
            } while (cu.moveToNext());
        }

        // return contact list
        return temp;
    }

}
