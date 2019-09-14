package com.padc.batch9.assignment6;

import android.app.Application;

import com.padc.batch9.assignment6.data.model.RestaurantModelImpl;

public class RestaurantApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RestaurantModelImpl.initilizeResturantModel(getApplicationContext());
    }
}
