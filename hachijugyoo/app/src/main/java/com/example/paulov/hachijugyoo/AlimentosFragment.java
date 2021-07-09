package com.example.paulov.hachijugyoo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AlimentosFragment extends ListFragment{

    private ArrayAdapter<Alimento> adapter;
    private OnItemClick listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(!(context instanceof OnItemClick)){
            throw new RuntimeException("Deve ser um OnItemClick");
        }
        listener = (OnItemClick)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1);

        String[] nomes = getActivity().getResources().getStringArray(R.array.alimentos_nomes);
        String[] precos = getActivity().getResources().getStringArray(R.array.alimentos_precos);

        for(int i =0;i<nomes.length;i++){
            Alimento alimento = new Alimento(nomes[i],Double.parseDouble(precos[i]));
            adapter.add(alimento);

        }

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Alimento alimento = adapter.getItem(position);
        if(listener != null){
            listener.onClick(alimento);
        }

    }

    public interface OnItemClick{
        void onClick(Alimento alimento);
    }
}
