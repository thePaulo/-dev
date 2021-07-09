package com.example.paulov.nineteenethclass;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void notify(View view) {
        final Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Baixando arquivo ...");
        builder.setContentText("Aguarde ...");
        builder.setSmallIcon(R.drawable.ic_download);

        builder.setProgress(0,0,true);

        //Notification notification = builder.build();
        manager.notify(50,builder.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                builder.setProgress(0,0,false);
                builder.setContentTitle("Arquivo baixado");
                builder.setContentText("Finalizado");
                manager.notify(50,builder.build());
            }
        }).start();

    }

    public void notify2(View view) {

        final Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Baixando arquivo ...");
        builder.setContentText("Aguarde ...");
        builder.setSmallIcon(R.drawable.ic_download);

        //builder.setProgress(0,0,true);

        //Notification notification = builder.build();
        manager.notify(50,builder.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    builder.setProgress(100,i,false);
                    manager.notify(50,builder.build());
                    SystemClock.sleep(500);
                }

                builder.setProgress(0,0,false);
                builder.setContentTitle("Arquivo baixado");
                builder.setContentText("Finalizado");
                manager.notify(50,builder.build());
            }
        }).start();

    }
}
