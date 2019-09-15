package com.padc.batch9.assignment6.data.model;

import android.content.Context;

import com.padc.batch9.assignment6.data.vo.RestaurantVo;
import com.padc.batch9.assignment6.network.dataagent.RestaurantDataAgent;
import com.padc.batch9.assignment6.util.RestaurantConstant;

import java.util.List;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel {

    private static RestaurantModelImpl objInstance;


    public RestaurantModelImpl(Context context) {
        super(context);
    }

    public static RestaurantModelImpl getObjInstance() {
        if (objInstance==null)
            throw new RuntimeException(RestaurantConstant.EM_RESTAURANT_MODEL_SHOULD_BE_INITIALIZED);
        return objInstance;
    }

    public static void initilizeResturantModel(Context context) {
        objInstance = new RestaurantModelImpl(context);
    }

    @Override
    public void getResturants(final GetRestaurantsFromDataLayerDelegate delegate) {
        mDataAgent.getRestaurants(new RestaurantDataAgent.GetDataFromNetworkDelegate() {
            @Override
            public void onSuccess(List<RestaurantVo> list) {
                if (mDatabase.isRestaurantDataExisting()) {
                    List<RestaurantVo> restaurantVos = mDatabase.restaurantDao().getAllRestaurants();
                    delegate.onSuccess(restaurantVos);
                }
                else {
                    mDataAgent.getRestaurants(new RestaurantDataAgent.GetDataFromNetworkDelegate() {
                        @Override
                        public void onSuccess(List<RestaurantVo> list) {
                            mDatabase.restaurantDao().insertRestaurants(list);
                            delegate.onSuccess(list);
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            delegate.onFailure(errorMessage);
                        }
                    });
                }
            }

            @Override
            public void onFailure(String errorMessage) {
                delegate.onFailure(errorMessage);
            }
        });

    }

    @Override
    public RestaurantVo getRestaurantVoById(int id) {
        RestaurantVo restaurantVo=null;
        restaurantVo = mDatabase.restaurantDao().getRestaurantById(id);
        return restaurantVo;
    }

    @Override
    public List<RestaurantVo> getAllRestaurants() {
        List<RestaurantVo> restaurantVos = mDatabase.restaurantDao().getAllRestaurants();
        return restaurantVos;
    }
}
