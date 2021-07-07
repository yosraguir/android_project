package com.example.tpbd;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class DB  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1 ;
    private static final String DATABASE_Name = "etudiantsManager";
    private static final String TABLE_ETUDIANTS ="etudiants";
    private static final String KEY_ID = "id" ;
    private static final String KEY_NAME ="name";
    private static final String KEY_ADD ="adress" ;


    public DB(Context context) {
        super(context, DATABASE_Name, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_ETUDIANTS + "("
                +KEY_ID+ "INTEGER PRIMARY KEY ," + KEY_NAME + "TEXT , "
                + KEY_ADD + "TEXT" + ")" ;
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANTS);
        onCreate(db);
        onCreate(db);

    }

    void addEtudiant (Etudiant etudiant) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME,etudiant.getName());
        values.put(KEY_ADD, etudiant.getAdresse());

        db.insert(TABLE_ETUDIANTS, null , values );
        db.close();


    }
    Etudiant getEtudiant (int id ){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor= db.query(TABLE_ETUDIANTS, new String[] {
                KEY_ID, KEY_NAME , KEY_ADD }, KEY_ID + "=?",
                new String[] {
                        String.valueOf(id) },null,null,null);
        if(cursor != null)
            cursor.moveToFirst();

        Etudiant etudiant = new Etudiant(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2)) ;

        return etudiant;
    }
    }

