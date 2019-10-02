package com.example.peoplelistmvvm.model;

import com.example.peoplelistmvvm.Utils.Constants;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterInterface {

    @GET(Constants.CHARACTER_PATH + "/{id}")
    Call<JsonObject> getCharacterById(@Path("id") int characterID);

    @GET(Constants.CHARACTER_PATH + "/{id}/image")
    Call<JsonObject> getImage(@Path("id") int characterID);

}
