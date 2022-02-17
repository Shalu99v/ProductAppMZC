package com.example.productappmzc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends SQLiteOpenHelper {
   static String DbName="college.db";
   static String TableName ="product";
   static String  col1="id";
   static String  col2="productcode";
   static String col3="productname";
   static String col4="price";


    public Databasehelper(Context context) {
        super(context, DbName, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table "+TableName+
                "("+col1+"  integer primary  key  autoincrement,"+
                col2+" integer,"+
                col3+" text,"+
                col4+" integer)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean InsertData(String productcode,String productname,String price)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(col2,productcode);
        content.put(col3,productname);
        content.put(col4,price);

        long status=db.insert(TableName,null,content);
        if(status==-1)
        {
            return  false;

        }
        else
        {
            return true;
        }
    }
    public Cursor SearchData(String productcode)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="select * from "+TableName+
                "where " +col2+ "='"+productcode+"'";
        Cursor c=db.rawQuery(query,null);
        return c;
    }

}
