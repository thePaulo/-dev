package com.example.paulov.trabalho1_unidade2paulovictorsousa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;
import android.widget.Toast;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    TextView txt;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        txt = getActivity().findViewById(R.id.text_id);
        return new DatePickerDialog(getActivity(),this,2018,9,18);
    }


    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        String msg = day+" / "+(month+1)+" / "+year;
        txt.setText(msg);
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

}