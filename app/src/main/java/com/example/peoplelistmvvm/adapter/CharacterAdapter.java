package com.example.peoplelistmvvm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.peoplelistmvvm.R;
import com.example.peoplelistmvvm.model.ComicCharacter;

import java.util.List;

import butterknife.BindView;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    Context context;
    List<ComicCharacter> characters;

    public CharacterAdapter(List<ComicCharacter> characters,Context context) {
        this.characters = characters;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View theView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_item,parent,false);

        return new CharacterViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {

        ComicCharacter character = characters.get(position);

        //Set the text info

        String nameText = context.getString(R.string.name )+ " " + character.getName();
        String fullNameText = context.getString(R.string.fullName )+ " " + character.getFullName();
        String cityText = context.getString(R.string.city )+ " " + character.getCity();

        //Set basic information
        holder.name.setText(nameText);
        holder.fullName.setText(fullNameText);
        holder.city.setText(cityText);

        //Set the image
        Glide.with(context)
                .load(character.getImage())
                .centerInside()
                .into(holder.characterPic);

        //set the powerstats

        int intelligence;
        int strength;
        int speed;
        int durability;
        int power;
        int combat;

        if(character.getIntelligence().contains("null")){
            intelligence = 0;
        }else{
            intelligence = Integer.valueOf(character.getIntelligence());
        }
        if(character.getStrength().contains("null")){
            strength = 0;
        }else{
            strength = Integer.valueOf(character.getStrength());
        }
        if(character.getSpeed().contains("null")){
            speed = 0;
        }else{
            speed = Integer.valueOf(character.getSpeed());
        }
        if(character.getDurability().contains("null")){
            durability = 0;
        }else{
            durability = Integer.valueOf(character.getDurability());
        }
        if(character.getPower().contains("null")){
            power = 0;
        }else{
            power = Integer.valueOf(character.getPower());
        }
        if(character.getCombat().contains("null")){
            combat = 0;
        }else{
            combat = Integer.valueOf(character.getCombat());
        }

        holder.intelligence.setProgress(intelligence);


        holder.strength.setProgress(strength);


        holder.speed.setProgress(speed);
        holder.durability.setProgress(durability);
        holder.power.setProgress(power);
        holder.combat.setProgress(combat);


        Log.e("HERO CHECK","" + character.toString());


    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_character_image)
        ImageView characterPic;
        @BindView(R.id.tv_name)
        TextView name;
        @BindView(R.id.tv_full_name)
        TextView fullName;
        @BindView(R.id.tv_city)
        TextView city;

        ContentLoadingProgressBar intelligence;
        ContentLoadingProgressBar strength;
        ContentLoadingProgressBar speed;
        ContentLoadingProgressBar durability;
        ContentLoadingProgressBar power;
        ContentLoadingProgressBar combat;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);

            //Basic character info
            characterPic = itemView.findViewById(R.id.iv_character_image);
            name = itemView.findViewById(R.id.tv_name);
            city = itemView.findViewById(R.id.tv_city);
            fullName = itemView.findViewById(R.id.tv_full_name);

            //Character powerstats
            intelligence = itemView.findViewById(R.id.pb_intelligence);
            strength = itemView.findViewById(R.id.pb_strength);
            speed = itemView.findViewById(R.id.pb_speed);
            durability = itemView.findViewById(R.id.pb_durability);
            power = itemView.findViewById(R.id.pb_power);
            combat = itemView.findViewById(R.id.pb_combat);


        }
    }
}
