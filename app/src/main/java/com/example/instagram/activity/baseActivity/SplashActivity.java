package com.example.instagram.activity.baseActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;

import com.example.instagram.R;


/**
 * In this SplashActivity, user can visit to SignInActivity or MainActivity
 * within a few secund
 **/
public class SplashActivity extends BaseActivity {
    final String TAG = SplashActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        initViews();
    }

    public void initViews() {
        countDownTimer();
    }

    public void countDownTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                openSignInActivity(context);
            }
        }.start();
    }
}