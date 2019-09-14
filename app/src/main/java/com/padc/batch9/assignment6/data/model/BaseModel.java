package com.padc.batch9.assignment6.data.model;

import android.content.Context;

import com.padc.batch9.assignment6.network.dataagent.RestaurantDataAgent;
import com.padc.batch9.assignment6.network.dataagent.RetrofitRestaurantDataAgentImpl;
import com.padc.batch9.assignment6.persistance.RestaurantDatabase;

public class BaseModel {
    protected RestaurantDataAgent mDataAgent;
    protected RestaurantDatabase mDatabase;

    public BaseModel(Context context) {
        mDataAgent = RetrofitRestaurantDataAgentImpl.getObjInstance();
        mDatabase = RestaurantDatabase.getDatabase(context);
    }
}
