package br.ufrn.imd.reposicao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EditNoteActivity extends Activity {
	
	private EditText edtNote;
	private Note note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_edit_note);
		
		edtNote = findViewById(R.id.edt_note);
		
		note = (Note) getIntent().getSerializableExtra("note");
		
		if (note != null) {
			// Se note existe, significa que é uma edição. Carrega os dados da nota na tela
			edtNote.setText(note.getConteudo());
		}
	}
	
	public void cancelar(View view) {
		// Cancela a operação
		setResult(RESULT_CANCELED);
		finish();
	}
	
	public void gravar(View view) {

	    if(note == null){
            final String conteudo = edtNote.getText().toString();
            NoteNameDialog.show(getFragmentManager(), new NoteNameDialog.OnNoteNameSetListener() {
                @Override
                public void onNoteNameSet(String noteName) {
                    Toast.makeText(getApplicationContext(),"Adicionei esse note "+noteName,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.putExtra("nome",noteName);
                    intent.putExtra("note",R.id.edt_note);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }else{

	        Intent intent = new Intent();
	        intent.putExtra("note",R.id.edt_note);
	        setResult(RESULT_OK,intent);
	        finish();
        }
        // Se a nota não existe, abre o dialog solicitando o nome dela
        // Obtém o nome escolhido pelo usuário e grava o registro no banco de dados
        // Se a nota já existe, sobrescreve o conteúdo

	}
	

}
