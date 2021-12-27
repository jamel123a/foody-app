package com.example.foody;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity2 extends AppCompatActivity {

    Animation topAmin,botomAnim;
    ImageView image;
    TextView logo,slogan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity2);
        // animation
        topAmin= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botomAnim= AnimationUtils.loadAnimation(this,R.anim.button_animation);
       // hooks
        image=findViewById(R.id.imgSlash);
        logo=findViewById(R.id.logoSlash);
        slogan=findViewById(R.id.TextSlash);

        image.setAnimation(topAmin);
        logo.setAnimation(botomAnim);
        slogan.setAnimation(botomAnim);
         // no action bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.
                    FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            /////// add hilder start   /////////////
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent  =new Intent(SplashActivity2.this,WelcomeActivity2.class);
                    startActivity(intent);
                    finish();
                }
            }, 5000);
            ////// end hilder start////////////
        }

    }
}


