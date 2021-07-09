package com.example.paulov.a2ndclassproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBotao = findViewById(R.id.btnButtao);

        Log.i("myapp","onCreate()");
    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == 10){
            String mensagem = data.getStringExtra("mensagem");
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
            btnBotao.setEnabled(false);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("myapp","onResume");
    }

    @Override
    protected  void onPause(){
        super.onPause();
        Log.i("myapp","onPause");
    }

    @Override
    protected  void onStop(){
        super.onStop();
        Log.i("myapp","onStop");
    }



    public void next(View view) {

        Intent it = new Intent(this,SegundaActivity.class);
        it.putExtra("texto","Deu certo");
        startActivityForResult(it,10);
        //startActivity(it);
    }
}
