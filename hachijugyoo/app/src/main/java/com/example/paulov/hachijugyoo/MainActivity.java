package com.example.paulov.hachijugyoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AlimentosFragment.OnItemClick{

    private TextFragment textFragment;

    private static final NumberFormat nf = NumberFormat.
            getCurrencyInstance(new Locale("pt","BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFragment = (TextFragment)getSupportFragmentManager().findFragmentById(R.id.frag_text);
    }

    @Override
    public void onClick(Alimento alimento) {
        textFragment.setText(String.format("O preco do %s é %s",
                alimento.getNome(),nf.format(alimento.getPreco())));
    }
}
