package com.example.paulov.voice_project;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
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

        animes = getResources().getStringArray(R.array.animes);//lista de musicas
        musics = getResources().getStringArray(R.array.musics);//lista de musicas
        images = getResources().obtainTypedArray(R.array.images);//lista de imagens

        //parte referente ao strings.h para autocomplete
        auto = findViewById(R.id.edt_anime);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.animes,android.R.layout.simple_list_item_1);

        auto.setAdapter(adapter);
        //fim da parte do strings.h

        //parte referente a tocar a musica
        Random random = new Random();
        index = random.nextInt(animes.length);
        try{
            mp3.setDataSource(musics[index]);
            mp3.prepare();

        }catch (Exception e){}

        mp3.start();
        //fim da parte de tocar musica
        notification_stuff();

    }

    public void notification_stuff(){
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.star_big_off)
                .setContentTitle("Now playing...")
                .setContentText("??");

        Icon icon = Icon.createWithResource(this,android.R.drawable.star_big_on);
        Intent intent = new Intent(getApplicationContext(),NotificationReceiver.class);
        intent.setAction(NotificationReceiver.ACTION_BUTTON_1);
        intent.putExtra("action",animes[index]);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),50,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        //sendBroadcast(intent);
        //sendOrderedBroadcast(intent,null);

        Notification.Action action = new Notification.Action.Builder(icon,"Show song",pendingIntent).build();
        builder.addAction(action);

        Notification notification= builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(50,notification);

    }


    public void submit(View view) {

        TextView name = (TextView)findViewById(R.id.type_id);

        if(auto.getText().toString().equals(animes[index])){
            Toast.makeText(this,"SEIKAI !!",Toast.LENGTH_SHORT).show();
            name.setTextColor(Color.GREEN);


        }else{
            Toast.makeText(this,"CHIGAU :(",Toast.LENGTH_SHORT).show();
            name.setTextColor(Color.RED);
        }

        Fragment f = (ImageFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_id);
        ((ImageFragment) f).setImage(images.getResourceId(index,-1));

        TextView songName = (TextView)findViewById(R.id.song_id);
        songName.setText("Last song was : ");//+animes[index]);
        name.setText(animes[index] + "\nGUESS THE NEXT ANIME SONG!");

        auto.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);//Escondendo o teclado do google


        mp3.pause();
        mp3 = new MediaPlayer();

        //o cara acertou/errou a musica e o player vai mudar para a prox musica
        Random random = new Random();
        index = random.nextInt(animes.length);
        try{
            mp3.setDataSource(musics[index]);
            //mp3.setOnPreparedListener(this);
            //mp3.prepareAsync();
            mp3.prepare();

        }catch (Exception e){}

        new Thread(new Runnable() {
            @Override
            public void run() {


                SystemClock.sleep(2000);

                mp3.start();

                //fim da parte de tocar musica
            }
        }).start();


        notification_stuff();

    }

    public void stop(View view) {
        parar();
    }
    public void parar(){
        mp3.stop();
        mp3.release();

        NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(50);
    }

    @Override
    public void onBackPressed() {
        parar();
        super.onBackPressed();
    }
}
