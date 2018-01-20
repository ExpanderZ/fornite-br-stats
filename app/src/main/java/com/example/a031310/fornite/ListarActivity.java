package com.example.a031310.fornite;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends ListActivity {


    @Override
    protected void onStart(){
        super.onStart();
    }

    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

    }
}
