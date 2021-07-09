package com.example.qrtry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checando se o user deu permissão de camera para o app rodar
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED ){
            Intent intent = new Intent(MainActivity.this,Scanner_Activity.class);
            startActivity(intent);
            Log.d("N SEI","DEU HORRIVEL");
        }else{
            Log.d("N SEI","DEU RUIM");
            Toast.makeText(MainActivity.this,"DEU RUIM",Toast.LENGTH_LONG);
            requestCameraPermission();
        }

        /*Intent intent = new Intent(MainActivity.this,Scanner_Activity.class);
        startActivity(intent);*/
    }
    //Dialog de aprovação da camera
    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
        /*if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this)
                    .setTitle("Permissão requerida")
                    .setMessage("Permissão de câmera é requerida para o aplicativo funcionar corretamente")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
        }*/
    }
    //Caso permissão concedida, procede para câmera, se não app fecha
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1){ // Permissão concedida
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(MainActivity.this,Scanner_Activity.class);
                startActivity(intent);
            }else{
                finish();
            }
        }
    }
}
