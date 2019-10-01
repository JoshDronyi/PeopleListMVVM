package com.example.peoplelistmvvm.retrofit;

import com.example.peoplelistmvvm.Utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private RetrofitInstance(){

    }


    private static class RetrofitInstanceHolder{
        static final Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getInstance(){
        return RetrofitInstanceHolder.INSTANCE; //Access to singleton.
    }

}
