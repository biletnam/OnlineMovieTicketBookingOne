package com.k4acreators.cinemaroo.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.k4acreators.cinemaroo.R;

public class SplashActivity extends BaseActivity {
    private static int SPLASH_TIME_OUT = 5000;
    public SharedPreferences loginPreferences;
    public SharedPreferences.Editor loginPrefsEditor;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        token = loginPreferences.getString("accessToken", "");

        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a Handler. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                if(token .length() != 0){
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        }, SPLASH_TIME_OUT);
    }
}
