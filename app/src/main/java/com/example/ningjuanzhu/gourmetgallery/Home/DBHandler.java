package com.example.ningjuanzhu.gourmetgallery.Home;

/**
 * Created by ningjuanzhu on 2018/4/11.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_CONTACT = "contact";
    public static final String COLUMN_ID = "_id";
    public static final String NAME = "name";
    public static final String TIME = "time";
    public static final String CONTENT = "content";


    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + TABLE_CONTACT + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY , "
                + NAME + " TEXT, "
                + TIME + " TEXT, "
                + CONTENT + " TEXT "
                + ")";
        db.execSQL(create);
        String query1 = "insert into contact ( _id, name, time, content ) values ( 1,'Ningjuan Zhu','2018.4.13 7:00 2 DAYS AGO','I LOVE THIS RESTERANT!!') ";
        db.execSQL( query1 );
        db.execSQL( "insert into " + TABLE_CONTACT + " ( _id, name,time,content) values(2,'Xinyi Li','2018.4.12 12:00 3 DAYS AGO','Secret Menu in Pittsburgh.')");
        db.execSQL( "insert into " + TABLE_CONTACT + " ( _id, name,time,content) values(3,'Weiqi Yu','2018.4.12 11:00 3 DAYS AGO','Fast food is not healthy except this one.')");
        db.execSQL( "insert into " + TABLE_CONTACT + " ( _id, name,time,content) values(4,'Jeff Cheng','2018.4.11 21:00 4 DAYS AGO','Cookbook for cookies.')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }

    //add
    void addPost(Post post){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, post.get_name());
        values.put(TIME, post.get_time());
        values.put(CONTENT, post.get_content());
        db.insert(TABLE_CONTACT,null,values);

        db.close();

    }

    //get
    Post getPost(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CONTACT, new String[]{ COLUMN_ID,
                        NAME, TIME, CONTENT}, COLUMN_ID + "=?",
                        new String[] {String.valueOf(id) },null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();

        Post post = new Post(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2), cursor.getString(3));

        return post;
    }

    //getAll
    public ArrayList<Post> getAllPost(){
        ArrayList<Post> addpost = new ArrayList<Post>();
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACT+ " ORDER BY _ID";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Post post = new Post();
                post.set_id(Integer.parseInt(cursor.getString(0)));
                post.set_name(cursor.getString(1));
                post.set_time(cursor.getString(2));
                post.set_content(cursor.getString(3));

                addpost.add(post);
            } while (cursor.moveToNext());
        }
        return addpost;
    }

    //update
    public int updateAddress(Post post){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, post.get_name());
        values.put(TIME, post.get_time());
        values.put(CONTENT, post.get_content());

        return db.update(TABLE_CONTACT, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(post.get_id()) });
    }

    public void deleteAddress(Post address) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT, COLUMN_ID + " = ?",
                new String[] { String.valueOf(address.get_id()) });
        db.close();
    }

    public void deleteAddress(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_CONTACT + " WHERE " + COLUMN_ID + "=\"" + id + "\";");
        db.close();
    }


    //get count
    public int getAddressCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}

