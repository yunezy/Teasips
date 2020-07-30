package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class omomoMain extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap map;
    private Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omomo_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        order = (Button) findViewById(R.id.button);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng tancha = new LatLng(33.671444, -117.788805);
        map.addMarker(new MarkerOptions().position(tancha).title("Omomo Tea Shoppe"));
        map.moveCamera(CameraUpdateFactory.newLatLng((tancha)));
        map.setMinZoomPreference(17.0f);
        map.setMaxZoomPreference(30.0f);
    }

    public void openDialog() {
        tanchaOrderDialog tanchaDialog = new tanchaOrderDialog();
        tanchaDialog.show(getSupportFragmentManager(), "tancha Dialog");
    }
}
