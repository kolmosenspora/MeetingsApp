package net.digicabin.nasuomikokousluettelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class City extends AppCompatActivity {
    public static String city = "Helsinki";
    Button pohjoinen;
    Button etela;
    Button lansi;
    Button ita;
    Button keski;
    Button back;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        back = (Button) findViewById(R.id.back);
        pohjoinen = (Button) findViewById(R.id.pohjoinen);
        etela = (Button) findViewById(R.id.etela);
        lansi = (Button) findViewById(R.id.lansi);
        ita = (Button) findViewById(R.id.ita);
        keski = (Button) findViewById(R.id.keski);

        Listedgroups.items.clear();

        final Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Valitse kaupunki", "Helsinki", "Tampere", "Joensuu", "Turku", "Oulu", "Kerava", "Pori", "Jyväskylä", "Rovaniemi", "Karhunpää", "Iisalmi", "Lappeenranta", "Mikkeli", "Tohmajärvi", "Kotka", "Pieksämäki", "Kontiolahti", "Savonlinna", "Varkaus", "Lieksa", "Parikkala", "Paihola", "Hämeenlinna", "Karkkila", "Lahti", "Porvoo", "Espoo", "Hyvinkää", "Järvenpää", "Nummela", "Lohja", "Vantaa", "Tervalampi", "Forssa", "Lammi", "Riihimäki", "Nukari", "Hanko", "Kaarina", "Vaasa", "Karjaa", "Seinäjoki", "Lapua", "Malax", "Mariehamn", "Eura", "Köyliö", "Raisio", "Salo", "Rauma", "Kankaanpää", "Keitelepohja", "Ylöjärvi"  };
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Button something = findViewById(R.id.somethingelse);

        something.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dropdown.getSelectedItem() == "Valitse") {

                    Toast.makeText(City.this,
                            "Valitse jokin kaupunki!", Toast.LENGTH_LONG).show();
                }



                else {
                    String city = dropdown.getSelectedItem().toString();
                    OpenList();
                }
            }
        });

        pohjoinen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = "JyväskyläRovaniemiKarhunpääOulu";
                OpenList();
            }
        });

        ita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = "IisalmiLappeenrantaMikkeliTohmajärviJoensuuKotkaPieksämäkiKontiolahtiSavonlinnaKuopioLieksaVarkausParikkalaPaihola";
                OpenList();
            }
        });

        lansi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = "KaarinaPoriVaasaTurkuKarjaaSeinäjokiLapuaMalaxMariehamnEuraKöyliöRaisioSaloRauma";
                OpenList();
            }
        });

        etela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = "HelsinkiHyvinkääHämeenlinnaKarkkilaLahtiPorvooEspooJärvenpääNummelaLahtiLohjaTammisaariVantaaTervalampiForssaKeravaLammiRiihimäkiHankoNukari";
                OpenList();
            }
        });

        keski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                city = "TampereForssaKankaanpääKeittelepohjaVaasaJyväskyläYlöjärvi";
                OpenList();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Openstart();
            }
        });
    }

    public void OpenList() {
        Intent intent = new Intent(this, Listedgroups.class);
        startActivity(intent);
    }
    public void Openstart() {
        Intent intent = new Intent(this, Kokousluettelo.class);
        startActivity(intent);
    }





}
