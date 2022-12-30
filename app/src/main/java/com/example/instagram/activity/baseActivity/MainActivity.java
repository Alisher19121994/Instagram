package com.example.instagram.activity.baseActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.instagram.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 *   This MainActivity contains view pager with 5 fragments and pages can be
 *   controlled by BottomNavigationView
 ***/
public class MainActivity extends BaseActivity {

    final String TAG = MainActivity.class.getSimpleName();
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        viewPager = findViewById(R.id.viewPager_main_id);
        bottomNavigationView = findViewById(R.id.bottomNavigationView_main_id);

        openFragments();
    }

    public void openFragments(){

    }
}