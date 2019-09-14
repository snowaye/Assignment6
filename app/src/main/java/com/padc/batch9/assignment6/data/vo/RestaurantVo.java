package com.padc.batch9.assignment6.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "restaurant",  indices = {@Index(value = "id", unique = true)})
public class RestaurantVo {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pk")
    private int idPk;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "imageUrl")
    @SerializedName("imageUrl")
    private String imageUrl;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String address;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    private String rating;

    @SerializedName("opening_closing_times")
    private OpenTimeVo openTimeVo;

    @SerializedName("restaurant_location")
    private LocationVo locationVo;

    @SerializedName("menus")
    private List<MenuVo> menuVoList = new ArrayList<>();

    public int getIdPk() {
        return idPk;
    }

    public void setIdPk(int idPk) {
        this.idPk = idPk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public OpenTimeVo getOpenTimeVo() {
        return openTimeVo;
    }

    public void setOpenTimeVo(OpenTimeVo openTimeVo) {
        this.openTimeVo = openTimeVo;
    }

    public LocationVo getLocationVo() {
        return locationVo;
    }

    public void setLocationVo(LocationVo locationVo) {
        this.locationVo = locationVo;
    }

    public List<MenuVo> getMenuVoList() {
        return menuVoList;
    }

    public void setMenuVoList(List<MenuVo> menuVoList) {
        this.menuVoList = menuVoList;
    }
}

