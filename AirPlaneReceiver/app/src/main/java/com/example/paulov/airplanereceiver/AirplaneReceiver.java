package com.example.paulov.airplanereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AirplaneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Bundle bndl = intent.getExtras();

            Boolean b = bndl.getBoolean("state");

            if(b == Boolean.TRUE){
                Toast.makeText(context,"MODO AVIAO LIGADO",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context,"MODO AVIAO DESLIGADO",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
