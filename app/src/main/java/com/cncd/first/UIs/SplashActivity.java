package com.cncd.first.UIs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.cncd.first.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        firstFadeIn();


    }

    private void firstFadeIn() {

        Handler handler = new Handler();
        ImageView topImageView = findViewById(R.id.topImageView);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                topImageView.setVisibility(View.VISIBLE);
                topImageView.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in_org));

                secondFadeIn();
            }
        }, 1000);


    }

    private void secondFadeIn() {

        Handler handler = new Handler();
        ImageView secondImageView = findViewById(R.id.secondImageView);


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                secondImageView.setVisibility(View.VISIBLE);
                secondImageView.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in_org));
                LottieAnimationView animation_view = findViewById(R.id.animation_view);
                animation_view.setVisibility(View.VISIBLE);

                //thirdFadeIn();

                startLogin();

            }
        }, 1000);


    }

    private void startLogin() {

        Handler handler = new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();

            }
        }, 2000);

    }


}
