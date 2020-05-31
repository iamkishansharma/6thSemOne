package com.ks.a6thsemone.sqlliteDb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "student.db";
    private final static String TABLE_NAME = "student_table";
    private final static String COL_1 = "ID";
    private final static String COL_2 = "NAME";
    private final static String COL_3 = "MARKS";
    private final static String COL_4 = "PHONE";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, MARKS TEXT, PHONE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    boolean insertData(String name, String marks, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, name);
        cv.put(COL_3, marks);
        cv.put(COL_4, phone);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return res;
    }

    boolean deleteData(String  name){
        if(name.length() == 0){
            return false;
        }else {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE NAME LIKE '"+name+"'");
            //db.delete(TABLE_NAME, "ID = "+id.toString(), null)
            return true;
        }
    }
}
