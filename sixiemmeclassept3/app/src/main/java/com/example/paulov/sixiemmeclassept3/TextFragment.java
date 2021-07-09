package com.example.paulov.sixiemmeclassept3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TextFragment extends Fragment implements View.OnClickListener{

    private EditText editText;
    private Button button;

    private OnInvertListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(!(activity instanceof OnInvertListener)){
            throw new RuntimeException("Deve ser um OnInvertListener");
        }

        listener = (OnInvertListener)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text,container,false);
        editText = view.findViewById(R.id.edt_texto);
        button = view.findViewById(R.id.btn_inverter);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            String texto = editText.getText().toString();
            listener.onInvert(texto);
        }
    }

    public interface OnInvertListener{

        public void onInvert(String text);
    }
}
