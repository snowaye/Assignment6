package com.padc.batch9.assignment6.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;


import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.persistance.dao.RestaurantDao;
import com.padc.batch9.assignment6.persistance.typeconverter.LocationTypeConverter;
import com.padc.batch9.assignment6.persistance.typeconverter.MenuTypeConverter;
import com.padc.batch9.assignment6.persistance.typeconverter.OpenTimeTypeConverter;
import com.padc.batch9.assignment6.util.RestaurantConstant;

@Database(entities = {RestaurantVo.class}, version = 1, exportSchema = false)
@TypeConverters({OpenTimeTypeConverter.class,
        MenuTypeConverter.class,
        LocationTypeConverter.class})

public abstract class RestaurantDatabase extends RoomDatabase {

    public static RestaurantDatabase database;

    public static RestaurantDatabase getDatabase(Context context) {
        if (database==null) {
            database = Room.databaseBuilder(context, RestaurantDatabase.class,
                    RestaurantConstant.RESTAURANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return database;
    }

    public abstract RestaurantDao restaurantDao();

    public boolean isRestaurantDataExisting() {
        return !restaurantDao().getAllRestaurants().isEmpty();
    }
}
