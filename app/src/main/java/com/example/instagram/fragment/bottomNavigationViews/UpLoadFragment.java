package com.example.instagram.fragment.bottomNavigationViews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.instagram.R;
import com.example.instagram.utils.UploadListener;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.adapter.image.impl.GlideAdapter;

import java.util.ArrayList;

/**
 * In UpLoadFragment, user cal upload his/her posts with images and captions
 */
public class UpLoadFragment extends BaseFragment {

    UploadListener listener = null;

    FrameLayout fl_photo;
    ImageView iv_photo;
    EditText et_caption;

    Uri pickedPhoto = null;
    ArrayList<Uri> allPhotos = new ArrayList();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_up_load, container, false);
        initViews(view);
        return view;
    }


    /**
     * onAttach is for communication of Fragment
     **/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof UploadListener) {
            listener = (UploadListener) context;
        } else {
            throw new RuntimeException(context + "must implement upload!");
        }
    }


    /**
     * onDetach is for communication of Fragment
     **/
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void initViews(View view) {

        fl_photo = view.findViewById(R.id.fl_photo);
        iv_photo = view.findViewById(R.id.iv_photo);
        et_caption = view.findViewById(R.id.et_caption);

        openPages(view);

    }


    public void openPages(View view) {

        ImageView close = view.findViewById(R.id.iv_close);//close
        ImageView pick = view.findViewById(R.id.iv_pick); //pick
        ImageView upLoadImageOnToolbar = view.findViewById(R.id.upload_image_on_toolbar_id); //upload top

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidePickedPhoto();
            }
        });  // close
        pick.setOnClickListener(v -> pickFishBunPhoto());
        upLoadImageOnToolbar.setOnClickListener(v -> uploadNewPost());

    }


    /**
     * Picking a photo by using FishBun Liberary
     **/
    public void pickFishBunPhoto() {
        allPhotos.clear();
        FishBun.with(this)
                .setImageAdapter(new GlideAdapter())
                .setMaxCount(1)
                .setMinCount(1)
                .setSelectedImages(allPhotos)
                .startAlbumWithActivityResultCallback(photoLauncher);
    }

    ActivityResultLauncher<Intent> photoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        allPhotos = result.getData().getParcelableArrayListExtra(FishBun.INTENT_PATH); // ?: arrayOf
                        pickedPhoto = allPhotos.get(0);
                        showPickedPhoto();
                    }
                }
            });

    public void showPickedPhoto() {
        allPhotos.clear();
        fl_photo.setVisibility(View.VISIBLE);
        iv_photo.setImageURI(pickedPhoto);
    }

    public void hidePickedPhoto() {
        pickedPhoto = null;
        fl_photo.setVisibility(View.GONE);
    }

    public void uploadNewPost() {

        if (et_caption.getText().toString().trim() != null && pickedPhoto != null) {
            listener.scrollToHome();
            et_caption.getText().clear();
        }
    }

}