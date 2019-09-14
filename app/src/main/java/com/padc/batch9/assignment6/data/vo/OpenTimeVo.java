package com.padc.batch9.assignment6.data.vo;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class OpenTimeVo {

    @ColumnInfo(name = "opening_time")
    @SerializedName("opening_time")
    private String openingTime;

    @ColumnInfo(name = "closing_time")
    @SerializedName("closing_time")
    private String closingTime;

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}

