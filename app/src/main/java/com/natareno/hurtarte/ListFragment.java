package com.natareno.hurtarte;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private TextView listPr;
    private User user;
    private MyOpenHelper db;
    private ArrayList<User> userList;
    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private UserAdapter mAdapter;


    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        //listPr = rootView.findViewById(R.id.txt_pruebaLista);


        db = new MyOpenHelper(getContext());


        userList = new ArrayList<User>();


        userList = db.getUsers();
        //userList = db.getFavUsers();

        mRecyclerView = rootView.findViewById(R.id.recycler_allusers);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new UserAdapter(userList);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        //userList.close();


        mAdapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


                Toast.makeText(getContext(), "CLick en la posiicion del arraylist " + position, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onDeleteClick(int idUser, int position) {

                db.deleteUser(idUser);
                userList.remove(position);
                mAdapter.notifyItemRemoved(position);


            }

            @Override
            public void onUpdateSwich(int idUser, int fav) {


                //Toast.makeText(getContext(),"es " + para,Toast.LENGTH_LONG).show();


                db.modifyUser(idUser,fav);




            }
        });


        return rootView;
    }
}
