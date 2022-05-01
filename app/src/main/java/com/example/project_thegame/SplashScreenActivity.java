package com.example.project_thegame;
import androidx.activity.result.ActivityResult;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

<<<<<<< Updated upstream:app/src/main/java/com/example/project_thegame/SplashScreenActivity.java
import com.example.project_thegame.databinding.ActivityMainBinding;
=======
import com.example.project_thegame.R;
>>>>>>> Stashed changes:app/src/main/java/com/example/project_thegame/views/SplashScreenActivity.java

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends Activity {
    public static final int FIRST_REQUEST = 1;
    public static int SPLASH_TIME_OUT = 2000;
    public final int REQUEST_CODE_B = 1;
    public final int REQUEST_CODE_C = 2;
    ActivityResultLauncher<String> result;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreenactivity);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                boolean agreed = prefs.getBoolean("FirstTimeInstall", true);
                if (!agreed) {

                    Intent termsCond = new Intent(SplashScreenActivity.this, TestActivity.class);
                    startActivityForResult(termsCond, FIRST_REQUEST);
                    finish();

                } else {
                    Intent mainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                    SplashScreenActivity.this.startActivity(mainActivity);
                    finish();
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
        if(resultCode == RESULT_OK){
            prefs.edit().putBoolean("FirstTimeInstall", true);
            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            System.exit(0);
        }
    }
}
