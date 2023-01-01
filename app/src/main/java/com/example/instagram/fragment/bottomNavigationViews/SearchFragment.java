package com.example.instagram.fragment.bottomNavigationViews;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.adapter.searchAdapter.SearchAdapter;
import com.example.instagram.model.search.User;

import java.util.ArrayList;
import java.util.Locale;

/**
 * In SearchFragment,user can search and follow or unfollow friends
 */
public class SearchFragment extends BaseFragment {

    RecyclerView recyclerView;

    ArrayList<User> serverData = new ArrayList<>();
    ArrayList<User> searchableLocalData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {

        recyclerView = view.findViewById(R.id.recyclerview_search_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchItems(view);

    }

    public void searchItems(View view) {
        EditText editTextSearch = view.findViewById(R.id.search_main_id);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String keyWord = s.toString().trim();
                usersByKeyWord(keyWord);

            }
        });
        refreshAdapter(loadData());
    }

    public void usersByKeyWord(String keyWord) {
        if (keyWord.isEmpty())
            refreshAdapter(serverData);

            searchableLocalData.clear();

            for (User user: serverData)
                if (user.getFullname().toLowerCase(Locale.ROOT).startsWith(keyWord.toLowerCase(Locale.ROOT))
                        && user.getEmailAddress().toLowerCase(Locale.ROOT).startsWith(keyWord.toLowerCase(Locale.ROOT)))

                    searchableLocalData.add(user);

            refreshAdapter(searchableLocalData);

    }

    public void refreshAdapter(ArrayList<User> users) {
        SearchAdapter adapter = new SearchAdapter(getActivity(), users);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<User> loadData() {

        serverData = new ArrayList<>();

        serverData.add(new User("Alisher Daminov", "alisherdaminov135@gmail.com"));
        serverData.add(new User("Anvar Odilov", "plisherdaminov135@gmail.com"));
        serverData.add(new User("Sodiq Eshonqulov", "slisherdaminov135@gmail.com"));
        serverData.add(new User("Xurshidbek Qurbanov", "glisherdaminov135@gmail.com"));
        serverData.add(new User("Alisher Daminov", "hlisherdaminov135@gmail.com"));
        serverData.add(new User("Anvar Odilov", "elisherdaminov135@gmail.com"));
        serverData.add(new User("Sodiq Eshonqulov", "llisherdaminov135@gmail.com"));
        serverData.add(new User("Xurshidbek Qurbanov", "ylisherdaminov135@gmail.com"));


        return serverData;

    }
}