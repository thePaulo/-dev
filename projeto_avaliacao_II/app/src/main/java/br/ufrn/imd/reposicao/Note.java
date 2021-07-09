package br.ufrn.imd.reposicao;

import java.io.Serializable;

import android.content.ContentValues;
import android.database.Cursor;

@SuppressWarnings("serial")
public class Note implements Serializable {


	private long id;
	private String nome;
	private String conteudo;

	@Override
	public String toString() {

		return nome;
	}


	public long getId() {
		return id;

	}

	public void setId(long id) {

		this.id = id;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getNome(){
		return nome;
	}

	public String getConteudo() {

		return conteudo;
	}

	public void setConteudo(String conteudo) {

		this.conteudo = conteudo;
	}

	

}
