package com.natareno.hurtarte;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {
    private TextView listPr;
    private User user;
    private MyOpenHelper db;
    private ArrayList<User> favList;
    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private FavoriteAdapter mAdapter;


    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorites, container, false);


        db = new MyOpenHelper(getContext());


        favList = new ArrayList<User>();


        favList = db.getFavUsers();
        //userList = db.getFavUsers();

        mRecyclerView = rootView.findViewById(R.id.recycler_allusers2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new FavoriteAdapter(favList);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);






        return rootView;
    }
}
