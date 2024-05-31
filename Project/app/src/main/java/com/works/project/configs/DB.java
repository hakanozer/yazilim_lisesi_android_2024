package com.works.project.configs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {

    public DB(@Nullable Context context) {
        super(context, "project.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String likesSql = "CREATE TABLE \"likes\" (\n" +
                "\t\"lid\"\tINTEGER,\n" +
                "\t\"pid\"\tINTEGER UNIQUE,\n" +
                "\tPRIMARY KEY(\"lid\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(likesSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String likesSql = "drop table if exists likes";
        db.execSQL(likesSql);
        onCreate(db);
    }

    public long addLike(long pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pid", pid);
        long id = db.insert("likes", null, values);
        db.close();
        return id;
    }

    public int removeLike(long pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        int status = db.delete("likes", "pid="+pid, null);
        db.close();
        return status;
    }

    public boolean singleLike(long pid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from likes where pid = "+pid, null);
        boolean status = cursor.moveToNext();
        db.close();
        return status;
    }


    public List<Long> allLikes() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Long> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from likes", null);
        while (cursor.moveToNext()) {
            long pid = cursor.getLong(1);
            list.add(pid);
        }
        return list;
     }

}
