package com.example.paulov.neuviemeclasse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class MultipleDialogFragment extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        boolean[] checked = {true,false,true,false,true};

        return new AlertDialog.Builder(getActivity())
                .setTitle("Escolha uma ou mais bandas")
                .setMultiChoiceItems(R.array.linguagens,checked,this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
        String[] linguagens = getActivity().getResources().getStringArray(R.array.linguagens);
        String linguagem = linguagens[i];

        if(isChecked){
            Toast.makeText(getActivity(),"voce escolheu a linguagem: "+linguagem,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"voce nao escolheu a linguagem",Toast.LENGTH_SHORT).show();
        }
    }
}
