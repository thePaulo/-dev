package com.example.paulov.dixhuitimeclasse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class EnergyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context,"CONECTADO",Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context,"Desconectado",Toast.LENGTH_SHORT).show();
        }
    }
}
