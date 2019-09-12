package com.padc.batch9.assignment6.activity;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.fragment.CameraFragment;
import com.padc.batch9.assignment6.fragment.CategoryFragment;
import com.padc.batch9.assignment6.fragment.NotificationFragment;
import com.padc.batch9.assignment6.fragment.ProfileFragment;
import com.padc.batch9.assignment6.fragment.RestaurantFragment;
import com.padc.batch9.assignment6.util.DialogUtil;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.nav_restaurant:
                    fragment = new RestaurantFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_category:
                    fragment = new CategoryFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_camera:
                    fragment = new CameraFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_notification:
                    fragment = new NotificationFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_profile:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.nav_view);
        DialogUtil.setStatusBarColor(this, R.color.colorPrimary);
        loadFirstFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void loadFragment(Fragment fragment) {
        // load com.mytel.msg.fragment
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void loadFirstFragment() {
        RestaurantFragment fragment = new RestaurantFragment();
        loadFragment(fragment);
    }
}
