package com.padc.batch9.assignment6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    T mData;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(T mData);
}
