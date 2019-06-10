package net.digicabin.nasuomikokousluettelo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Kokousluettelo extends AppCompatActivity {
    String url = "https://www.nasuomi.org/wp-json/wp/v2/kokoukset?per_page=100&page=1";
    String secondurl = "https://www.nasuomi.org/wp-json/wp/v2/kokoukset?per_page=100&page=2";
    public static String FILE_NAME = "kokoukset.txt"; // To save json as string to external file
    public static String FILE_NAMEone = "kokoukset2.txt"; // two jsons so we make two textfiles
    public static String json1 = "";
    public static String json2 = "";
    public static String day = "";
    public TextView textView;
    Timer timer;
    TimerTask timerTask;
    final Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kokousluettelo);
        Listedgroups.items.clear();


        startTimer();

        getNasuomi(url);
        getNasuomin(secondurl);
        load();
        loading();



        checking();




    }

    public void openDagen() {


        Intent intent = new Intent(this, dagen.class);


        stoptimertask();
        Kokousluettelo.this.finish();
        startActivity(intent);








    }

    public void checking() {
        if ( Ryhmikset.ryhmat1.length() > 10 && Ryhmikset.ryhmat2.length() > 10) {
            openDagen();
        }

    }

    public void getNasuomi(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                save(response.body().string(), "kokoukset.txt");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

            }
        });
    }

    public void getNasuomin(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                save(response.body().string(), "kokoukset2.txt");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

            }
        });
    }

    public void save(String response, String FILE_NAME) {
        String text = response;
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load() {
        FileInputStream fis = null;

        try {
            fis = openFileInput("kokoukset.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            final StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            Ryhmikset.ryhmat1 = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void loading() {
        FileInputStream fis = null;

        try {
            fis = openFileInput("kokoukset2.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            final StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            Ryhmikset.ryhmat2 = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void openCity(String day) {


        Intent intent = new Intent(this, City.class);
        intent.putExtra("day", day);



        startActivity(intent);





    }

    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 2000, 2000); //
    }
    public void stoptimertask() {

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {
                        //get the current timeStamp



                            Kokousluettelo.this.checking();



                        Toast.makeText(Kokousluettelo.this, "Odota hetki, kokoustiedot ladataan puhelimeesi! Osoitteesta Www.nasuomi.org ", Toast.LENGTH_SHORT).show();





                    }
                });
            }
        };
    }




}
