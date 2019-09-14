package com.padc.batch9.assignment6.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.activity.RestaurantDetailActivity;
import com.padc.batch9.assignment6.adapter.RestaurantAdapter;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.delegate.RestaurantDataDelegate;
import com.padc.batch9.assignment6.delegate.RestaurantItemDelegate;

import java.util.List;

public class RestaurantFragment extends Fragment implements RestaurantItemDelegate {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    RestaurantAdapter adapter;
    RestaurantDataDelegate delegate;
    List<RestaurantVo> restaurantVos;

    public RestaurantFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RestaurantAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setViewData(restaurantVos);
        return view;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            delegate = (RestaurantDataDelegate) activity;
            restaurantVos = delegate.getRestaurantDataFromHost();
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void onTapItemEvent(int id) {
        Intent intent = RestaurantDetailActivity.newIntent(getContext(), id);
        startActivity(intent);
    }
}
