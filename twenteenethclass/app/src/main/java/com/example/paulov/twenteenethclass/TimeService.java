package com.example.paulov.twenteenethclass;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;


public class TimeService extends IntentService {

    public TimeService() {
        super("TimeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for(int i=0;i<10;i++){
            Log.i("MyApp","Segundos = "+i);
            SystemClock.sleep(1000);
        }
    }

}
