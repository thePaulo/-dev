package com.example.paulov.vingtimeclasse;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private TextView txtView;
    private TimeService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txt_seconds);
    }

    public void start(View view){
        intent = new Intent(getApplicationContext(),TimeService.class);
        startService(intent);

        TimeServiceConnection conn = new TimeServiceConnection();
        bindService(intent,conn,0);

    }

    public void stop(View view){
        if(intent != null){
            stopService(intent);
        }
    }

    public void read(View view) {
        int seconds = service.getSeconds();
        txtView.setText(String.valueOf(seconds));
        
    }

    private class TimeServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TimeService.TimeServiceBind binder = (TimeService.TimeServiceBind) iBinder;
            MainActivity.this.service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
