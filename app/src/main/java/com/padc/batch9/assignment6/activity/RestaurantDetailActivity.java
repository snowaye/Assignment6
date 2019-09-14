package com.padc.batch9.assignment6.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.adapter.MyViewPagerAdapter;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.delegate.RestaurantVoDelegate;
import com.padc.batch9.assignment6.fragment.DetailsFragment;
import com.padc.batch9.assignment6.fragment.MenuFragment;
import com.padc.batch9.assignment6.fragment.ReviewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailActivity extends BaseActivity implements RestaurantVoDelegate {
    private String tag = getClass().getSimpleName();

    public static final String EXTRA_RESTAURANT_ID = "id";
    RestaurantVo restaurantVo;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.imgv_restaurant)
    AppCompatImageView imgvRestaurant;

    MyViewPagerAdapter adapter;

    public static Intent newIntent(Context context, int id) {
        Intent intent = new Intent(context, RestaurantDetailActivity.class);
        intent.putExtra(EXTRA_RESTAURANT_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        ButterKnife.bind(this);
        int id = getIntent().getIntExtra(EXTRA_RESTAURANT_ID, -1);
        Log.i(tag, "id="+id);

        restaurantVo = restaurantModel.getRestaurantVoById(id);
        Log.i(tag, "restaurantVo="+restaurantVo.getAddress());

        Glide.with(this).load(restaurantVo.getImageUrl())
                .error(R.drawable.img_restarurant)
                .placeholder(R.drawable.img_restarurant)
                .into(imgvRestaurant);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        selectFirstTab();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DetailsFragment(), getResources().getString(R.string.label_tab_detail));
        adapter.addFragment(new MenuFragment(), getResources().getString(R.string.label_tab_menu));
        adapter.addFragment(new ReviewFragment(), getResources().getString(R.string.label_tab_review));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
    }

    private void selectFirstTab() {
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
    }


    @Override
    public RestaurantVo getRetaurantVoFromHost() {
        return restaurantVo;
    }
}
