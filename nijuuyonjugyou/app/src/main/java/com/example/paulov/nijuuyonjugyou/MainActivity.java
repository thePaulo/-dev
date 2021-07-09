package com.example.paulov.nijuuyonjugyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap map;
    private TextView textMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map2);

        mapFragment.getMapAsync(this);

        textMsg = findViewById(R.id.txt_msg);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);

        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        /*CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        map.moveCamera(update);

        CameraPosition position =  map.getCameraPosition();
        textMsg.setText(position.toString());*/

        CameraPosition position = map.getCameraPosition();
        textMsg.setText(position.toString());

        CameraPosition.Builder builder = new CameraPosition.Builder();
        builder.target(latLng).zoom(10).bearing(180).tilt(30);

        CameraPosition pos = builder.build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(pos);

        map.animateCamera(update);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        CameraUpdate update = CameraUpdateFactory.newLatLng(latLng);
        map.animateCamera(update);
    }
}
