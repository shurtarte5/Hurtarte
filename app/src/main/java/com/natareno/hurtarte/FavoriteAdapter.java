package com.natareno.hurtarte;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.UserViewHolder> {

    private ArrayList<User> mFavList;

    private MyOpenHelper db;


    //Interface para el click del boton de eliminar






    //------------------------------------------------


    public FavoriteAdapter(ArrayList<User> favList) {

        mFavList = favList;


    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView iduser, name, lastname, mail;



        public UserViewHolder(@NonNull View itemView) {
            super(itemView);


            iduser = itemView.findViewById(R.id.txtfav_card_id);
            name = itemView.findViewById(R.id.txtfav_card_name);
            lastname = itemView.findViewById(R.id.txtfav_card_lastname);
            mail = itemView.findViewById(R.id.txtfav_card_mail);






        }
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fav_item_cardview, viewGroup, false);
        UserViewHolder uvh = new UserViewHolder(v);


        return uvh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {


        User currentUser = mFavList.get(position);

        holder.iduser.setText(Integer.toString(currentUser.getId()));
        holder.name.setText(currentUser.getName());
        holder.lastname.setText(currentUser.getLastName());
        holder.mail.setText(currentUser.getMail());


    }

    @Override
    public int getItemCount() {
        return mFavList.size();
    }


}
