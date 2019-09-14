package com.padc.batch9.assignment6.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.delegate.RestaurantItemDelegate;
import com.padc.batch9.assignment6.view.viewholder.RestaurantViewHolder;

public class RestaurantAdapter extends BaseRecyclerViewAdapter<RestaurantViewHolder, RestaurantVo>  {

    RestaurantItemDelegate delegate;

    public RestaurantAdapter(RestaurantItemDelegate delegate) {
        this.delegate = delegate;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_restaurant,
                viewGroup, false);
        return new RestaurantViewHolder(view, delegate);
    }
}
