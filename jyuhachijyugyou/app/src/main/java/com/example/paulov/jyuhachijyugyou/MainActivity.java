package com.example.paulov.jyuhachijyugyou;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ToastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new ToastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("br.ufrn.imd.android.broadcast.TOAST");
        registerReceiver(receiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        if(receiver != null){
            unregisterReceiver(receiver);
        }
        super.onDestroy();
    }

    public void send(View view) {


        Intent intent = new Intent("br.ufrn.imd.android.broadcast.TOAST");
        intent.putExtra("msg","Texto enviado pelo broadcast");
        sendBroadcast(intent);

    }
}
