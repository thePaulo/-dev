package com.example.paulov.nijyuunijyugyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<String,GeoLocalizacao> localizacoes = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localizacoes.put("Natal",new GeoLocalizacao(-5.7792569,-35.200916));
        localizacoes.put("João Pessoa",new GeoLocalizacao(-7.1194958,-34.8450118));
        localizacoes.put("Salvador",new GeoLocalizacao(-12.9722184,-38.5014136));
        localizacoes.put("Recife",new GeoLocalizacao(-8.0475622,-34.8769643));
        localizacoes.put("Teresina",new GeoLocalizacao(-5.0920108,-42.8037597));
        localizacoes.put("Aracajú",new GeoLocalizacao(-10.9472468,-37.7089492));
        localizacoes.put("Maceió",new GeoLocalizacao(-9.6498587,-35.7089492));
        localizacoes.put("São Luís",new GeoLocalizacao(-2.5391099,-44.2829046));
        localizacoes.put("Fortaleza",new GeoLocalizacao(-3.7319029,-38.5267393));

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new ArrayAdapter<>(this,R.layout.list_item,localizacoes.keySet().toArray()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cidade = ((TextView) view).getText().toString();
                GeoLocalizacao localizacao = localizacoes.get(cidade);

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("cidade",cidade);
                intent.putExtra("localizacao",localizacao);

                startActivity(intent);
            }
        });
        /*
        listView.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cidade = ((TextView) view).getText().toString();
                GeoLocalizacao localizacao = localizacoes.get(cidade);

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("cidade",cidade);
                intent.putExtra("localizacao",localizacao);

                startActivity(intent);
            }
        });*/
    }
}
