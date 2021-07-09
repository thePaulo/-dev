package com.example.paulov.nijyuuichijyugyou;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteActivity extends AppCompatActivity {

    private EditText editText;
    private Constants.Type type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        editText = findViewById(R.id.edt_text);

        type = (Constants.Type)getIntent().getSerializableExtra(Constants.STORAGE_TYPE);
    }

    public void write(View view){
        try {
            String text = editText.getText().toString();
            String path;

            if (type == Constants.Type.INTERNAL) {
                path = writeInternal(text);
            }else{
                path = writeExternal(text);
            }

            Toast.makeText(this,"Arquivo gravado em: "+path,Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this,"Erro "+e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private String writeInternal(String text) throws IOException {

        FileOutputStream out = openFileOutput(Constants.FILE_NAME,MODE_PRIVATE);
        try(PrintWriter pw = new PrintWriter(out)){
            pw.write(text);
            return getFilesDir().getPath()+ File.separator+Constants.FILE_NAME;
        }
    }

    private String writeExternal(String text) throws IOException{
        String status = Environment.getExternalStorageState();
        if(!status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("Área de armazenamento não está pronta");
        }

        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir,Constants.FILE_NAME);

        try(PrintWriter pw = new PrintWriter(file)){
            pw.write(text);
            return file.getPath();
        }
    }
}
