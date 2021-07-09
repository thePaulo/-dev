package com.example.paulov.projectsofarunidd2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends  RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private View longClickView;
    private Context context;
    public List<String> itens = new ArrayList<>();
    boolean actionModeActive;

    List<String> selected = new ArrayList<>();

    public ItemAdapter(Context context){
        this.context = context;

        //String primeiro = "primeiro item de zoa";
        String snd = "primeiro item aleatoreo";
        //itens.add(primeiro);
        itens.add(snd);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.text_layout,viewGroup,false);
        ItemHolder holder = new ItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        String item = itens.get(i);

        //itemHolder.txt.setText("indice "+String.valueOf(i));
        itemHolder.txt.setText(item);
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements Button.OnClickListener, View.OnLongClickListener,ActionMode.Callback {
        TextView txt;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            txt = itemView.findViewById(R.id.txt_id);
            itemView.setBackgroundColor(Color.WHITE);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            Toast.makeText(context,"vc clikou esse carinha " +itens.get(pos),Toast.LENGTH_SHORT).show();

        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            //Menu menu1 = ((Activity)context).findViewById(R.id.menu_action);
            //menu1.setvisi
            
            ((Activity)context).getMenuInflater().inflate(R.menu.long_item_click_menu,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            final int pos = getAdapterPosition();

            if(menuItem.getItemId() == R.id.edt_text){

                MyEditDialog.show(((FragmentActivity)context).getSupportFragmentManager(), new MyEditDialog.OnTextListener() {
                    @Override
                    public void onSetText(String texto) {
                        Toast.makeText(context,"Texto passado: "+texto,Toast.LENGTH_SHORT).show();
                        itens.set(pos,texto);
                        notifyDataSetChanged();

                    }
                });
                actionMode.finish();
            }else if(menuItem.getItemId() == R.id.erase_text){

                itens.remove(pos);
                notifyItemRemoved(pos);
                actionMode.finish();
            }

            return false;
        }



        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

            actionModeActive=false;
            longClickView.setBackgroundColor(Color.WHITE);
        }

        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(context,"LONGO CLICK",Toast.LENGTH_SHORT).show();

            longClickView = view;
            if(!actionModeActive){
                view.setBackgroundColor(Color.GREEN);
                int pos = getAdapterPosition();
                selected.add(itens.get(pos));

                ((Activity)context).startActionMode(this);
                actionModeActive = true;
            }
            return true;
        }
    }
}
