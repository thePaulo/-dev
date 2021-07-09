package com.example.paulov.neuviemeclasse;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class SimpleDialogFragment extends DialogFragment implements DialogInterface.OnClickListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle("Escolha uma linguagem")
                .setItems(R.array.linguagens,this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String[] linguagems = getActivity().getResources().getStringArray(R.array.linguagens);
        String linguagem = linguagems[i];

        Toast.makeText(getActivity(),"Voce escolheu a linguagem: "+linguagem,Toast.LENGTH_SHORT).show();
    }
}
