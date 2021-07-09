package com.example.paulov.projectsofarunidd2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ItemAdapter itemAdapter;
    private boolean actionModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dic = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dic);

        itemAdapter = new ItemAdapter(this);
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                MyEditDialog.show(getSupportFragmentManager(), new MyEditDialog.OnTextListener() {
                    @Override
                    public void onSetText(String texto) {
                        Toast.makeText(MainActivity.this,"Texto passado: "+texto,Toast.LENGTH_SHORT).show();
                        itemAdapter.itens.add(texto);

                    }
                });

                //Toast.makeText(this,"Cliquei add",Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
