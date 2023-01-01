package com.example.instagram.adapter.favoriteAdapter;

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

public class FavoriteAdapter extends BaseAdapterA {

    FragmentActivity favoriteFragment;
    ArrayList<Posts> listOfPosts;

    public FavoriteAdapter(FragmentActivity favoriteFragment, ArrayList<Posts> listOfPosts) {
        this.favoriteFragment = favoriteFragment;
        this.listOfPosts = listOfPosts;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_view, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Posts posts = listOfPosts.get(position);

        if (holder instanceof PostsViewHolder) {

            ShapeableImageView post = ((PostsViewHolder) holder).post;
            Glide.with(favoriteFragment).load(posts.getImage()).into(post);
        }

    }

    @Override
    public int getItemCount() {
        return listOfPosts.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView profile;
        ShapeableImageView post;
        TextView fullname;
        TextView time;
        TextView caption;
        ImageView more;
        ImageView liked;
        ImageView share;

        public PostsViewHolder(View view) {
            super(view);
            post = view.findViewById(R.id.favorite_view_full_image_id);
        }

    }
}
