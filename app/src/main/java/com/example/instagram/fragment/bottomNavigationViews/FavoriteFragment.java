package com.example.instagram.fragment.bottomNavigationViews;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.adapter.favoriteAdapter.FavoriteAdapter;
import com.example.instagram.model.homeandfavorite.Posts;

import java.util.ArrayList;

/**
 * In FavoriteFragment,user can check his/her liked posts
 */
public class FavoriteFragment extends BaseFragment {

    FavoriteFragment favoriteFragment;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerView_favorite_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        refreshAdapter(loadData());

    }

    public void refreshAdapter(ArrayList<Posts> posts) {
        FavoriteAdapter adapter = new FavoriteAdapter(getActivity(), posts);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<Posts> loadData() {
        ArrayList<Posts> list = new ArrayList<>();
        list.add(new Posts("https://manchestersightseeingtours.com/wp-content/uploads/Manchester-United-Football-Ground-NCNManchester-Marketing-1-525x350.jpg"));
        list.add(new Posts("https://www.si.com/.image/c_limit%2Ccs_srgb%2Cq_auto:good%2Cw_700/MTkxMTk2ODg3MjA5MzU0NDc1/imago1011329909h.webp"));
        list.add(new Posts("https://i2-prod.manchestereveningnews.co.uk/incoming/article23387908.ece/ALTERNATES/s810/0_GettyImages-1384570282.jpg"));
        list.add(new Posts("https://i2-prod.football.london/incoming/article23788990.ece/ALTERNATES/s458/0_Marcus-Rashford.jpg"));
        list.add(new Posts("https://i2-prod.manchestereveningnews.co.uk/sport/football/football-news/article23692634.ece/ALTERNATES/s615b/0_GettyImages-1313311867.jpg"));
        return list;
    }
}