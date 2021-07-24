package com.gregorius.myawesomedictionary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ExploreHelper {
    DBHelper dbHelper;

    public ExploreHelper(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public List<String> selectAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<String> words = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM favorites", null);
        cursor.moveToFirst();

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String name = cursor.getString(1);
                words.add(name);
                cursor.moveToNext();
            }

        }
        cursor.close();
        db.close();
        dbHelper.close();

        return words;
    }

    public void insert(String word){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] insert = {word};

        db.execSQL("INSERT INTO favorites (word) VALUES (?)", insert);
        db.close();
        dbHelper.close();
    }

    public void delete(String word){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] insert = {word};

        db.execSQL("DELETE FROM favorites WHERE word = ?", insert);
        db.close();
        dbHelper.close();
    }
}
