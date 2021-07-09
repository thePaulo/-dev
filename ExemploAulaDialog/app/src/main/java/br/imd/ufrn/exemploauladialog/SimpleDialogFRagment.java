package br.imd.ufrn.exemploauladialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class SimpleDialogFRagment extends DialogFragment implements DialogInterface.OnClickListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Escolha uma liguagem")
                .setItems(R.array.linguagens,this)
                .create();

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String[] linguagens = getActivity().getResources().getStringArray(R.array.linguagens);
        String linguagem = linguagens[i];

        Toast.makeText(getActivity(), "Você escolheu a linguagem "+linguagem, Toast.LENGTH_SHORT).show();
    }
}
