package com.example.think_it;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.think_it.Databse.AppDatabaseInstance;
import com.example.think_it.adapter.MyRecyclerViewAdapter;
import com.example.think_it.helper.DateHelper;

import java.util.ArrayList;
import java.util.List;

public class rooms extends AppCompatActivity {
    TextView date,welcome ;
    RecyclerView recycler ;
    LinearLayoutManager layoutManager;
    MyRecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        date =(TextView) findViewById(R.id.date);
        welcome =(TextView) findViewById(R.id.welcome);
        this.getUser();
        date.setText(DateHelper.getDate());

        recycler = (RecyclerView) findViewById(R.id.recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycler.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerViewAdapter(getApplicationContext(),this.getDataSet());
        recycler.setAdapter(mAdapter);

    }
    public void getUser(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                String username;
                username = AppDatabaseInstance.getInstance(getApplicationContext()).getAppDatabase()
                        .userDao()
                        .getAll()
                        .get(0)
                        .getFullname();
                welcome.setText(getResources().getString(R.string.welcome)+", "+username+"!");
            }
        });
    }

    public List<String> getDataSet(){
        List<String> myListData = new ArrayList();
        myListData.add("bathroom");
        myListData.add("bedroom");
        myListData.add("kitchen");
        myListData.add("bathroom");
        myListData.add("bedroom");
        myListData.add("kitchen");

        return myListData;
    }
}
