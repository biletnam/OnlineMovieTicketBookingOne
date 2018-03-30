package com.k4acreators.cinemaroo.Models;

/**
 * Created by PC on 1/23/2018.
 */

public class User {
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getNic_number() {
        return nic_number;
    }

    public void setNic_number(String nic_number) {
        this.nic_number = nic_number;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
    private String phone_number;
    private String nic_number;
    private String birth_date;
    private String password;
    private String Token;
    public User(){

    }
    public User(int id ,String username, String phone_number, String nic_number, String  birth_date, String password , String token) {
        super();

        this.id = id;
        this.username = username;
        this.phone_number = phone_number;
        this.nic_number = nic_number;
        this.birth_date = birth_date;
        this.password = password;
        this.Token = token;
    }

    public String toString() {
        return "user [id=" + id + ", username=" + username + ", phone_number=" + phone_number + ", nic_number=" +nic_number+ ", birth_date="+birth_date+", password="+password+", token="+Token
                + "]";
    }

}
