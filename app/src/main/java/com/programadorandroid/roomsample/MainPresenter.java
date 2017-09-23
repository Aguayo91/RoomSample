package com.programadorandroid.roomsample;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.programadorandroid.roomsample.data.AppRepository;
import com.programadorandroid.roomsample.data.entity.Place;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by Guillermo on 18/09/2017.
 */

public class MainPresenter {
    private View view;
    private Context context;
    AppRepository appRepository;

    MainPresenter(Context context,View view){
        this.context = context;
        this.view = view;
        appRepository = AppRepository.getInstance(context);
    }

    void setup(){
        loadPlaces();
    }

    void loadPlaces(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                List<Place> places = appRepository.getAppDatabase().placeDao().getAll();
                view.showPlaces(places);
            }
        }).start();
    }

    interface View {
        void showPlaces(List<Place> places);
    }

}
