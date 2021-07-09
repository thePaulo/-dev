package com.example.emersonalencar.projetoexemplosqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private static ProdutoDAO instance;

    private SQLiteDatabase db;
    public static ProdutoDAO getInstance(Context context){
        if(instance == null){
            instance = new ProdutoDAO(context.getApplicationContext());
        }

        return instance;
    }

    private ProdutoDAO(Context context){
        DBHelper dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }

    public List<Produto> list(){
        String[] columns = {
                ProdutosContract.Columns._ID,
                ProdutosContract.Columns.NOME,
                ProdutosContract.Columns.VALOR
        };

        List<Produto> produtos = new ArrayList<>();

        try( Cursor c =db.query(ProdutosContract.TABLE_NAME,columns,null,null,null,null,ProdutosContract.Columns.NOME)){
            if(c.moveToFirst()){
                do {
                    Produto p = ProdutoDAO.fromCursor(c);
                    produtos.add(p);

                }while (c.moveToNext());
            }
        }

        return produtos;
    }

    private static Produto fromCursor(Cursor c){
        int id = c.getInt(c.getColumnIndex(ProdutosContract.Columns._ID));
        String nome = c.getString(c.getColumnIndex(ProdutosContract.Columns.NOME));
        double valor = c.getDouble(c.getColumnIndex(ProdutosContract.Columns.VALOR));
        return new Produto(id,nome,valor);
    }

    public void save(Produto produto){
        ContentValues values = new ContentValues();
        values.put(ProdutosContract.Columns.NOME,produto.getNome());
        values.put(ProdutosContract.Columns.VALOR,produto.getValor());

        long id = db.insert(ProdutosContract.TABLE_NAME,null,values);
        produto.setId((int)id);

    }

    public void update(Produto produto){
        ContentValues values = new ContentValues();
        values.put(ProdutosContract.Columns.NOME,produto.getNome());
        values.put(ProdutosContract.Columns.VALOR,produto.getValor());

        db.update(
                ProdutosContract.TABLE_NAME,
                values,
                ProdutosContract.Columns._ID+"=?",
                new String[]{String.valueOf(produto.getId())}
        );
    }

    public void delete(Produto produto){
        db.delete(
                ProdutosContract.TABLE_NAME,
                ProdutosContract.Columns._ID+"=?",
                new String[]{String.valueOf(produto.getId())}
        );
    }
}
