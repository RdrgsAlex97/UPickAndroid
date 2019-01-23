package com.example.alex.upick.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.alex.upick.R;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {


    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        ImageView imgLogo = findViewById(R.id.img_logo);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotation_animation);
        imgLogo.startAnimation(animation);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = prefs.getString("language", "pt-PT");
        updateLanguage(this,lang);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        },1000);





    }


    public static void updateLanguage(Context ctx, String lang)
    {
        Configuration cfg = new Configuration();
        if (!TextUtils.isEmpty(lang))
            cfg.locale = new Locale(lang );
        else
            cfg.locale = Locale.getDefault();

        ctx.getResources().updateConfiguration(cfg, ctx.getResources().getDisplayMetrics());
    }
}
