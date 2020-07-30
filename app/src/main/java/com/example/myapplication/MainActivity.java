package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView tancha = (MaterialCardView) findViewById(R.id.card);
        tancha.hasOnClickListeners();
        tancha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, tanchaMain.class);
                startActivity(i);
            }
        });
        MaterialCardView omomo = (MaterialCardView) findViewById(R.id.card2);
        omomo.hasOnClickListeners();
        omomo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent (MainActivity.this, omomoMain.class);
                startActivity(i);
            }
        });
        MaterialCardView theAlley = (MaterialCardView) findViewById(R.id.card3);
        theAlley.hasOnClickListeners();
        theAlley.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent (MainActivity.this, theAlleyMain.class);
                startActivity(i);
            }
        });


    }
}
