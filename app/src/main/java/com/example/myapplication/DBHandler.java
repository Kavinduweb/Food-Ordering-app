package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String DB_Name = "MyCard";
    private static final String TABLE_NAME = "MyCard";

    private static final String ID = "id";
    private static final String Number = "number";
    private static final String Exdate = "exdate";
    private static final String Cvv = "cvv";

    public DBHandler(@Nullable Context context) {
        super(context, DB_Name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

       String Create_Table =  "CREATE TABLE " + TABLE_NAME + " "+
               "("
               + ID + " INTEGER PRIMARY KEY " + "AUTOINCREMENT,"
               + Number + " TEXT,"
               + Exdate+  " TEXT,"
               + Cvv + " TEXT" + ");";

        db.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

              String Drop_Table = "DROP TABLE IF EXISTS " + TABLE_NAME;

              db.execSQL(Drop_Table);

              onCreate(db);

    }

    public void addNum(CardModle add){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Number,add.getNumber());
        contentValues.put(Exdate,add.getExdate());
        contentValues.put(Cvv,add.getCvv());

        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        sqLiteDatabase.close();

    }

    public int count(){

        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(quary,null);
        return cursor.getCount();

    }
    public List<CardModle> getaallcard(){

        List<CardModle> modle = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String quary = "SELECT * FROM "+TABLE_NAME;


        Cursor cursor = db.rawQuery(quary,null);
        if (cursor.moveToFirst()){

            do{
                    CardModle modle2 = new CardModle();

                    modle2.setId(cursor.getInt(0));
                    modle2.setNumber(cursor.getString(1));
                    modle2.setExdate(cursor.getString(2));
                    modle2.setCvv(cursor.getString(3));

                    modle.add(modle2);
            }while(cursor.moveToNext());
        }

        return modle;


    }

    public CardModle getSingle(int id ){

       SQLiteDatabase db = getReadableDatabase();
       Cursor cursor= db.query(TABLE_NAME,new String[]{ID,Number,Exdate,Cvv},null,null,null,null,null);


       CardModle cards;

       if (cursor != null){
             cursor.moveToFirst();
           cards = new CardModle(

                    cursor.getInt(0),

                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );

           return cards;
       }

        return null;


    }
    public int update(CardModle cards ){

        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Number,cards.getNumber());
        contentValues.put(Exdate,cards.getExdate());
        contentValues.put(Cvv,cards.getCvv());

        int status = db.update(TABLE_NAME,contentValues,null,null);

        return status;
    }

    public void del(){

        SQLiteDatabase db = getWritableDatabase();


        db.delete(TABLE_NAME,null,null);



    }
}
