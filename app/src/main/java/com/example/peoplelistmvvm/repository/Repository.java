package com.example.peoplelistmvvm.repository;

import com.example.peoplelistmvvm.model.CharacterInterface;
import com.example.peoplelistmvvm.retrofit.RetrofitInstance;

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
    public Call<List<String>> getCharacterById(int characterID) {
        return RetrofitInstance.getInstance()
                .create(CharacterInterface.class)
                .getCharacterById(characterID);
    }

    @Override
    public Call<List<String>> getImage(int characterID) {
        return RetrofitInstance.getInstance()
                .create(CharacterInterface.class)
                .getImage(characterID);
    }
}
