package com.example.paulov.vingtimeclasse;

import android.os.SystemClock;
import android.util.Log;

public class TimeWorker implements Runnable{

    private volatile boolean running;
    private int seconds;

    @Override
    public void run() {
        running=true;

        while(running){
            incrementSeconds();
            //seconds++;
            Log.i("MyApp","Segundos ="+seconds);
            SystemClock.sleep(1000);
        }
    }

    public void stop(){
        running = false;
    }

    private synchronized void incrementSeconds(){
        seconds++;
    }
    public synchronized int getSeconds(){
        return seconds;
    }
}
