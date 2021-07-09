package com.example.paulov.nijyuujugyou;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TimeService extends Service {

    private TimeWorker worker;

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
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        worker.stop();
    }
}
