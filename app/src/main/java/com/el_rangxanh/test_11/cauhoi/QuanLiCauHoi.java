package com.el_rangxanh.test_11.cauhoi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class QuanLiCauHoi {
    private DBHelper dbHelper;

    public QuanLiCauHoi(Context context) {
        dbHelper = new DBHelper(context);
    }

    //Lấy danh sách câu hỏi theo dạng mảng
    public ArrayList laycauhoi(int sttktra, String monhoc) {
        ArrayList<CauHoi> listcauhoi = new ArrayList<CauHoi>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ly1 WHERE sttktra='" + sttktra + "' AND monhoc='" + monhoc + "'", null);
        cursor.moveToFirst();
        do {
            CauHoi dulieucauhoi;
            dulieucauhoi = new CauHoi(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getInt(7), cursor.getString(8), cursor.getString(9), "");
            listcauhoi.add(dulieucauhoi);
        } while (cursor.moveToNext());
        return listcauhoi;
    }
}

