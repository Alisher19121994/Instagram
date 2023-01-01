package com.example.instagram.fragment.bottomNavigationViews;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.instagram.R;
import com.example.instagram.adapter.homeAdapter.HomeAdapter;
import com.example.instagram.model.homeandfavorite.Posts;
import com.example.instagram.utils.HomeListener;

import java.util.ArrayList;

/**
 * In this HomeFragment,user can check his/her posts and friends posts
 */
public class HomeFragment extends BaseFragment {

    HomeListener listener = null;
    ImageView imageView;
    RecyclerView recyclerView;
    Context context;
    HomeFragment homeFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_home_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        setCamera(view);
        refreshAdapter(loadPost());

    }

    public void refreshAdapter(ArrayList<Posts> posts) {
        HomeAdapter adapter = new HomeAdapter(getActivity(), posts);
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

    public void setCamera(View view) {
        imageView = view.findViewById(R.id.home_camera_id);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.scrollToUpload();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof HomeListener) {
            listener = (HomeListener) context;
        } else {
            throw new RuntimeException(context + "must implement upload!");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}