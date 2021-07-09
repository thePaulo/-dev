package com.example.paulov.nanajyugyo;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ButtonFragment extends Fragment implements View.OnClickListener{
    private ChangeColorListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(!(context instanceof ChangeColorListener)){
            throw new RuntimeException("deve ser uma ChangeColorListner");
        }
        this.listener = (ChangeColorListener)context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_button,container,false);
        view.findViewById(R.id.btn_black).setOnClickListener(this);
        view.findViewById(R.id.btn_red).setOnClickListener(this);
        view.findViewById(R.id.btn_yellow).setOnClickListener(this);
        view.findViewById(R.id.btn_green).setOnClickListener(this);
        view.findViewById(R.id.btn_blue).setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        int color;
        int id = view.getId();

        if(id == R.id.btn_black){
            color = Color.BLACK;
        }
        else if(id == R.id.btn_blue){
            color = Color.BLUE;
        }
        else if(id == R.id.btn_green){
            color = Color.GREEN;
        }
        else if(id == R.id.btn_red){
            color = Color.RED;
        }
        else if(id == R.id.btn_yellow){
            color = Color.YELLOW;
        }else{
            color = Color.WHITE;
        }

        listener.changeColor(color);
    }

    public interface ChangeColorListener{
        void changeColor(int color);
    }
}
