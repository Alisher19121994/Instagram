package com.example.instagram.fragment.bottomNavigationViews;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.adapter.profileAdapter.ProfileAdapter;
import com.example.instagram.model.homeandfavorite.Posts;
import com.google.android.material.imageview.ShapeableImageView;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;

import java.util.ArrayList;

/**
 * In ProfileFragment,user can check his/her posts and counts or change profile photo
 */
public class ProfileFragment extends BaseFragment {

    RecyclerView recyclerView;
    ArrayList<Uri> allPhoto = new ArrayList<>();
    Uri pickedPhoto = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_profile_main_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        getProfileData(view);
        refreshAdapter(loadPost());
    }

    public void refreshAdapter(ArrayList<Posts> posts) {
        ProfileAdapter adapter = new ProfileAdapter(getActivity(), posts);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Posts> loadPost() {
        ArrayList<Posts> list = new ArrayList();
        list.add(new Posts("https://manchestersightseeingtours.com/wp-content/uploads/Manchester-United-Football-Ground-NCNManchester-Marketing-1-525x350.jpg"));
        list.add(new Posts("https://www.si.com/.image/c_limit%2Ccs_srgb%2Cq_auto:good%2Cw_700/MTkxMTk2ODg3MjA5MzU0NDc1/imago1011329909h.webp"));
        list.add(new Posts("https://i2-prod.manchestereveningnews.co.uk/incoming/article23387908.ece/ALTERNATES/s810/0_GettyImages-1384570282.jpg"));
        list.add(new Posts("https://i2-prod.football.london/incoming/article23788990.ece/ALTERNATES/s458/0_Marcus-Rashford.jpg"));
        list.add(new Posts("https://i2-prod.manchestereveningnews.co.uk/sport/football/football-news/article23692634.ece/ALTERNATES/s615b/0_GettyImages-1313311867.jpg"));

        return list;
    }

    public void getProfileData(View view) {
        ShapeableImageView profileImage = view.findViewById(R.id.profile_image_id);
        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickPhotoFromGallery();
            }
        });
    }

    public void pickPhotoFromGallery() {
        FishBun.with(getActivity())
                .setImageAdapter(new GlideAdapter())
                .setMaxCount(1)
                .setMinCount(1)
                .setSelectedImages(allPhoto)
                .startAlbumWithActivityResultCallback(photoLauncher);

    }

    ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        allPhoto = result.getData().getParcelableArrayListExtra(FishBun.INTENT_PATH);
                        pickedPhoto = allPhoto.get(0);
                        // uploadPhoto();
                    }
                }
            });


}