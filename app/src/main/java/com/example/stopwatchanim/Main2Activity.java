package com.example.stopwatchanim;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    Chronometer timer;
    Button btnStart, btnFinish;
    ImageView ivArrow;
    Animation rotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnStart = findViewById(R.id.btnStart);
        btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setAlpha(0);
        ivArrow = findViewById(R.id.ivArrow);
        rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);
        timer = findViewById(R.id.timer);



        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ivArrow.startAnimation(rotation);
                btnStart.animate().alpha(0).translationY(-80).setDuration(300).start();
                btnFinish.animate().alpha(1).setDuration(300).start();
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });


        btnFinish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                ivArrow.clearAnimation();
                btnStart.animate().alpha(1).translationY(8).setDuration(300).start();
                timer.stop();
            }
        });


        btnFinish.setTypeface(MMedium);
        btnStart.setTypeface(MMedium);

    }
}
