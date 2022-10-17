package com.example.animacja2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageDrzewiec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageDrzewiec = findViewById(R.id.drzewiec);

        startAnime();
    }

    private void startAnime() {
        Animation out =  new ScaleAnimation(1f,2f,1f,2f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        out.setFillAfter(true);
        out.setDuration(4000);
        Animation in = new AlphaAnimation(1, 0);
        in.setDuration(4000);

        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Stare mistyczne drzewo", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageDrzewiec.startAnimation(in);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });
        in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageDrzewiec.startAnimation(out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageDrzewiec.startAnimation(out);
    }
}