package com.example.sql_lite_table;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    String Databasename = "Registration.db";
    public DbHelper(@Nullable Context context) {
        super(context, "Registration.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Registrationdata(Id integer primary key autoincrement , Username text , Email text , Password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("drop table if exists Registrationdata");
    }
    public  boolean Insertrecord(String Username , String Email , String Password ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datainserted = new ContentValues();
        datainserted.put("Username", Username );
        datainserted.put("Email", Email );
        datainserted.put("Password", Password );
     long success = db.insert("Registrationdata" , null , datainserted);
        if (success > 0) {
        return true;
        }
        else {
            return false;
        }
        }
    }

