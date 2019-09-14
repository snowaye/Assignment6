package com.padc.batch9.assignment6.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.delegate.RestaurantDataDelegate;
import com.padc.batch9.assignment6.delegate.RestaurantVoDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsFragment extends Fragment {
    private String tag = getClass().getSimpleName();

    RestaurantVoDelegate delegate;
    RestaurantVo restaurantVo;

    public DetailsFragment() {
    }

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;
    @BindView(R.id.tv_description)
    AppCompatTextView tvDescription;
    @BindView(R.id.tv_open_time)
    AppCompatTextView tvOpenTime;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        restaurantVo = delegate.getRetaurantVoFromHost();
        Log.i(tag, "restaurantVo="+restaurantVo.getAddress());
        tvName.setText(restaurantVo.getName());
        tvDescription.setText(restaurantVo.getDescription());
        String openTime = restaurantVo.getOpenTimeVo().getOpeningTime();
        String closeTime = restaurantVo.getOpenTimeVo().getClosingTime();
        String openingTime = openTime +"-"+closeTime;
        tvOpenTime.setText(openingTime);

        return view;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            delegate = (RestaurantVoDelegate) activity;
            restaurantVo = delegate.getRetaurantVoFromHost();
        }
        catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }
}
