package com.example.qrtry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String sessionID = getIntent().getStringExtra("resultIntentInfo");
        TextView txtView = findViewById(R.id.displayQRtext);
        txtView.setText(sessionID);


        //trocando imagem de display
        ImageView imgView = findViewById(R.id.displayImage);
        //imgView.setImageResource(R.drawable.senku2);


        //ajustando descrições

        String[] trees = getResources().getStringArray(R.array.trees);
        String[] info = getResources().getStringArray(R.array.description);
        //String[] images = getResources().getStringArray(R.array.images);
        TypedArray images = getResources().obtainTypedArray(R.array.images);

        int searched=-1;
        int i =0;

        //buscando no strings.xml a arvore certa
        while (searched==-1 && i< trees.length ){
            if (sessionID.equals(trees[i])){
                searched=i;
            }
            i++;
        }

        TextView infoView = findViewById(R.id.displayInfo);

        //aplicando foto/texto apropriado
        if( searched == -1){
            infoView.setText("Não foi achado essa planta/animal");
        }
        else{
            infoView.setText(info[searched]);
            imgView.setImageResource(images.getResourceId(searched,-1));
        }

    }
}
