package com.example.instagram.adapter.searchAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instagram.R;
import com.example.instagram.adapter.BaseAdapterA;
import com.example.instagram.model.homeandfavorite.Posts;
import com.example.instagram.model.search.User;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapterA {

    FragmentActivity searchFragment;
    ArrayList<User> listOfPosts;

    public SearchAdapter(FragmentActivity searchFragment, ArrayList<User> listOfPosts) {
        this.searchFragment = searchFragment;
        this.listOfPosts = listOfPosts;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_view, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = listOfPosts.get(position);

        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).fullname.setText(user.getFullname());
            ((UserViewHolder) holder).emailAddress.setText(user.getEmailAddress());
        }

    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView profile;
        TextView fullname;
        TextView emailAddress;
        TextView follow;

        public UserViewHolder(View view) {
            super(view);
            profile = view.findViewById(R.id.search_profile_image_id);
            fullname = view.findViewById(R.id.search_fullname_id);
            emailAddress = view.findViewById(R.id.search_email_id);
            follow = view.findViewById(R.id.search_follow_id);
        }

    }
}
