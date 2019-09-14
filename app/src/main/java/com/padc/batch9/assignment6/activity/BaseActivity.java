package com.padc.batch9.assignment6.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.padc.batch9.assignment6.R;
import com.padc.batch9.assignment6.data.model.RestaurantModelImpl;

public class BaseActivity extends AppCompatActivity {

    RestaurantModelImpl restaurantModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantModel = RestaurantModelImpl.getObjInstance();
    }

    protected void showIdefiniteSnakBar(String message) {
        final Snackbar snackbar =  Snackbar.make(getWindow().getDecorView(), message,
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction(getString(R.string.label_okay), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }
}
