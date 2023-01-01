package com.example.instagram.activity.baseActivity;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.instagram.R;
import com.example.instagram.fragment.bottomNavigationViews.FavoriteFragment;
import com.example.instagram.fragment.bottomNavigationViews.HomeFragment;
import com.example.instagram.fragment.bottomNavigationViews.ProfileFragment;
import com.example.instagram.fragment.bottomNavigationViews.SearchFragment;
import com.example.instagram.fragment.bottomNavigationViews.UpLoadFragment;
import com.example.instagram.fragment.adapter.fragment.ViewPagerAdapter;
import com.example.instagram.utils.HomeListener;
import com.example.instagram.utils.UploadListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * This MainActivity contains view pager with 5 fragments and pages can be
 * controlled by BottomNavigationView
 ***/
public class MainActivity extends BaseActivity implements HomeListener, UploadListener {

    final String TAG = MainActivity.class.getSimpleName();
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment;
    UpLoadFragment upLoadFragment;

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    public void scrollToHome() {
        index = 0;
        scrollBYIndex(index);
    }

    @Override
    public void scrollToUpload() {
        index = 2;
        scrollBYIndex(index);
    }

    public void scrollBYIndex(int index) {
        viewPager.setCurrentItem(index);
        bottomNavigationView.getMenu().getItem(index).setChecked(true);
    }

    public void initViews() {
        viewPager = findViewById(R.id.viewPager_main_id);
        bottomNavigationView = findViewById(R.id.bottomNavigationView_main_id);

        openFragments();


        /***
         * Home and upload Fragments are global for communication purpose!
         * */
        homeFragment = new HomeFragment();
        upLoadFragment = new UpLoadFragment();


        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home_id:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.search_id:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.upload_id:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.favorite_id:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.profile_id:
                    viewPager.setCurrentItem(4);
                    break;
            }

            return true;
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                index = position;
                bottomNavigationView.getMenu().getItem(index).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void openFragments() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new SearchFragment());
        viewPagerAdapter.addFragment(new UpLoadFragment());
        viewPagerAdapter.addFragment(new FavoriteFragment());
        viewPagerAdapter.addFragment(new ProfileFragment());
        viewPager.setAdapter(viewPagerAdapter);
    }
}