package com.example.paulov.vingtimeclasse;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.sql.Time;

public class TimeService extends Service {

    private TimeWorker worker;

    private TimeServiceBind binder = new TimeServiceBind();

    @Override
    public void onCreate() {
        super.onCreate();

        worker = new TimeWorker();
        Log.i("MyApp","Serviço iniciado!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(worker).start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        worker.stop();
    }

    public int getSeconds(){
        return worker.getSeconds();
    }

    public class TimeServiceBind extends Binder{
        public TimeService getService(){
            return TimeService.this;
        }
    }
}
