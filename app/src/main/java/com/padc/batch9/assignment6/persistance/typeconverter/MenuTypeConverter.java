package com.padc.batch9.assignment6.persistance.typeconverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padc.batch9.assignment6.data.vo.MenuVo;

import java.util.List;

public class MenuTypeConverter {

    @TypeConverter
    public static String menuToJson(List<MenuVo> menuVos) {
        return new Gson().toJson(menuVos);
    }

    @TypeConverter
    public static List<MenuVo> jsonToMenu(String jsonString) {
        return new Gson().fromJson(jsonString, new TypeToken<List<MenuVo>>(){}.getType());
    }
}
