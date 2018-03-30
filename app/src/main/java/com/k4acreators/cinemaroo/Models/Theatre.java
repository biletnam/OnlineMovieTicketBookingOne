package com.k4acreators.cinemaroo.Models;

/**
 * Created by PC on 1/27/2018.
 */

public class Theatre {
    public Theatre() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getThName() {
        return ThName;
    }

    public void setThName(String thName) {
        ThName = thName;
    }

    public String getThLat() {
        return ThLat;
    }

    public void setThLat(String thLat) {
        ThLat = thLat;
    }

    public String getThLong() {
        return ThLong;
    }

    public void setThLong(String thLong) {
        ThLong = thLong;
    }

    public String getThDiscrption() {
        return ThDiscrption;
    }

    public void setThDiscrption(String thDiscrption) {
        ThDiscrption = thDiscrption;
    }

    public String toString() {
        return "user [id=" + getId() + ", theaname=" + getThName() + ", thealat=" + getThLat() + ", thealong=" +getThLong()+ ", theadiscription="+getThDiscrption()
                + "]";
    }

    private int Id;
    private String ThName;
    private String ThLat;
    private String ThLong;
    private String ThDiscrption;

}
