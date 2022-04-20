package com.yazlab.yazlab;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "new.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table users(username TEXT primary key, password TEXT)");

        DB.execSQL("create Table Araclar(name TEXT primary key, kullanici_sayisi TEXT)");

        DB.execSQL("create Table Duraklar(name TEXT primary key, bekleyen_sayisi TEXT, Lat TEXT, Long TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists users");

        DB.execSQL("drop Table if exists Araclar");
        DB.execSQL("drop Table if exists Duraklar");

    }

    public Boolean createUser(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;}
    }



    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertuserdata(String name, String contact, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result=DB.insert("Userdetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String name, String contact, String dob)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Userdetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        return cursor;
    }
   //////////////////  ARACLAR SQLİTE
    public Boolean createArac(String name, String kullanici_sayisi){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("kullanici_sayisi", kullanici_sayisi);
        long result = MyDB.insert("Araclar", null, contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;}
    }




    public Boolean updatearacdata(String name, String kullanici_sayisi)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", kullanici_sayisi);
        Cursor cursor = DB.rawQuery("Select * from Araclar where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Araclar", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletearacdata (String name)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Araclar where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Araclar", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getaracdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Araclar", null);
        return cursor;
    }
    //////////////////  DURAKLAR SQLİTE
    public Boolean createDurak(String name, String bekleyen_sayisi,String Lat,String Long){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("bekleyen_sayisi", bekleyen_sayisi);
        contentValues.put("Lat", Lat);
        contentValues.put("Long", Long);
        long result = MyDB.insert("Duraklar", null, contentValues);
        if(result==-1) {
            return false;
        }else{
            return true;}
    }




    public Boolean updatedurakdata(String name_durakTXT, String durak_kisi_sayisiTXT,String name_latTXT,String name_longTXT){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name_durakTXT);
        contentValues.put("bekleyen_sayisi", durak_kisi_sayisiTXT);
        contentValues.put("Lat", name_latTXT);
        contentValues.put("Long", name_longTXT);
        Cursor cursor = DB.rawQuery("Select * from Duraklar where name = ?", new String[]{name_durakTXT});
        if (cursor.getCount() > 0) {
            long result = DB.update("Duraklar", contentValues, "name=?", new String[]{name_durakTXT});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedurakdata (String name_durakTXT){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Duraklar where name = ?", new String[]{name_durakTXT});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Duraklar", "name=?", new String[]{name_durakTXT});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdurakdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Duraklar", null);
        return cursor;
    }








}