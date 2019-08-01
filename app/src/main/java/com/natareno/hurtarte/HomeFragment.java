package com.natareno.hurtarte;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.natareno.hurtarte.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private TextView name,lastname,mail,resultado,idborrar;
    private Button send,b,del;
    private User user;
    private MyOpenHelper db;
    private ArrayList<User> pr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home,container,false);

        name = (TextView) rootView.findViewById(R.id.txt_name);
        lastname= (TextView)rootView.findViewById(R.id.txt_lastname);
        mail = (TextView)rootView.findViewById(R.id.txt_email);
        send = rootView.findViewById(R.id.button2);





        db= new MyOpenHelper(getContext());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                registrar();






            }
        });


       /* del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrar();
            }
        });*/









        return rootView;
    }

    public void registrar(){
        String a,b,c;
        a = name.getText().toString();
        b = lastname.getText().toString();
        c = mail.getText().toString();
        int favorite = 1;
        user = new User(a,b,c,1);



        if(!user.getName().isEmpty() && !user.getName().isEmpty() && !user.getMail().isEmpty()){
            db.insert_user(getContext(), user.getName(),user.getLastName(),user.getMail(),user.getFavorite());
            name.setText("");
            lastname.setText("");
            mail.setText("");

        }else {
            Toast.makeText(getContext(), "no", Toast.LENGTH_SHORT).show();

        }

    }


    /*public void borrar(){

        int a = Integer.parseInt(idborrar.getText().toString());

        db.deleteUser(a);

    }*/
}
