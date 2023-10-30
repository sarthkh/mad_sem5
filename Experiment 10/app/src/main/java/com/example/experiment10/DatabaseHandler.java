package com.example.experiment10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table studentDetails(stu_rollNum TEXT primary key, stu_name TEXT, stu_marks TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Userdetails");
    }

    public Boolean addStudentData(String rollNo, String name, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("stu_rollNum", rollNo);
        contentValues.put("stu_name", name);
        contentValues.put("stu_marks", marks);

        long result = db.insert("studentDetails", null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Boolean updateStudentData(String rollNo, String name, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("stu_name", name);
        contentValues.put("stu_marks", marks);

        Cursor cursor = db.rawQuery("Select * from studentDetails where stu_rollNum = ?", new String[]{rollNo});

        if (cursor.getCount() > 0) {
            long result = db.update("studentDetails", contentValues, "stu_rollNum=?", new String[]{rollNo});

            if (result == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public Boolean removeStudentData(String rollNo) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from studentDetails where stu_rollNum = ?", new String[]{rollNo});

        if (cursor.getCount() > 0) {
            long result = db.delete("studentDetails", "stu_rollNum=?", new String[]{rollNo});

            if (result == -1)
                return false;
            else
                return true;
        } else {
            return false;
        }
    }

    public Cursor fetchStudentData() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from studentDetails", null);
        return cursor;
    }
}
