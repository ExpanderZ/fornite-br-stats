package com.example.a031310.fornite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A031310 on 09/01/2018.
 */
public class AdaptadorBaseDados {
    private AjudaUsoBaseDados dbHelper;
    private SQLiteDatabase database;

    public AdaptadorBaseDados(Context context) {
        dbHelper = new AjudaUsoBaseDados(context.getApplicationContext());
    }

    public AdaptadorBaseDados open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private Cursor obterTodosRegistos() {
        String[] colunas = new String[2];
        colunas[0] = "nickName";
        colunas[1] = "winstotal";
        return database.query("players", colunas, null, null, null, null, null);
    }


    public int obterTodosCampos(List<String> ids, List<String> nickName, List<String> winstotal) {
        String[] colunas = new String[23];
        colunas[0] = "_id";
        colunas[1] = "nickName";
        colunas[2] = "winstotal";
        Cursor c = database.query("players", colunas, null, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                ids.add(c.getString(0));
                nickName.add(c.getString(1));
                winstotal.add(c.getString(2));
            } while (c.moveToNext());
        }
        c.close();
        return ids.size();
    }

    public long inserirDados(String nickname, String winstotal) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nickName", nickname);
        contentValues.put("winstotal", winstotal);

        return database.insert("players", null, contentValues);
    }

    public void deletePlayer(String nickname) {
        String query = "DELETE FROM players WHERE nickName = '" + nickname + "';";
        database.execSQL(query);
    }


}