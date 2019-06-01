package com.example.pruebarecyclerview_firestore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    public List<Users> usersList;
    public UserListAdapter (List<Users> usersList)
    {
        this.usersList=usersList;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public TextView tv_title;
        public TextView tv_nicknameuser;

        public ViewHolder (View itemView)
        {
            super(itemView);
            mView = itemView;
            tv_title = mView.findViewById(R.id.tv_title);
            tv_nicknameuser = mView.findViewById(R.id.tv_nicknameuser);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.tv_title.setText(usersList.get(i).getTitle());
        viewHolder.tv_nicknameuser.setText(usersList.get(i).getNicknameuser());

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
