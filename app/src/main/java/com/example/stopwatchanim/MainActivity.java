package com.example.stopwatchanim;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView ivSplash;
    TextView tvSplash, tvSubSplash;
    Button btnStartApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnStartApp = findViewById(R.id.btnStartApp);
        ivSplash = findViewById(R.id.ivSplash);

        Animation atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        ivSplash.startAnimation(atg);
        Animation tvatg = AnimationUtils.loadAnimation(this, R.anim.tvatg);
        tvSplash.startAnimation(tvatg);
        tvSubSplash.startAnimation(tvatg);
        Animation btnatg = AnimationUtils.loadAnimation(this, R.anim.btnatg);
        btnStartApp.startAnimation(btnatg);

        btnStartApp.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v)
            {
                Intent a = new Intent(MainActivity.this, Main2Activity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });



        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnStartApp.setTypeface(MMedium);



    }
}
