package com.example.emersonalencar.projetoexemplosqlite.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.emersonalencar.projetoexemplosqlite.data.Produto;

public class DeleteDialog extends DialogFragment implements DialogInterface.OnClickListener {

	private OnDeleteListener listener;
	private Produto produto;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

        if (!(activity instanceof OnDeleteListener)) {
            throw new RuntimeException("A activity deve implementar DialogFragment.OnDeleteListener");
        }

		this.listener = (OnDeleteListener) activity;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage("Deseja excluir o produto " + produto.getNome() + "?");
		builder.setPositiveButton("Sim", this);
		builder.setNegativeButton("Não", this);
		return builder.create();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if (which == DialogInterface.BUTTON_POSITIVE && listener != null) {
			listener.onDelete(produto);
		}
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

    public interface OnDeleteListener {
        public void onDelete(Produto produto);
    }
}
