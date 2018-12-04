package com.example.paulov.voice_project;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    public static final String ACTION_BUTTON_1 = "br.ufrn.imd.action.ACTION_BUTTON_1";
    public static final String ACTION_BUTTON_2 = "br.ufrn.imd.action.ACTION_BUTTON_2";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        //String action = intent.getStringExtra("action");
        String msg;

        //Bundle extras = intent.getExtras();

        switch (action){

            case ACTION_BUTTON_1:
                //msg =extras.getString("name");
                //msg = "Botao1 clicado";
                msg = intent.getStringExtra("action");
                Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
                break;
            case ACTION_BUTTON_2:
                msg = "Botao2 clicado";
                break;
            default:
                msg = "Acao desconhecida";
                break;

        }
        //Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
        //NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


//        Context ctx = context.getApplicationContext();
//        Activity x = (MusicActivity)ctx;
//        ((MusicActivity) x).parar();
        //setResult(Activity.RESULT_OK,intent);
        //setResultCode(Activity.RESULT_OK);

        //nm.cancel(50);
    }
}
