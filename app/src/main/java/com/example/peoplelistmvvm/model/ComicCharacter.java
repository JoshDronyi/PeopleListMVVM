package com.example.peoplelistmvvm.model;

public class ComicCharacter {
    private String name;
    private String city;
    private String image;
    private String alterEgo;

    public ComicCharacter(String firstName, String lastName, String image, String alterEgo) {
        this.name = firstName;
        this.city = lastName;
        this.image = image;
        this.alterEgo = alterEgo;
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String firstName) {
        this.name = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }
}
