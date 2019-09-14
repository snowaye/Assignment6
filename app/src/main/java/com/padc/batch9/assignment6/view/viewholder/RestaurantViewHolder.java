package com.padc.batch9.assignment6.view.viewholder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.design.chip.Chip;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatTextView;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.delegate.RestaurantItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantViewHolder extends BaseViewHolder<RestaurantVo>{
    RestaurantItemDelegate delegate;
    @BindView(R.id.imgv_bg_restaurant)
    AppCompatImageView imgvBgRestaurant;
    @BindView(R.id.tv_name)
    AppCompatTextView tvName;
    @BindView(R.id.tv_description)
    AppCompatTextView tvDescription;
    @BindView(R.id.tv_rating)
    AppCompatTextView tvRating;
    @BindView(R.id.chip_address)
    Chip chipAddress;
    @BindView(R.id.rating)
    AppCompatRatingBar ratingBar;


    public RestaurantViewHolder(@NonNull View itemView, final RestaurantItemDelegate delegate) {
        super(itemView);
        this.delegate = delegate;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.onTapItemEvent(mData.getId());
            }
        });
    }


    @Override
    public void bindData(RestaurantVo data) {
        mData = data;
        tvName.setText(mData.getName());
        tvDescription.setText(mData.getDescription());
        tvRating.setText(mData.getRating());
        chipAddress.setText(mData.getAddress());
        //if (Patterns.WEB_URL.matcher(mData.getImageUrl()).matches()) {
            Glide.with(itemView).load(mData.getImageUrl())
                    .error(R.drawable.img_restarurant)
                    .placeholder(R.drawable.img_restarurant)
                    .into(imgvBgRestaurant);
//        }
//        else {
//            //decode base64 string to image
//            byte[] imageBytes = Base64.decode(mData.getImageUrl(), Base64.DEFAULT);
//            Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
//            Glide.with(itemView).load(decodedImage).placeholder(R.drawable.img_restarurant)
//                    .error(R.drawable.img_restarurant).into(imgvBgRestaurant);
//        }
    }
}
