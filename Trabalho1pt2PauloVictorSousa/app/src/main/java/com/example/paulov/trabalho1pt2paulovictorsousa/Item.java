package com.example.paulov.trabalho1pt2paulovictorsousa;

import android.widget.Button;

public class Item {
    private Button btn;
    private String nome;

    public Item(String nome){
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }
}
