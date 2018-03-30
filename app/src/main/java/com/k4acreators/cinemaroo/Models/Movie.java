package com.k4acreators.cinemaroo.Models;

/**
 * Created by PC on 1/25/2018.
 */

public class Movie {

    public Movie() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMovName() {
        return MovName;
    }

    public void setMovName(String movName) {
        MovName = movName;
    }

    public String getMovStartDate() {
        return MovStartDate;
    }

    public void setMovStartDate(String movStartDate) {
        MovStartDate = movStartDate;
    }

    public String getMovEndDate() {
        return MovEndDate;
    }

    public void setMovEndDate(String movEndDate) {
        MovEndDate = movEndDate;
    }

    public String getMovDiscrption() {
        return MovDiscrption;
    }

    public void setMovDiscrption(String movDiscrption) {
        MovDiscrption = movDiscrption;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    private int Id;
    private String MovName;
    private String MovStartDate;
    private String MovEndDate;
    private String MovDiscrption;
    private String Link;
}
