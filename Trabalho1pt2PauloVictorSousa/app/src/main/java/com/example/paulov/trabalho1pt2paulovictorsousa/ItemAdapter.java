package com.example.paulov.trabalho1pt2paulovictorsousa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends  RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private Context context;
    private List<Item> itens = new ArrayList<>();

    public ItemAdapter(Context context){
        this.context = context;

        for(int i=1;i<=50;i++){
            Item item = new Item("indice "+String.valueOf(i));
            itens.add(item);
        }
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2,viewGroup,false);
        View view = LayoutInflater.from(context).inflate(R.layout.single_btn_n_txt,viewGroup,false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Item item = itens.get(i);

        itemHolder.btn.setText("INFO");
        itemHolder.txt.setText("indice "+String.valueOf(i));

        /*itemHolder.txtId.setText(String.valueOf(item.getId()));
        itemHolder.txtNome.setText(item.getNome());*/

    }

    @Override
    public int getItemCount() {
        //return 50;
        return itens.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements Button.OnClickListener{
        Button btn;
        TextView txt;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            btn = itemView.findViewById(R.id.btn_id);
            txt = itemView.findViewById(R.id.txt_id);

            //itemView.setOnClickListener(this);
            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Toast.makeText(context,"vc clikou esse carinha " +pos,Toast.LENGTH_SHORT).show();

        }
    }
}
