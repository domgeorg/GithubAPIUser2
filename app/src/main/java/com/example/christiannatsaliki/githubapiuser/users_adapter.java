package com.example.christiannatsaliki.githubapiuser;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChristiannaTsaliki on 23/10/2017.
 */

public class users_adapter extends  RecyclerView.Adapter<users_adapter.MyViewHolder>
        {
            private List<usersModel> moviesList;

            public class MyViewHolder extends RecyclerView.ViewHolder {
                public TextView title, year, genre;

                public MyViewHolder(View view) {
                    super(view);
                    title = (TextView) view.findViewById(R.id.login);
                    genre = (TextView) view.findViewById(R.id.type);
                    year = (TextView) view.findViewById(R.id.url);
                }
            }


            public users_adapter(List<usersModel> moviesList) {
                this.moviesList = moviesList;
            }

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.user_list_row, parent, false);

                return new MyViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position) {
                usersModel user = moviesList.get(position);
                holder.title.setText(user.getLogin());
                holder.genre.setText(user.getType());
                holder.year.setText(user.getUrl());
            }

            @Override
            public int getItemCount() {
                return moviesList.size();
            }
}
