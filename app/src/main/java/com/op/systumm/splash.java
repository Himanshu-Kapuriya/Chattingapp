package com.op.systumm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    ImageView logo;
    TextView name, own1, own2;
    Animation topAnim, bottomAnim;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MediaPlayer[] music = new MediaPlayer[1];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        logo = findViewById(R.id.logoimg);
        name = findViewById(R.id.logonameimg);
        own1 = findViewById(R.id.ownone);
        own2 = findViewById(R.id.owntwo);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        logo.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        own1.setAnimation(bottomAnim);
        own2.setAnimation(bottomAnim);

        Thread timer=new Thread()
        {
            @Override            public void run() {
                try                {
                    music[0] =MediaPlayer.create(splash.this,R.raw.op);
                    music[0].start();
                    sleep(5000);

                }
                catch(InterruptedException e)
                {

                }
                finally {
                    Intent i=new Intent(splash.this,MainActivity.class);
                    startActivity(i);
                }
            }
        };

        timer.start();







      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(splash.this,MainActivity.class);
              startActivity(intent);
              finish();
          }
      },4000);
    }
}