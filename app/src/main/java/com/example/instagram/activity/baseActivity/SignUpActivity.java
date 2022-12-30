package com.example.instagram.activity.baseActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.instagram.R;

/**
 * In this SignUpActivity that, user can sign up  by using email,fullname,password
 * as well as this activity extended from BaseActivity for some initial implementations
 **/
public class SignUpActivity extends BaseActivity {

    final String TAG = SignUpActivity.class.getSimpleName();
    EditText fullname, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();
    }

    public void initViews() {
        fullname = findViewById(R.id.sign_up_fullname_id);
        email = findViewById(R.id.sign_up_email_id);
        password = findViewById(R.id.sign_up_password_id);
        confirmPassword = findViewById(R.id.sign_up_confirm_password_id);

        AppCompatButton button = findViewById(R.id.sign_up_button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView buttonSignIn = findViewById(R.id.sign_up_button_sign_in_id);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}