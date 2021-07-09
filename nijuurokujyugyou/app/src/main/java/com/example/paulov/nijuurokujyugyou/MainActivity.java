package com.example.paulov.nijuurokujyugyou;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button button_carregar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_carregar = findViewById(R.id.button_carregar);
        txtResultado = findViewById(R.id.txtResult);

        button_carregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyTask task = new MyTask();
                String urlCep = "https://viacep.com.br/ws/59152250/json/";
                task.execute(urlCep);
            }
        });
    }

    class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];

            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                inputStream = connection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader reader = new BufferedReader(inputStreamReader);
                buffer = new StringBuffer();

                String linha = "";
                while((linha = reader.readLine()) != null){
                    buffer.append(linha);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String rua="";
            String bairro="";
            try {
                JSONObject jsonObject = new JSONObject(s);
                rua = jsonObject.getString("logradouro");
                bairro = jsonObject.getString("bairro");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            txtResultado.setText("rua "+rua+" bairro "+bairro);
        }
    }
}
