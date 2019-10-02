package com.example.peoplelistmvvm.viewModel;

import android.util.Log;

import com.example.peoplelistmvvm.repository.Repository;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;

public class CharacterViewModel {


    public CharacterViewModel(){

    }

    public Call<JsonObject> getCharacterById(int characterID){

        Log.e("IN THE VIEWMODEL", "getCharacterById: characterID is " + characterID );
        return Repository.getInstance()
                .getCharacterById(characterID);
    }

    public Call<JsonObject> getCharacterImage(int characterID){
        return Repository.getInstance()
                .getImage(characterID);
    }



}
