package com.tuts.prakash.retrofittutorial.model;

import android.arch.lifecycle.MutableLiveData;


import com.tuts.prakash.retrofittutorial.network.ApiRequest;
import com.tuts.prakash.retrofittutorial.network.RetrofitInit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private static MainRepository repository = null;
    private ApiRequest mApiRequest;

    private MainRepository(){
        mApiRequest = RetrofitInit.initApi();
    }

    public static MainRepository getInstance(){
        if (repository == null){
            repository = new MainRepository();
        }
        return repository;
    }

    public MutableLiveData<ArrayList<RetroPhoto>> mMutableLiveData(){
        final MutableLiveData<ArrayList<RetroPhoto>> retroPhotoMutableLiveData = new MutableLiveData<>();

        mApiRequest.getAllPhotos().enqueue(new Callback<ArrayList<RetroPhoto>>() {
            @Override
            public void onResponse(Call<ArrayList<RetroPhoto>> call, Response<ArrayList<RetroPhoto>> response) {
                retroPhotoMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<RetroPhoto>> call, Throwable t) {

            }
        });
        return retroPhotoMutableLiveData;
    }
}
