package com.example.project_thegame;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {
    public static int SPLASH_TIME_OUT = 2000;
    public final int REQUEST_CODE_B = 1;
    public final int REQUEST_CODE_C = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreenactivity);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                boolean agreed = prefs.getBoolean("agreed", false);
                if (!agreed) {
                    Intent termsCond = new Intent(SplashScreenActivity.this, TermConditionActivity.class);
                    termsCond.addCategory(Intent.CATEGORY_HOME);
                    termsCond.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivityForResult(termsCond,REQUEST_CODE_B);

                } else {
                    Intent mainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                    SplashScreenActivity.this.startActivity(mainActivity);
                }
            }
        },SPLASH_TIME_OUT);


        /*System.out.println("asdfasdfasdfsadf");
        Timer temps = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        temps.schedule(task, 5000);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            boolean flag = data.getBooleanExtra("datBol",false);
            if(flag){
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                System.exit(0);
            }
        }

    }
}