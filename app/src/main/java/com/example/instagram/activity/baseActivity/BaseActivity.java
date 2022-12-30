package com.example.instagram.activity.baseActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
/**
 *
 * BaseActivity is a parent for all Activities
 * **/
public class BaseActivity extends AppCompatActivity {


    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    public void openSignInActivity(Context context) {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    public void openSignUpActivity(Context context) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void openMainActivity(Context context) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
