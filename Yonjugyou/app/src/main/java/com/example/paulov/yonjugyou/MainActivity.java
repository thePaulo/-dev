package com.example.paulov.yonjugyou;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtConteudo;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtConteudo = findViewById(R.id.text_conteudo);
        progress = findViewById(R.id.progress);

        txtConteudo.setVisibility(View.GONE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        exibirConteudo();
                    }
                });
            }
        }).start();
    }

    public void exibirConteudo(){
        txtConteudo.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }
}
