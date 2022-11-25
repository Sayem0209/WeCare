package com.example.we_care;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context)
    {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB)
    {
        DB.execSQL("create Table Infomation(Name TEXT, Address TEXT, UserID TEXT primary key, Password TEXT, Disease TEXT, Blood TEXT )");
        DB.execSQL("create Table Schools(Name TEXT, location TEXT,  EIIN TEXT primary key, Rating TEXT, Contact TEXT, Email TEXT,Special Text, fee TEXT)");

        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Proyash Cantonment', 'Chittagong','1459','4','01717876611','proyash@gmail.com','Asperger’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Autism Welfare Foundation', 'Dhaka','1234','5','01717874561','proyash@gmail.com','Rett Syndrome','3000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Beautiful Mind', 'Dhaka','1876','3','01877876611','proyash@gmail.com','Childhood Disintegrative Disorder(CDD)','2500')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Nishpap Autism Foundation', 'Chittagong','9163','4','01917776641','proyash@gmail.com','Kanner’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Proyash Savar', 'Savar','3459','4','01416534256','proyash@gmail.com','Asperger’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('School for Gifted Children', 'Rajshahi','1129','5','01711567231','proyash@gmail.com','Pervasive Developmental Disorder','2500')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('William & Mary Taylor Inclusive School', 'Savar','7869','5','01618765432','proyash@gmail.com','Rett Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Proyash Cantonment', 'Dhaka Cantonment','2349','5','01715643981','proyash@gmail.com','Asperger’s Syndrome','2000')" );
        DB.execSQL("insert into Schools(Name, location, EIIN, Rating, Contact, Email, Special, fee) values ('Autistic Children Welfare Foundation', 'Chittagong','7658','5','0161456611','proyash@gmail.com','Rett Syndrome','3000')" );



        DB.execSQL("create Table Doctor(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Specialised TEXT, Location TEXT,qua TEXT,hospi TEXT,avai TEXT)");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Bonday Ali', 'Asperger’s Syndrome', 'Mahammadpur','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Prof. Dr. Md. Siraj Uddin', 'Asperger’s Syndrome', 'Lalbagh','MBBS','Ever Care','9 AM-5 PM')");


        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. M. M. Jayed Hossain', 'Rett Syndrome', 'Lalmatia','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Prof. Dr. Md. Zulfiqar Hasan', 'Rett Syndrome', 'Mahammadpur','MBBS','Ever Care','9 AM-5 PM')");

        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Tahmina Banu', 'Childhood Disintegrative Disorder(CDD)', 'Chankharpul','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Bhabesh Chandra Mondal', 'Childhood Disintegrative Disorder(CDD)', 'Banani','MBBS','Ever Care','9 AM-5 PM')");

        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Md. Quamrul Islam', 'Pervasive Developmental Disorder', 'Dhanmondi','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Prof. Wahiuddin Mahmood', 'Pervasive Developmental Disorder', 'Muhammadpur','MBBS','Ever Care','9 AM-5 PM')");

        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Shah Muhammad Ali', 'Kanner’s Syndrome', 'Dhanmondi','MBBS','Ever Care','9 AM-5 PM')");
        DB.execSQL("insert into Doctor(Name,Specialised,Location,qua,hospi,avai) values('Dr. Syeda Ishrat Jahan', 'Kanner’s Syndrome', 'Banani','MBBS','Ever Care','9 AM-5 PM')");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1)
    {
        DB.execSQL("drop Table if exists Infomation");
        DB.execSQL("drop Table if exists Schools");
        DB.execSQL("drop Table if exists Doctor");
        onCreate(DB);
    }


    public Boolean insertdata(String name, String address, String id, String pass, String disease, String blood)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Address", address);
        contentValues.put("UserID", id);
        contentValues.put("Password", pass);
        contentValues.put("Disease", disease);
        contentValues.put("Blood", blood);
        long result= DB.insert("Infomation",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean insertdata1(String name, String address, String id, String rate,String contact,String email, String special, String fee)
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("location", address);
        contentValues.put("EIIN", id);
        contentValues.put("Rating", rate);
        contentValues.put("Contact", contact);
        contentValues.put("Email", email);
        contentValues.put("Special", special);
        contentValues.put("fee", fee);
        long result= DB.insert("Schools",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean insertdata2(String name, String special, String address, String qua, String hospital, String time )
    {
        SQLiteDatabase DB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Specialised", special);
        contentValues.put("Location", address);
        contentValues.put("qua", qua);
        contentValues.put("hospi", hospital);
        contentValues.put("avai", time);
        long result= DB.insert("Doctor",null, contentValues);

        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkID(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID= ?", new String[]{name});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkeiin(String name){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Schools where EIIN= ?", new String[]{name});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checklogin(String name, String password){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID= ? and Password= ?", new String[]{name,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Cursor getinfo(String name){
        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor cursor= DB.rawQuery("Select * from Infomation where UserID=?", new String[]{name});
        return cursor;
    }

    public Cursor getdoctor(){
        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor cursor= DB.rawQuery("Select * from Doctor",null);
        return cursor;
    }
    public boolean checkdoctor(String Specialised1, String Specialised2){
        if(Specialised1.equals(Specialised2)){
            return true;
        }else{
            return false;
        }
    }
}