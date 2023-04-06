package com.nescorp.getaway;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class callactivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callactivity);
        Intent intent = getIntent();
        String caller = intent.getStringExtra("client");
        TextView display = findViewById(R.id.caller);
        System.out.println(caller);
        display.setText(caller);
        String num = intent.getStringExtra("sid");
        TextView no = findViewById(R.id.no);
        no.setText(num+" | india");


        Uri defaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(), RingtoneManager.TYPE_RINGTONE);
        Ringtone defaultRingtone = RingtoneManager.getRingtone(getApplicationContext(), defaultRingtoneUri);
        defaultRingtone.play();
        ImageButton receive = findViewById(R.id.recieve);
        Animation recAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.receive);
        receive.startAnimation(recAnim);

        ImageButton reject = findViewById(R.id.reject);
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultRingtone.stop();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        ImageButton recieve = findViewById(R.id.recieve);
        recieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                defaultRingtone.stop();
                System.out.println("redirecting call reference");
                Intent pass_on = new Intent(getApplicationContext(),onCall.class);
                pass_on.putExtra("client",caller);
                pass_on.putExtra("number",num);
                startActivity(pass_on);

            }
        });

        ImageView arr =  findViewById(R.id.arr);
        Animation arranim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.arranim);
        arr.startAnimation(arranim);
    }
}