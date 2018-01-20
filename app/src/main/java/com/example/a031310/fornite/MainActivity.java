package com.example.a031310.fornite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected TextView textView, textView2;
    protected EditText editText;
    protected Button buttonS, buttonL;

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    private void mudarDeEcra(Class<?> subAtividade, String tag) {
        Intent x = new Intent(this, subAtividade);
        x.putExtra("aTag", tag);
        startActivity(x);
    }

    private void mudarDeEcra(Class<?> subAtividade) {
        Intent x = new Intent(this, subAtividade);
        startActivity(x);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        buttonS = (Button) findViewById(R.id.buttonS);
        buttonL = (Button) findViewById(R.id.buttonL);

        buttonS.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mudarDeEcra(Main2Activity.class, editText.getText().toString());


            }
        });

        buttonL.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mudarDeEcra(ListarActivity.class);
            }
        });

    }

}
