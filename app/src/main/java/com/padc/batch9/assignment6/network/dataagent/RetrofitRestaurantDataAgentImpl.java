package com.padc.batch9.assignment6.network.dataagent;

import com.padc.batch9.assignment6.network.RestaurantApi;
import com.padc.batch9.assignment6.network.response.GetRestaurantResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.padc.batch9.assignment6.util.RestaurantConstant.BASE_URL;

public class RetrofitRestaurantDataAgentImpl implements RestaurantDataAgent {

    private static RetrofitRestaurantDataAgentImpl objInstance;
    private RestaurantApi restaurantApi;

    private RetrofitRestaurantDataAgentImpl() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        restaurantApi = retrofit.create(RestaurantApi.class);
    }

    public static RetrofitRestaurantDataAgentImpl getObjInstance() {
        if (objInstance==null)
            objInstance = new RetrofitRestaurantDataAgentImpl();
        return objInstance;
    }

    @Override
    public void getRestaurants(final GetDataFromNetworkDelegate delegate) {
        Call<GetRestaurantResponse> call = restaurantApi.getRestaurants();
        call.enqueue(new Callback<GetRestaurantResponse>() {
            @Override
            public void onResponse(Call<GetRestaurantResponse> call, Response<GetRestaurantResponse> response) {
                if (response!=null) {
                    if (response.isSuccessful()) {
                        delegate.onSuccess(response.body().getEventVoList());
                    }
                    else {
                        delegate.onFailure(response.body().getMessge());
                    }
                }
                else {
                    delegate.onFailure(response.body().getMessge());
                }
            }

            @Override
            public void onFailure(Call<GetRestaurantResponse> call, Throwable t) {
                delegate.onFailure(t.getMessage());
            }
        });
    }
}
