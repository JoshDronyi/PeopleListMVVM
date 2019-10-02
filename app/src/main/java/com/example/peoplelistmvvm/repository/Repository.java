package com.example.peoplelistmvvm.repository;

import android.util.Log;

import com.example.peoplelistmvvm.Utils.Constants;
import com.example.peoplelistmvvm.model.CharacterInterface;
import com.example.peoplelistmvvm.retrofit.RetrofitInstance;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class Repository implements CharacterInterface {

    private Repository(){

    }

    private static class RepositoryHolder{
        static final Repository INSTANCE = new Repository();
    }

    public  static Repository getInstance(){
        return RepositoryHolder.INSTANCE;
    }


    @Override
    public Call<JsonObject> getCharacterById(int characterID) {
        Log.e("Repository is fine", "getCharacterById: in Repository :" + characterID );
        Log.e("Next is Interface", "method call to interface is :" + Constants.CHARACTER_PATH +"  where id is " + characterID );

        return RetrofitInstance.getInstance()
                .create(CharacterInterface.class)
                .getCharacterById(characterID);
    }

    @Override
    public Call<JsonObject> getImage(int characterID) {
        return RetrofitInstance.getInstance()
                .create(CharacterInterface.class)
                .getImage(characterID);
    }
}
