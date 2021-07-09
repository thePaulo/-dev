package br.ufrn.imd.reposicao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.ufrn.imd.reposicao.R;

// Dialog para digitação do nome da nota
public class NoteNameDialog extends DialogFragment {

	// Listener para avisar sobre a definição do nome da nota
	private OnNoteNameSetListener listener;
	
	private EditText edtNoteName;
	
	// Exibe o dialog
	public static void show(FragmentManager fm, OnNoteNameSetListener listener) {
		NoteNameDialog dialog = new NoteNameDialog();
		dialog.listener = listener;
		dialog.show(fm, "noteNameDialog");
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle(R.string.dialog_title);
		builder.setPositiveButton(R.string.dialog_btn_ok, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (listener != null) {
					String noteName = edtNoteName.getText().toString();
					listener.onNoteNameSet(noteName);
				}
			}
		});
		
		// Define uma view customizada para o dialog
		View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_note_name, null);
		edtNoteName = view.findViewById(R.id.edt_notename);
		
		builder.setView(view);
		
		return builder.create();
	}

	public interface OnNoteNameSetListener {
		void onNoteNameSet(String noteName);
	}
}
