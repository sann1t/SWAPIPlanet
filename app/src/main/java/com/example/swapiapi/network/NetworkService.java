package com.example.swapiapi.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService<T> {

    private static NetworkService mInstance;
    private static final String BASE_URL = "https://swapi.dev/api/ ";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public SwapiApi getSwapApi() {
        return mRetrofit.create(SwapiApi.class);
    }
}
