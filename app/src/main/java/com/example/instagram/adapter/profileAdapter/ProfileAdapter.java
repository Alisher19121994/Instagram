package com.example.instagram.adapter.profileAdapter;

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
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class ProfileAdapter extends BaseAdapterA {

    FragmentActivity profilefragment;
    ArrayList<Posts> listOfPosts;

    public ProfileAdapter(FragmentActivity profilefragment, ArrayList<Posts> listOfPosts) {
        this.profilefragment = profilefragment;
        this.listOfPosts = listOfPosts;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_view, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Posts posts = listOfPosts.get(position);

        if (holder instanceof PostsViewHolder) {

           // ((PostsViewHolder) holder).caption.setText(posts.getCaption());
            ShapeableImageView post = ((PostsViewHolder) holder).post;
            Glide.with(profilefragment).load(posts.getImage()).into(post);
        }

    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView post;
        TextView caption;
        public PostsViewHolder(View view) {
            super(view);
            post = view.findViewById(R.id.profile_post_image_id);
            caption = view.findViewById(R.id.profile_post_caption_id);
        }

    }

}
