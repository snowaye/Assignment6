package com.padc.batch9.assignment6.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.activity.RestaurantDetailActivity;
import com.padc.batch9.assignment6.adapter.RestaurantAdapter;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.delegate.RestaurantDataDelegate;
import com.padc.batch9.assignment6.delegate.RestaurantItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantFragment extends BaseFragment implements RestaurantItemDelegate, TextWatcher {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.et_search)
    AppCompatEditText etSearch;
    @BindView(R.id.imgv_search)
    AppCompatImageView imgvSearch;

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
        ButterKnife.bind(this, view);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RestaurantAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setViewData(restaurantVos);
        etSearch.addTextChangedListener(this);
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

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length()>0) {
            filter(s.toString());
        }
        else {
            restaurantVos = new ArrayList<>();
            restaurantVos = restaurantModel.getAllRestaurants();
            adapter.setViewData(restaurantVos);
        }

    }

    private void filter(String searchKeyword) {
        List<RestaurantVo> filteredList = new ArrayList<>();

        for (RestaurantVo restaurantVo:restaurantVos) {
            if (restaurantVo.getName().toLowerCase().equals(searchKeyword.toLowerCase()))
                filteredList.add(restaurantVo);
        }
        adapter.setViewData(filteredList);
    }
}
