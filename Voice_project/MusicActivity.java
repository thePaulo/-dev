package com.example.paulov.voice_project;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MusicActivity extends AppCompatActivity {
    MediaPlayer mp3 = new MediaPlayer();
    String[] animes;
    String[] musics;
    TypedArray images;
    AutoCompleteTextView auto;
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        animes = getResources().getStringArray(R.array.animes);//lista de animes
        musics = getResources().getStringArray(R.array.musics);//lista de musicas
        //images = getResources().getIntArray(R.array.animes);//lista de imagens
        images = getResources().obtainTypedArray(R.array.images);

        //parte referente ao strings.h
        auto = findViewById(R.id.edt_anime);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.animes,android.R.layout.simple_list_item_1);

        auto.setAdapter(adapter);
        //fim da parte do strings.h


        Random random = new Random();

        index = random.nextInt(animes.length);
        try{
            mp3.setDataSource(musics[index]);
            mp3.prepare();

        }catch (Exception e){}

        mp3.start();
    }


    public void submit(View view) {

        if(auto.getText().toString().equals(animes[index])){
            Toast.makeText(this,"SEIKAI !!",Toast.LENGTH_SHORT).show();
            //getSupportFragmentManager().findFragmentById(R.id.fragment_id).getView().setBackgroundColor(R.drawable.mob_psycho);
            Fragment f = (ImageFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_id);
            ((ImageFragment) f).setImage(images.getResourceId(index,-1));
        }else{
            Toast.makeText(this,"WARUI KOTAE :(",Toast.LENGTH_SHORT).show();
        }

    }

    public void stop(View view) {
        mp3.stop();
        mp3.release();

    }
}
