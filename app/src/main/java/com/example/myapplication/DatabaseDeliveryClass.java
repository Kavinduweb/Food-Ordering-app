package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDeliveryClass extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "delivery_database";
    //Database Table name
    private static final String TABLE_NAME = "DELIVERY";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String LOCATION = "location";
    public static final String NUMBER = "number";
    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
        " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+ADDRESS+" TEXT NOT NULL,"+LOCATION+" TEXT NOT NULL,"+NUMBER+" TEXT NOT NULL);";
    //Constructor
    public DatabaseDeliveryClass(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add Delivery Data
    public void addDelivery(DeliveryModelClass deliveryModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseDeliveryClass.NAME, deliveryModelClass.getName());
        contentValues.put(DatabaseDeliveryClass.ADDRESS, deliveryModelClass.getAddress());
        contentValues.put(DatabaseDeliveryClass.LOCATION, deliveryModelClass.getLocation());
        contentValues.put(DatabaseDeliveryClass.NUMBER, deliveryModelClass.getNumber());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseDeliveryClass.TABLE_NAME, null,contentValues);
    }

    public List<DeliveryModelClass> getDeliveryList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<DeliveryModelClass> storeDelivery = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                String location = cursor.getString(3);
                String number = cursor.getString(4);
                storeDelivery.add(new DeliveryModelClass(id,name,address,location,number));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeDelivery;
    }

    public void updateDelivery(DeliveryModelClass deliveryModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseDeliveryClass.NAME, deliveryModelClass.getName());
        contentValues.put(DatabaseDeliveryClass.ADDRESS, deliveryModelClass.getAddress());
        contentValues.put(DatabaseDeliveryClass.LOCATION, deliveryModelClass.getLocation());
        contentValues.put(DatabaseDeliveryClass.NUMBER, deliveryModelClass.getNumber());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(deliveryModelClass.getId())});
    }

    public void deleteDelivery(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }

}
