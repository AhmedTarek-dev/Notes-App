package com.example.notes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int splashscreen=3000;
    Animation topanim, bottomaim;
    ImageView image;
    TextView textsplash;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomaim = AnimationUtils.loadAnimation(this, R.anim.bottomanimation);

        image = findViewById(R.id.notelogo);
        textsplash = findViewById(R.id.textsplash);

        image.setAnimation(topanim);
        // image.setAnimation(bottomaim);
        textsplash.setAnimation(bottomaim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, RegisterScreen.class);
                startActivity(intent);

                finish();
            }


        },splashscreen);

    }


}