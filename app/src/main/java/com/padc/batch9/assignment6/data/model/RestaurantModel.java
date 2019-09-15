package com.padc.batch9.assignment6.data.model;

import com.padc.batch9.assignment6.data.vo.RestaurantVo;

import java.util.List;

public interface RestaurantModel {

    void getResturants(GetRestaurantsFromDataLayerDelegate delegate);

    interface GetRestaurantsFromDataLayerDelegate {
        void onSuccess(List<RestaurantVo> list);
        void onFailure(String errorMessage);
    }

    RestaurantVo getRestaurantVoById(int id);

    List<RestaurantVo> getAllRestaurants();
}
