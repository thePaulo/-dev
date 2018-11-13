package com.example.paulov.voice_project;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView txt;
    TextToSpeech textToSpeech;
    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //parte referente ao strings.h
        auto = findViewById(R.id.edt_anime);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.animes,android.R.layout.simple_list_item_1);

        auto.setAdapter(adapter);
        //fim da parte do strings.h

        btn = (Button)findViewById(R.id.btn_id);
        txt = (TextView)findViewById(R.id.txt_view);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.JAPANESE);
                }
            }
        });

    }

    public void sendJP(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ja-JP");//"ja-JP"
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hii speak now... ");
        try {
            startActivityForResult(intent, 199);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"It wasen't possible to complete this call",Toast.LENGTH_SHORT).show();
        }
    }


    public void send(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"en-US");//"ja-JP"
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hii speak now... ");
        try {
            startActivityForResult(intent, 199);
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"It wasen't possible to complete this call",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null){
            ArrayList<String> voiceInText = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            txt.setText(voiceInText.get(0));
            if(voiceInText.get(0).equals("play some stuff")){
                final MediaPlayer mp3 = MediaPlayer.create(this,R.raw.noragami_op_2_full);
                mp3.start();
            }
        }

    }

    public void play(View view) {
        /*MediaPlayer mp3 = new MediaPlayer();
        try {
            mp3.setDataSource("https://api-2.datmusic.xyz/links/5efdcf960b639f5f83d5bf87fbeed46f/Coe%20Shu%20Nie%20-%20Asphyxia.mp3");
            mp3.prepare();
        }catch (Exception e){}*/
        final MediaPlayer mp3 = MediaPlayer.create(this,R.raw.noragami_op_2_full);
        mp3.start();
    }


    public void tts(View view) {


        textToSpeech.speak(txt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }

    public void submit(View view) {
        /*
        MediaPlayer mp3 = new MediaPlayer();
        int index =0;
        String[] animes = getResources().getStringArray(R.array.animes);
        String[] musics = getResources().getStringArray(R.array.musics);

        for (String s:animes) {

            if(auto.getText().toString().equals(s)){


                try {
                    mp3.setDataSource(musics[index]);
                    mp3.prepare();

                }catch (Exception e){}
            }

            index++;
        }
        mp3.start();*/
        Intent intent = new Intent(this,MusicActivity.class);
        startActivity(intent);
        /*if(auto.getText().toString().contains("noragami")){
            Toast.makeText(this, "RELL YEAH", Toast.LENGTH_SHORT).show();
        }*/
    }
}
