package com.example.instagram.activity.baseActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.instagram.R;

/**
 * In this SignInActivity that, user can log in  by using email and password
 * as well as this activity extended from BaseActivity for some initial implementations
 **/
public class SignInActivity extends BaseActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    final String TAG = SignInActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initViews();
    }

    public void initViews() {
        editTextEmail = findViewById(R.id.sign_in_email_id);
        editTextPassword = findViewById(R.id.sign_in_password_id);

        AppCompatButton button = findViewById(R.id.sign_in_button_id);
        button.setOnClickListener(v -> openMainActivity(context));

        TextView textViewButton = findViewById(R.id.sign_in_button_sign_up_id);
        textViewButton.setOnClickListener(v -> openSignUpActivity(context));
    }
}