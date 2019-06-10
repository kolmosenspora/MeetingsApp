package net.digicabin.nasuomikokousluettelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dagen extends AppCompatActivity {
    Button monday;
    Button tuesday;
    Button wednesday;
    Button thursday;
    Button friday;
    Button saturday;
    Button sunday;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagen);
        search = (Button) findViewById(R.id.search);
        monday = (Button) findViewById(R.id.monday);
        tuesday = (Button) findViewById(R.id.tuesday);
        wednesday = (Button) findViewById(R.id.wednesday);
        thursday = (Button) findViewById(R.id.thursday);
        friday = (Button) findViewById(R.id.friday);
        saturday = (Button) findViewById(R.id.saturday);
        sunday = (Button) findViewById(R.id.sunday);

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Maanantai";
                openCity(Kokousluettelo.day);

            }
        });
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Tiistai";
                openCity(Kokousluettelo.day);

            }
        });
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Keskiviikko";
                openCity(Kokousluettelo.day);

            }
        });
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Torstai";
                openCity(Kokousluettelo.day);

            }
        });
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Perjantai";
                openCity(Kokousluettelo.day);

            }
        });
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Lauantai";
                openCity(Kokousluettelo.day);
            }
        });
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "Sunnuntai";
                openCity(Kokousluettelo.day);

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kokousluettelo.day = "MaanantaiTiistaiKeskiviikkoTorstaiPerjantaiLauantaiSunnuntai";
                openCity(Kokousluettelo.day);
            }
        });
    }
    public void openCity(String day) {


        Intent intent = new Intent(this, City.class);
        intent.putExtra("day", day);



        startActivity(intent);





    }


}
