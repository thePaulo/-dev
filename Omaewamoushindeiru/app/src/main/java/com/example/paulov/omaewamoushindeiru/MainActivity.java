package com.example.paulov.omaewamoushindeiru;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends Activity {

    TextView txt;
    Button button;
    ImageView img;
    FrameLayout frame;
    TextView displayer;
    int value=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frame = findViewById(R.id.txt_frame);
        button= findViewById(R.id.btn_id);
        txt = findViewById(R.id.txt_algo);

        displayer = findViewById(R.id.display_value);


        //img = findViewById(R.id.albedo);
        //img.setVisibility(View.GONE);

        /*img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.albedo){
                    img.setVisibility(View.VISIBLE);
                }else{
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });*/
    }

    public void activeFocus(View view){
        frame.setVisibility(View.GONE);
        /*if (view.getId() == R.id.albedo || view.getId() == R.id.btn_id){
            img.setVisibility(View.VISIBLE);
        }else{
            img.setVisibility(View.INVISIBLE);
        }*/
    }

    public void showScreen(View view){
        String tag = view.getTag().toString();
        int dado = Integer.parseInt(tag);
        value = dado;

        /*Random gen = new Random();
        String num = Integer.toString(gen.nextInt(dado)+1 );
        txt.setText( num );//+ Html.fromHtml("<b><h6>d20</h6></b>"));*/

        displayer.setText("d"+tag);
        if(dado == 6 || dado == 2){
            displayer.setText("d20");
        }

        /*TextView dice = findViewById(R.id.dice);
        dice.setText("d"+tag+":[+"+ num+"]");

        frame.setVisibility(View.VISIBLE);*/
        //img.setVisibility(View.VISIBLE);
    }

    public void rowFunction(View view){

        Random gen = new Random();
        String num = Integer.toString(gen.nextInt(value)+1 );
        txt.setText( num );//+ Html.fromHtml("<b><h6>d20</h6></b>"));

        if(value == 2){
            num = Integer.toString(20);
            txt.setText("20");
        }
        if(value == 6){
            num = Integer.toString(gen.nextInt(5)+16 );
            txt.setText( num );//+ Html.fromHtml("<b><h6>d20</h6></b>"));
        }


        TextView dice = findViewById(R.id.dice);
        dice.setText("d"+Integer.toString(value)+":[+"+ num+"]");

        if(value == 2 || value == 6) {
            dice.setText("d20:[+" + num + "]");
        }

        frame.setVisibility(View.VISIBLE);

    }

}
