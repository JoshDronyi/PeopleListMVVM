package com.example.peoplelistmvvm.model;

public class ComicCharacter {
    private String firstName;
    private String lastName;
    private String image;
    private String AlterEgo;

    public ComicCharacter(String firstName, String lastName, String image, String alterEgo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        AlterEgo = alterEgo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlterEgo() {
        return AlterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        AlterEgo = alterEgo;
    }
}
