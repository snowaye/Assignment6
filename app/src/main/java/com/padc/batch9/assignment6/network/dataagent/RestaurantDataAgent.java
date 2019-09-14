package com.padc.batch9.assignment6.network.dataagent;

import com.padc.batch9.assignment6.data.vo.RestaurantVo;

import java.util.List;

public interface RestaurantDataAgent {

    void getRestaurants(GetDataFromNetworkDelegate delegate);

    interface GetDataFromNetworkDelegate{
        void onSuccess(List<RestaurantVo> list);
        void onFailure(String errorMessage);
    }
}
