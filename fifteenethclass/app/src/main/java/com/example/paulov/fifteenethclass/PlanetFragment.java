package com.example.paulov.fifteenethclass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlanetFragment extends Fragment {
    private Planet planet;

    public static PlanetFragment newInstance(Planet planet){
        PlanetFragment fragment = new PlanetFragment();
        fragment.planet = planet;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planet,container,false);
        ImageView imageView = view.findViewById(R.id.image);
        imageView.setImageResource(planet.getId());
        getActivity().setTitle(planet.getName());
        return view;
    }
}
