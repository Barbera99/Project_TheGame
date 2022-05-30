package com.example.project_thegame.views;

import androidx.activity.result.ActivityResultLauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.project_thegame.R;

public class SplashScreenActivity extends Activity {
    private static final String TAG = "SplashScreenActivity";
    public static final int FIRST_REQUEST = 1;
    public static int SPLASH_TIME_OUT = 2000;
    public final int REQUEST_CODE_B = 1;
    public final int REQUEST_CODE_C = 2;
    ActivityResultLauncher<String> result;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
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
                    finish();
                    goTo(TermConditionActivity.class);
                }
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            prefs.edit().putBoolean("FirstTimeInstall", true);
            finish();
            goTo(TermConditionActivity.class);
        } else {
            System.exit(0);
        }
    }

    public void goTo(Class _class) {
        Log.d(TAG, "IntGoto; ");
        Intent intent = new Intent(this, _class);
        startActivity(intent);
    }
}
