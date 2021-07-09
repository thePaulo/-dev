package com.example.paulov.nijyuuichijyugyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void readExternal(View view) {
        Intent intent = new Intent(this,ReadActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE,Constants.Type.EXTERNAL);

        startActivity(intent);
    }

    public void writeExternal(View view) {
        Intent intent = new Intent(this,WriteActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE,Constants.Type.EXTERNAL);

        startActivity(intent);
    }

    public void readInternal(View view) {
        Intent intent = new Intent(this,ReadActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE,Constants.Type.INTERNAL);

        startActivity(intent);
    }

    public void writeInternal(View view) {
        Intent intent = new Intent(this,WriteActivity.class);
        intent.putExtra(Constants.STORAGE_TYPE,Constants.Type.INTERNAL);

        startActivity(intent);

    }
}
