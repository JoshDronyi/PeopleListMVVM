package com.example.peoplelistmvvm.viewModel;

import com.example.peoplelistmvvm.repository.Repository;

import java.util.List;

import retrofit2.Call;

public class CharacterViewModel {


    public CharacterViewModel(){

    }

    public Call<List<String>> getCharacterById(int characterID){

        return Repository.getInstance()
                .getCharacterById(characterID);
    }

    public Call<List<String>> getCharacterImage(int characterID){
        return Repository.getInstance()
                .getImage(characterID);
    }



}
