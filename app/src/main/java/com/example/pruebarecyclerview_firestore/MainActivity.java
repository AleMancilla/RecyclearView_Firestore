package com.example.pruebarecyclerview_firestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mMainlist;
    private FirebaseFirestore mFirestore;

    private UserListAdapter userListAdapter;

    private List<Users> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList = new ArrayList<>();
        userListAdapter = new UserListAdapter(usersList);

        mMainlist = findViewById(R.id.main_list);
        mMainlist.setHasFixedSize(true);
        mMainlist.setLayoutManager(new LinearLayoutManager(this));
        mMainlist.setAdapter(userListAdapter);

        mFirestore = FirebaseFirestore.getInstance();


        mFirestore.collection("Rutas").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(e != null)
                {
                    //error
                }
                for (DocumentChange doc: queryDocumentSnapshots.getDocumentChanges())
                {
                    if (doc.getType()== DocumentChange.Type.ADDED)
                    {
                        //String name = doc.getDocument().getString("nicknameuser");
                        //Log.d("PRUEBA______", "onEvent: "+name);
                        Users users = doc.getDocument().toObject(Users.class);
                        usersList.add(users);
                        //Log.d("PRUEBA______", "onEvent: "+users.getNicknameuser());
                        userListAdapter.notifyDataSetChanged();
                    }


                }
            }
        });
    }
}
