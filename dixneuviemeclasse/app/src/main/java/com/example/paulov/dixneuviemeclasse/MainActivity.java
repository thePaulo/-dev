package com.example.paulov.dixneuviemeclasse;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void notify(View view) {
        Notification.Builder builder = new Notification.Builder(this);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//Fuleragem do android 8=<
            builder = new Notification.Builder(this, NotificationUtils.getChannelId(this));
        }
        builder.setSmallIcon(android.R.drawable.sym_action_chat);

        Notification.BigTextStyle style = new Notification.BigTextStyle()
                .setBigContentTitle("Titulo de notificacao")
                .bigText("Texto da minha notificacao");
        builder.setStyle(style);

        Icon icon = Icon.createWithResource(this,android.R.drawable.ic_menu_view);
        Intent intent1 = new Intent(this,NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON_1);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this,0,intent1,0);


        Intent intent2 = new Intent(this,NotificationReceiver.class);
        intent1.setAction(NotificationReceiver.ACTION_BUTTON_2);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this,0,intent1,0);

        Notification.Action action1 = new Notification.Action.Builder(icon,"Botao 1",pendingIntent1).build();
        Notification.Action action2 = new Notification.Action.Builder(icon,"Botao 2",pendingIntent2).build();

        builder.addAction(action1);
        builder.addAction(action2);



        Notification notification= builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(50,notification);
    }
}
