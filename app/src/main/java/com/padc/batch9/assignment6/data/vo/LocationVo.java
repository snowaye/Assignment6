package com.padc.batch9.assignment6.data.vo;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class LocationVo {

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    String latitude;

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
