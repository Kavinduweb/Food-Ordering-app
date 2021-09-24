package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseRequestClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "request_database";

    //Database Table name
    private static final String TABLE_NAME = "REQUEST";

    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String CATEGORY = "category";
    public static final String TYPE = "type";
    private SQLiteDatabase sqLiteDatabase;

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL," + EMAIL + " TEXT NOT NULL, " + CATEGORY + " TEXT NOT NULL, " + TYPE + " TEXT NOT NULL);";

    //constructor
    public DatabaseRequestClass(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //Add employee data
    public void addRequest(RequestModelClass requestModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseRequestClass.NAME, requestModelClass.getName());
        contentValues.put(DatabaseRequestClass.EMAIL, requestModelClass.getEmail());
        contentValues.put(DatabaseRequestClass.CATEGORY, requestModelClass.getCategory());
        contentValues.put(DatabaseRequestClass.TYPE, requestModelClass.getType());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseRequestClass.TABLE_NAME,null,contentValues);
    }

    public List<RequestModelClass> getRequestList() {
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<RequestModelClass> storeRequest = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String category = cursor.getString(3);
                String type = cursor.getString(4);
                storeRequest.add(new RequestModelClass(id,name,email,category,type));
            }while (cursor.moveToNext());
        }

        cursor.close();
        return storeRequest;
    }

    public void updateRequest(RequestModelClass requestModelClass) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseRequestClass.NAME,requestModelClass.getName());
        contentValues.put(DatabaseRequestClass.EMAIL,requestModelClass.getEmail());
        contentValues.put(DatabaseRequestClass.CATEGORY,requestModelClass.getCategory());
        contentValues.put(DatabaseRequestClass.TYPE,requestModelClass.getType());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(requestModelClass.getId())});
    }

    public void deleteRequest(int id) {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }
}
