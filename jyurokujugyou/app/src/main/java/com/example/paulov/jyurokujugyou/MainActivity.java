package com.example.paulov.jyurokujugyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPopup(View view){
        PopupMenu popup = new PopupMenu(this,view);
        popup.inflate(R.menu.popup);
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.act_action1){
            Toast.makeText(this,"Clickou na ação 1",Toast.LENGTH_SHORT).show();
            return true;
        }else if(menuItem.getItemId() == R.id.act_action2){
            Toast.makeText(this,"Clickou na ação 2",Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
