package com.example.paulov.fifteenethclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PlanetAdapter extends BaseAdapter{
    private List<Planet> planets;
    private OnItemClickListner listner;

    public PlanetAdapter(Context context, OnItemClickListner listner){
        planets = Planet.buildPlanets(context);
        this.listner = listner;
    }

    @Override
    public int getCount() {
        return planets.size();
    }

    @Override
    public Object getItem(int i) {
        return planets.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        ViewHolder vh;

        final Planet planet = planets.get(i);

        if(view == null){
            LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
            view = li.inflate(R.layout.drawer_list_item,viewGroup,false);

            vh = new ViewHolder();
            vh.textView = view.findViewById(R.id.text1);
            vh.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listner.OnClick(planet);
                }
            });

            view.setTag(vh);
        }else{
            vh = (ViewHolder) view.getTag();
        }
        vh.textView.setText(planet.getName());

        return view;
    }

    public interface OnItemClickListner{
        public void OnClick(Planet planet);
    }

    private static class ViewHolder{
        public TextView textView;
    }
}
