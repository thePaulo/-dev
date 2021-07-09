package com.example.paulov.nijyuuichijyugyou;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        textView = findViewById(R.id.txt_text);

        Constants.Type type = (Constants.Type) getIntent().getSerializableExtra(Constants.STORAGE_TYPE);

        try{
            if(type == Constants.Type.INTERNAL){
                readInternal();
            }else{
                readExternal();
            }
        }catch (IOException e){
            Toast.makeText(this,"Erro "+ e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void readInternal() throws IOException{
        FileInputStream in = openFileInput(Constants.FILE_NAME);

        try(Scanner scanner= new Scanner(in)) {
            StringBuilder sb = new StringBuilder();

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());
            }
            textView.setText(sb.toString());
        }
    }


    private void readExternal() throws IOException{
        String status = Environment.getExternalStorageState();

        if(!status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("Área de armazenamento nao esta pronta");
        }

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir,Constants.FILE_NAME);

        try(Scanner scanner = new Scanner(file)){
            StringBuilder sb = new StringBuilder();

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                sb.append(line).append(System.lineSeparator());

            }

            textView.setText(sb.toString());
        }
    }
}
