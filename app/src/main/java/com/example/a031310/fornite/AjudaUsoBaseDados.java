package com.example.a031310.fornite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by A031310 on 09/01/2018.
 */

    public class AjudaUsoBaseDados extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "players.db";
        private static final int VERSION = 1;
        public AjudaUsoBaseDados(Context context) {
            super(context, DATABASE_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String s = "CREATE TABLE players(_id integer primary key autoincrement, nickName varchar(40), winstotal varchar(40))";
            db.execSQL(s);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //db.execSQL("DROP TABLE IF EXISTS players");
            //onCreate(db);
        }
    }

