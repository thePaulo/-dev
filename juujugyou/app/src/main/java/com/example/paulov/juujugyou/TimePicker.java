package com.example.paulov.juujugyou;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),this,18,15,true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int hora, int minuto) {
        String msg = hora + ":" + minuto;
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
