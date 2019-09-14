package com.padc.batch9.assignment6.network.response;

import com.google.gson.annotations.SerializedName;
import com.padc.batch9.assignment6.data.vo.RestaurantVo;

import java.util.List;

public class GetRestaurantResponse {
    @SerializedName("message")
    private String messge;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<RestaurantVo> eventVoList;

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<RestaurantVo> getEventVoList() {
        return eventVoList;
    }

    public void setEventVoList(List<RestaurantVo> eventVoList) {
        this.eventVoList = eventVoList;
    }
}
