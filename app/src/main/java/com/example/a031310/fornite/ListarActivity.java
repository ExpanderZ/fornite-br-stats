package com.example.a031310.fornite;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarActivity extends ListActivity {

    protected ArrayList<String> ids, nicknames, winstotais;
    protected Activity activity;

    protected ArrayAdapter<String> arrayAdapter;
    protected AdaptadorBaseDados a;

    @Override
    protected void onStart() {
        super.onStart();
        a = new AdaptadorBaseDados(this).open();
        ids = new ArrayList<String>();
        nicknames = new ArrayList<>();
        winstotais = new ArrayList<>();
        a.obterTodosCampos(ids, nicknames, winstotais);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nicknames);
        setListAdapter(arrayAdapter);
    }

    protected void onStop() {
        super.onStop();
        a.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        activity = this;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mudarDeEcra(Main3Activity.class, nicknames.get(position));
    }

    

    private void mudarDeEcra(Class<?> subAtividade, String nickname) {
        Intent x = new Intent(this, subAtividade);
        x.putExtra("aTag", nickname);
        startActivity(x);
    }
}
