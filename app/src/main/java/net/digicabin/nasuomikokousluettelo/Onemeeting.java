package net.digicabin.nasuomikokousluettelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Onemeeting extends AppCompatActivity {
        String nameofmeeting;
        TextView texti;
        Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onemeeting);
        Intent extras = getIntent();
        nameofmeeting = extras.getStringExtra("nameofmeeting");
        texti = (TextView) findViewById(R.id.texti);
        back = (Button) findViewById(R.id.back);


        if (gettingJSon.trying.containsKey(nameofmeeting)) {


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Onemeeting.this.texti.setText(gettingJSon.trying.get(nameofmeeting).toString());
                }
            });



        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                back();
            }
        });


    }
    public void back() {


        Intent intent = new Intent(this, Listedgroups.class);



        startActivity(intent);


    }


}
