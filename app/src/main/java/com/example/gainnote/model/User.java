package com.example.gainnote.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    int id;
    String firstname;
    String name;
    String sexe;
    int height;
    String bodyType;
    ArrayList<Integer> weight;

    public User(){

    }
    public User(String firstname, String name, String sexe, int weight ,int height, String bodyType){
        setBodyType(bodyType);
        setHeight(height);
        setFirstname(firstname);
        setName(name);
        setSexe(sexe);
        ArrayList<Integer> weights = new ArrayList<>();
        weights.add(weight);
        setWeight(weights);
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public ArrayList<Integer> getWeight() {
        return weight;
    }

    public Integer getLastWeight() {
        return weight.get(0);
    }

    public void setWeight(ArrayList<Integer> weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
}
