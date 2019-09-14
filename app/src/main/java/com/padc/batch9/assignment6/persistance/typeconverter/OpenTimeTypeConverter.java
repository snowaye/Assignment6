package com.padc.batch9.assignment6.persistance.typeconverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padc.batch9.assignment6.data.vo.OpenTimeVo;

public class OpenTimeTypeConverter {

    @TypeConverter
    public static String openTimeToJson(OpenTimeVo openTimeVo) {
        return new Gson().toJson(openTimeVo);
    }

    @TypeConverter
    public static OpenTimeVo jsonToOpenTimeVo(String json) {
        return new Gson().fromJson(json, OpenTimeVo.class);
    }
}
