package com.padc.batch9.assignment6.persistance.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padc.batch9.assignment6.data.vo.RestaurantVo;

import java.util.List;

@Dao
public abstract class RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertRestaurants(List<RestaurantVo> restaurantVoList);

    @Query("SELECT * FROM restaurant")
    public abstract List<RestaurantVo>  getAllRestaurants();

    @Query("SELECT * FROM restaurant WHERE id=:id")
    public abstract RestaurantVo getRestaurantById(int id);


}
