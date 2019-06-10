package net.digicabin.nasuomikokousluettelo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Listedgroups extends AppCompatActivity {
    ListView listView;
    public static ArrayList items = new ArrayList();
    public static ArrayList meetings = new ArrayList();
    public static String nameofmeeting;
    private ArrayAdapter adapter;
    Button takaisin;
    Timer timer;
    TimerTask timerTask;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listedgroups);
        final ListView listview = (ListView) findViewById(R.id.listview);
        takaisin = (Button) findViewById(R.id.takaisin);
        items.clear();
        meetings.clear();
        super.onResume();
        startTimer();


        adapter = new ArrayAdapter<String>(Listedgroups.this, android.R.layout.simple_list_item_1, items);

        listview.setAdapter(adapter);
        gettingJSon json = new gettingJSon();
       json.gettingArray();
       json.gettingArrayn();



        Listedgroups.this.adapter.notifyDataSetChanged();


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 nameofmeeting = (String) meetings.get(position);
                oneMeeting(nameofmeeting);
            }
        });

        takaisin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meetings.clear();
        OpenCity();
            }
        });
    }

    public void oneMeeting(String nameofmeeting) {


        Intent intent = new Intent(this, Onemeeting.class);

        intent.putExtra("nameofmeeting", nameofmeeting);

        startActivity(intent);


    }
    public void OpenCity() {
        Intent intent = new Intent(this, City.class);
        startActivity(intent);
    }
    public void OpenDay() {
        Intent intent = new Intent(this, Kokousluettelo.class);
        startActivity(intent);
    }


    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 1000, 1000); //
    }
    public void stoptimertask(View v) {
        //stop the timer, if it's not already null
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



                        Listedgroups.this.adapter.notifyDataSetChanged();







                    }
                });
            }
        };
    }
}
