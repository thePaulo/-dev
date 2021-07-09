package br.ufrn.imd.reposicao;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.ufrn.imd.reposicao.R;

public class NotesActivity extends ListActivity implements OnItemLongClickListener {

	private ArrayAdapter<Note> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);



		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		
		// Registra evento de clique longo nos itens da lista
		getListView().setOnItemLongClickListener(this);


		// Atualiza a lista
		refreshList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.action_add){
			Intent intent = new Intent(this,EditNoteActivity.class);

			startActivityForResult(intent,10);
		}
        // Se o botão botão no menu for clicado, cria uma nova nota
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		String nome = data.getStringExtra("nome");
		String nota = data.getStringExtra("nota");

		Note note = new Note();
		note.setNome(nome);
		note.setConteudo(nota);

		Toast.makeText(this,"Nome Cadastrado"+ nome,Toast.LENGTH_SHORT).show();
		adapter.add(note);


        // Se o usuário efetivou a gravação, atualiza a lista para exibir a nova nota
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// Obtém a nota clicada
		// Inicia a activity de edição


        Note note = adapter.getItem(position);
        Intent intent = new Intent(this,EditNoteActivity.class);

        intent.putExtra("nome",note.getNome());

        intent.putExtra("note",note);

        startActivityForResult(intent,11);
	}
	
	private void refreshList() {
		// Limpa a lista
		// Obtém as notas gravadas
		// Adiciona os nomes das notas ao adapter
		adapter.notifyDataSetChanged();

	}

	@Override
	public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
		// Exclui a nota

		// Atualiza a lista

		Note note = adapter.getItem(position);
		adapter.remove(note);
		refreshList();

		return true;
	}
}
