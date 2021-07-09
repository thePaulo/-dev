package com.example.paulov.sixteenethclass;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);

        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager()) {
        };

        pager.setAdapter(adapter);

        if(savedInstanceState != null){
            int tab = savedInstanceState.getInt("tab");
            pager.setCurrentItem(tab);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab",pager.getCurrentItem());
    }
}
