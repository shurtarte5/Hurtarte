package com.natareno.hurtarte;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<User> mUserList;

    private MyOpenHelper db;


    //Interface para el click del boton de eliminar

    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int idUser, int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {

        mListener = listener;


    }

    //------------------------------------------------


    public UserAdapter(ArrayList<User> userList) {

        mUserList = userList;


    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView iduser, name, lastname, mail;
        public ImageView deleteButton;
        public Switch favorite;


        public UserViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);


            iduser = itemView.findViewById(R.id.txt_card_id);
            name = itemView.findViewById(R.id.txt_card_name);
            lastname = itemView.findViewById(R.id.txt_card_lastname);
            mail = itemView.findViewById(R.id.txt_card_mail);
            deleteButton = itemView.findViewById(R.id.imageButtonDelete);
            favorite=itemView.findViewById(R.id.favoriteButton);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {

                            listener.onItemClick(position);

                        }


                    }


                }
            });


            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {

                        int idUser = Integer.parseInt(iduser.getText().toString());
                        int position = getAdapterPosition();

                        if (idUser != RecyclerView.NO_POSITION) {

                            listener.onDeleteClick(idUser, position);

                        }


                    }


                }
            });


        }
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.example_item_cardview, viewGroup, false);
        UserViewHolder uvh = new UserViewHolder(v, mListener);


        return uvh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {


        User currentUser = mUserList.get(position);

        holder.iduser.setText(Integer.toString(currentUser.getId()));
        holder.name.setText(currentUser.getName());
        holder.lastname.setText(currentUser.getLastName());
        holder.mail.setText(currentUser.getMail());


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


}
