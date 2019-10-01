package com.example.peoplelistmvvm.model;

import com.example.peoplelistmvvm.Utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CharacterInterface {

    @GET(Constants.CHARACTER_PATH + "/{id}")
    Call<List<String>> getCharacterById(@Query("id") int characterID);

    @GET(Constants.CHARACTER_PATH + "/{id}/image")
    Call<List<String>> getImage(@Query("id") int characterID);

}
