package com.example.christiannatsaliki.githubapiuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private users_adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<usersModel> list = new ArrayList<usersModel>();
        HttpGETRequest getRequest = new HttpGETRequest();
        String url = "https://api.github.com/users" ;

        try {
             list = getRequest.execute(url).get();

            // mAdapter.notifyDataSetChanged();
        }
        catch(ExecutionException |InterruptedException e){
            e.printStackTrace();
        }
       
        mAdapter = new users_adapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }
}
