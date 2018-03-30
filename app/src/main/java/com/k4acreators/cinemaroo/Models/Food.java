package com.k4acreators.cinemaroo.Models;

/**
 * Created by PC on 1/28/2018.
 */

public class Food {

    public Food() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThDiscrption() {
        return ThDiscrption;
    }

    public void setThDiscrption(String thDiscrption) {
        ThDiscrption = thDiscrption;
    }

    private int Id;
    private String FName;
    private double price;
    private String ThDiscrption;
}
