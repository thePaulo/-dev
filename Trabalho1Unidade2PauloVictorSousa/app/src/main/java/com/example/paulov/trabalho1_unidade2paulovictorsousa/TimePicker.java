package com.example.paulov.trabalho1_unidade2paulovictorsousa;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;
import android.widget.Toast;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    TextView txt;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        txt = getActivity().findViewById(R.id.text_id);
        return new TimePickerDialog(getActivity(),this,18,15,true);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int hora, int minuto) {
        String msg = hora + ":" + minuto;
        txt.setText( txt.getText() + " " + msg );
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
