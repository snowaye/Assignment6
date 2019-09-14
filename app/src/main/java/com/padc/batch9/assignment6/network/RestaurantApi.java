package com.padc.batch9.assignment6.network;

import com.padc.batch9.assignment6.network.response.GetRestaurantResponse;
import com.padc.batch9.assignment6.util.RestaurantConstant;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantApi {

    @GET(RestaurantConstant.GET_RESTAURANT)
    Call<GetRestaurantResponse> getRestaurants();
}
