package com.example.paulov.a2ndclassproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends Activity {

    TextView txtTexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        String mensagem = params.getString("text");

        txtTexto = findViewById(R.id.txtTexto);
        txtTexto.setText(mensagem);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("mensagem","valor retornado");
        setResult(RESULT_OK,intent);
        finish();
    }
}
