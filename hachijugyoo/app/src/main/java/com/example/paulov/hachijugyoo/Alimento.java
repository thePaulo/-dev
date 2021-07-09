package com.example.paulov.hachijugyoo;

public class Alimento {
    private String nome;
    private double preco;

    public Alimento(String nome,double preco){
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome;
        //return super.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
