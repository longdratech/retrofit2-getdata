package com.tuts.prakash.retrofittutorial.activity;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.R;
import com.tuts.prakash.retrofittutorial.adapter.CustomAdapter;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;
import com.tuts.prakash.retrofittutorial.network.ApiRequest;
import com.tuts.prakash.retrofittutorial.network.RetrofitInit;
import com.tuts.prakash.retrofittutorial.viewmodel.ViewModelMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayAdapter<RetroPhoto> mArrayAdapter;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        final ViewModelMain modelMain = new ViewModelMain();
        modelMain.onMain().observe(this, new Observer<ArrayList<RetroPhoto>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RetroPhoto> retroPhotos) {

                generateDataList(retroPhotos);
                progressDoalog.dismiss();
            }
        });

    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(ArrayList<RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
