package com.padc.batch9.assignment6.delegate;

import com.padc.batch9.assignment6.data.vo.RestaurantVo;

import java.util.List;

public interface RestaurantDataDelegate {

    List<RestaurantVo> getRestaurantDataFromHost();
}
