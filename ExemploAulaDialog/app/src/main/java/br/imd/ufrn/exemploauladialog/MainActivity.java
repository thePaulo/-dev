package br.imd.ufrn.exemploauladialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(),"dialog");
    }

    public void openSimple(View view) {
        SimpleDialogFRagment simpleDialog = new SimpleDialogFRagment();
        simpleDialog.show(getSupportFragmentManager(),"simpleDialog");
    }

    public void openRadio(View view) {
        RadioDilalogFragment radioDialog = new RadioDilalogFragment();
        radioDialog.show(getSupportFragmentManager(),"radioDialog");

    }

    public void openMutiple(View view) {
        MultipleDialogFragment multiple = new MultipleDialogFragment();
        multiple.show(getSupportFragmentManager(),"dialogMultiple");
    }
}
