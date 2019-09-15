package com.padc.batch9.assignment6.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.padc.batch9.assignment6.data.model.RestaurantModelImpl;

public class BaseFragment extends Fragment {
    RestaurantModelImpl restaurantModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantModel = RestaurantModelImpl.getObjInstance();
    }
}
