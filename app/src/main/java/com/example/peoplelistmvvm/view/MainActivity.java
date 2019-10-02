package com.example.peoplelistmvvm.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peoplelistmvvm.R;
import com.example.peoplelistmvvm.Utils.Constants;
import com.example.peoplelistmvvm.adapter.CharacterAdapter;
import com.example.peoplelistmvvm.model.ComicCharacter;
import com.example.peoplelistmvvm.viewModel.CharacterViewModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_people_list)
    RecyclerView rvPeople;
    CharacterViewModel model;
    List<Integer> characterIds;
    List<ComicCharacter> characters;
    Random random;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiation of variables
        ButterKnife.bind(this);
        model = new CharacterViewModel();
        characterIds = new ArrayList<Integer>();
        characters = new ArrayList<ComicCharacter>();
        random = new Random();
        manager = new LinearLayoutManager(this);

        for (int i = 0; i < Constants.BATCH_SIZE; i++) {

            int randomId = random.nextInt(731);
            Log.e("RANDOM NUMBER", "Random number is " + randomId);

            while(randomId <=0 || randomId >= 731){
                randomId = random.nextInt(731);
                Log.e("RANDOM NUMBER", "Random number is " + randomId);
            }
            characterIds.add(randomId);

            //Event Listeners
            model
                    .getCharacterById(randomId)
                    .enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                            //TODO: Take this json data and put it into a comic character object.
                            // Take those objects and put them in a list of comic characters to give to the adapter.
                            Log.e("Success-Response:","" + response.body() + "  for call:  " + call.request().body());


                            if(response.body() == null){
                                return;
                            }


                            JsonObject serverData = response.body();
                            int characterID = serverData.get("id").getAsInt();

                            //Getting basic information
                            String name = serverData.get("name").getAsString();
                            String imageUrl = serverData.get("image").getAsJsonObject().get("url").getAsString();
                            String city = serverData.get("work").getAsJsonObject().get("base").getAsString();
                            String fullname =  serverData.get("biography").getAsJsonObject().get("full-name").getAsString();

                            //Getting powerstats
                            String intelligenceString = serverData
                                    .get("powerstats").getAsJsonObject()
                                    .get("intelligence").getAsString();

                            String strength = serverData.get("powerstats").getAsJsonObject()
                                    .get("strength").getAsString();
                            String speed = serverData.get("powerstats").getAsJsonObject()
                                    .get("speed").getAsString();
                            String durability = serverData.get("powerstats").getAsJsonObject()
                                    .get("durability").getAsString();
                            String power = serverData.get("powerstats").getAsJsonObject()
                                    .get("power").getAsString();
                            String combat = serverData.get("powerstats").getAsJsonObject()
                                    .get("combat").getAsString();




                            //Building a character object with all the basic info
                            //and powerstats

                            //Basic info
                            ComicCharacter newCharacter = new ComicCharacter(characterID);
                            newCharacter.setName(name);
                            newCharacter.setCity(city);
                            newCharacter.setFullName(fullname);
                            newCharacter.setImage(imageUrl);


                            //adding power stats

                            newCharacter.setIntelligence(intelligenceString);
                            newCharacter.setStrength(strength);
                            newCharacter.setSpeed(speed);
                            newCharacter.setDurability(durability);
                            newCharacter.setPower(power);
                            newCharacter.setCombat(combat);


                            characters.add(newCharacter);

                            setUpAdapter();
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Failed to retrieve character IDs!", Toast.LENGTH_SHORT).show();

                            Log.e("Network Failure", "Couldnt retrieve Character IDs " + characterIds.get(characterIds.size() -1) );
                            t.printStackTrace();
                        }
                    });





        }

        rvPeople.setLayoutManager(manager);

    }

    private void setUpAdapter() {
        CharacterAdapter adapter = new CharacterAdapter(characters,MainActivity.this);
        rvPeople.setAdapter(adapter);
    }
}
