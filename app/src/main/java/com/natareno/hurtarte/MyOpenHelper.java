package com.natareno.hurtarte;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOpenHelper extends SQLiteOpenHelper {
    private static  final String USER_TABLE_CREATE ="CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, lastname TEXT, mail TEXT, favorite INTEGER);";
    private static final String DB_NAME ="users.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;
    private Context mContext;


    public MyOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert_user (Context c,String name, String lastname, String mail, int favorite){

        ContentValues cv = new ContentValues();

        cv.put("name",name);
        cv.put("lastname",lastname);
        cv.put("mail",mail);
        cv.put("favorite",favorite);
        db.insert("user",null,cv);

        Toast.makeText(c,"The user is saved ", Toast.LENGTH_LONG).show();
    }

    public ArrayList<User> getUsers(){

        ArrayList UserList = new ArrayList<User>();
        Cursor c = db.rawQuery("select id,name,lastname,mail,favorite from user",null);

        if(c!=null && c.getCount()>0){
            c.moveToFirst();

            do{
                int id=c.getInt(c.getColumnIndex("id"));
                String name = c.getString(c.getColumnIndex("name"));
                String lastname = c.getString(c.getColumnIndex("lastname"));
                String mail = c.getString(c.getColumnIndex("mail"));
                int favorite= c.getInt(c.getColumnIndex("favorite"));
                User u = new User(id,name,lastname,mail,favorite);
                UserList.add(u);

            }while(c.moveToNext());


        }
        c.close();

        return  UserList;

    }

    public ArrayList<User> getFavUsers(){

        ArrayList UserList = new ArrayList<User>();
        Cursor c = db.rawQuery("select id,name,lastname,mail,favorite from user where favorite = 0",null);

        if(c!=null && c.getCount()>0){
            c.moveToFirst();

            do{
                int id=c.getInt(c.getColumnIndex("id"));
                String name = c.getString(c.getColumnIndex("name"));
                String lastname = c.getString(c.getColumnIndex("lastname"));
                String mail = c.getString(c.getColumnIndex("mail"));
                int favorite= c.getInt(c.getColumnIndex("favorite"));
                User u = new User(id,name,lastname,mail,favorite);
                UserList.add(u);

            }while(c.moveToNext());


        }
        c.close();
        return  UserList;

    }


    public void modifyUser(int id , int fav){


    ContentValues cv= new ContentValues();
    cv.put("id", id);
    cv.put("favorite", fav);


    db.update("user",cv,"id=?", new String[]{ String.valueOf(id)});
   // db.close();



    }



    public void deleteUser(int id){

     String [] args = new String[]{
          String.valueOf(id)
        };



        db.delete("user","id=?",args);


     //getWritableDatabase().delete("user","id="+id,null);





    }







}
