package com.tuts.prakash.retrofittutorial.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.tuts.prakash.retrofittutorial.model.MainRepository;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;

import java.util.ArrayList;

public class ViewModelMain extends ViewModel {
    private MainRepository mMainRepository = MainRepository.getInstance();

    public MutableLiveData<ArrayList<RetroPhoto>> onMain(){
        return mMainRepository.mMutableLiveData();
    }
}
