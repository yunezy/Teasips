package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class tanchaMain extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap map;
    private Button order;
//    boolean like1st = false;
//    public ImageButton like1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tancha_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        order = (Button) findViewById(R.id.button);
        order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

//        like1 = (ImageButton) findViewById(R.id.imageButton1);
//        like1.setOnClickListener(likeAction);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng tancha = new LatLng(33.6593030,-117.8035771);
        map.addMarker(new MarkerOptions().position(tancha).title("Tan-cha"));
        map.moveCamera(CameraUpdateFactory.newLatLng((tancha)));
        map.setMinZoomPreference(17.0f);
        map.setMaxZoomPreference(30.0f);
    }

    public void openDialog(){
        tanchaOrderDialog tanchaDialog = new tanchaOrderDialog();
        tanchaDialog.show(getSupportFragmentManager(), "tancha Dialog");

    }
//     View.OnClickListener likeAction= new View.OnClickListener(){
//        public void onClick(View v){
//            if(like1st){
//                like1.setImageResource(R.drawable.emptyheart);
//            }
//            else{
//                like1.setImageResource(R.drawable.fullheart);
//            }
//            like1st = !like1st;
//        }
//    };
}
