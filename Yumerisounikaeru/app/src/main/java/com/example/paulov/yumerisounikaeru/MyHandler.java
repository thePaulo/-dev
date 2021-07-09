package com.example.paulov.yumerisounikaeru;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class MyHandler extends Handler {
    private TextView textView;
    private Button button;

    public MyHandler(TextView textView, Button button){
        this.button = button;
        this.textView = textView;
    }

    @Override
    public void handleMessage(Message msg){
        if(msg.what == 100){
            textView.setText("Procesamento Finalizado");
            button.setEnabled(true);
        }
    }
}
