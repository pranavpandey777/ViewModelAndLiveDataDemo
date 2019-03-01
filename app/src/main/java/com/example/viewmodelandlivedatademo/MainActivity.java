package com.example.viewmodelandlivedatademo;

import android.arch.lifecycle.Observer;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    MyViewModal viewModal;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);


        viewModal = ViewModelProviders.of(this).get(MyViewModal.class);


        viewModal.getUser().observe(this, new Observer<List<Items>>() {
            @Override
            public void onChanged(@Nullable List<Items> itemList) {
                Toast.makeText(MainActivity.this, "running", Toast.LENGTH_SHORT).show();
                MyAdapter adapter = new MyAdapter(MainActivity.this, itemList);
                rv.setAdapter(adapter);
            }
        });


    }


}
