package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FeedbackDBHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "feedback";
    private static final String TABLE_NAME = "feedback";

    //Table Name
    private static final String ID = "id";
    private static final String FEEDBACK = "feedback";


    public FeedbackDBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = " CREATE TABLE " + TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +FEEDBACK+" TEXT"+
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        onCreate(sqLiteDatabase);

    }

    //add Feedback
    public  void  addFeedBack(com.example.myapplication.FeedBack feedBack){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(FEEDBACK,feedBack.getFeedbackMzg());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public int countFeedback(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor=db.rawQuery(query,null);
        return cursor.getCount();
    }

    //get all Feedbacks
    public List<com.example.myapplication.FeedBack> getAllFeedbacks(){

        List<com.example.myapplication.FeedBack> feedBacks = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {

                com.example.myapplication.FeedBack feedBack = new com.example.myapplication.FeedBack();

                feedBack.setId(cursor.getInt(0));
                feedBack.setFeedbackMzg(cursor.getString(1));


                feedBacks.add(feedBack);
            }while (cursor.moveToNext());
        }
        return feedBacks;
    }

    //delte Feedback

    public void delteFeedBack(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,"id =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public com.example.myapplication.FeedBack getSingleFeedBack(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,new String[]{ID,FEEDBACK},
                ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

        com.example.myapplication.FeedBack feedBack;
        if(cursor != null){
            cursor.moveToFirst();
            feedBack = new com.example.myapplication.FeedBack(
                    cursor.getInt(0),
                    cursor.getString(1)
            );
            return feedBack;
        }
        return null;
    }


    public int updateSingleToDo(com.example.myapplication.FeedBack feedBack){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(FEEDBACK,feedBack.getFeedbackMzg());

        int status = db.update(TABLE_NAME,contentValues,ID +" =?",
                new String[]{String.valueOf(feedBack.getId())});

        db.close();
        return status;
    }


}
