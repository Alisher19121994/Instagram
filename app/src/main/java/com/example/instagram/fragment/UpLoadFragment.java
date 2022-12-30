package com.example.instagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagram.R;

/**
 *In UpLoadFragment, user cal upload his/her posts with images and captions
 */
public class UpLoadFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_up_load, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {

    }
}