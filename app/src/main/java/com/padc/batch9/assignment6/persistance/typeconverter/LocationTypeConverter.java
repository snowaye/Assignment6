package com.padc.batch9.assignment6.persistance.typeconverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padc.batch9.assignment6.data.vo.LocationVo;

public class LocationTypeConverter {

    @TypeConverter
    public static String locationTypeToJson(LocationVo locationVo) {
        return new Gson().toJson(locationVo);
    }

    @TypeConverter
    public static LocationVo jsonToLocationVo(String json) {
        return new Gson().fromJson(json, LocationVo.class);
    }
}
