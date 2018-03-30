package com.k4acreators.cinemaroo.Utilitys;

import android.content.Context;

import com.k4acreators.cinemaroo.Models.Food;
import com.k4acreators.cinemaroo.Models.Movie;
import com.k4acreators.cinemaroo.Models.Seat;
import com.k4acreators.cinemaroo.Models.Theatre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2/1/2018.
 */

public class DbInitializer {

    public void movieInit() {
        List<Movie> movieList= new ArrayList<>();

        Movie m1 = new Movie();
        m1.setId(1);
        m1.setMovName("A Level");
        m1.setMovStartDate("2018-01-01");
        m1.setMovEndDate("2018-03-01");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=UK27_yg9Ry8");

        Movie m2 = new Movie();
        m2.setId(2);
        m2.setMovName("Dr. Navariyan");
        m2.setMovStartDate("2017-12-01");
        m2.setMovEndDate("2018-03-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=mKph2rmPP5s");

        Movie m3 = new Movie();
        m3.setId(3);
        m3.setMovName("Padmaawat");
        m3.setMovStartDate("2017-12-01");
        m3.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=mMbEtL62bww");

        Movie m4 = new Movie();
        m4.setId(4);
        m4.setMovName("5 Samath");
        m4.setMovStartDate("2017-12-01");
        m4.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=fcS90hhvT_8");

        Movie m5 = new Movie();
        m5.setId(5);
        m5.setMovName("Coco");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=zNCz4mQzfEI");

        Movie m6 = new Movie();
        m5.setId(6);
        m5.setMovName("Downsizing");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=UCrBICYM0yM");

        Movie m7 = new Movie();
        m5.setId(7);
        m5.setMovName("Ferdinand");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=jyJgGsZo2wA");

        Movie m8 = new Movie();
        m5.setId(8);
        m5.setMovName("Jumanji");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=2QKg5SZ_35I");

        Movie m9 = new Movie();
        m5.setId(9);
        m5.setMovName("Mannar Vagaiyara");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=14AhK7y40gU");

        Movie m10 = new Movie();
        m5.setId(10);
        m5.setMovName("Maze Runner Deth Cure");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m1.setMovDiscrption("");
        m1.setLink("https://www.youtube.com/watch?v=4-BTxXm8KSg");

        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);
        movieList.add(m5);
        movieList.add(m6);
        movieList.add(m7);
        movieList.add(m8);
        movieList.add(m9);
        movieList.add(m10);

    }

    public void theaterInit(Context context) {

        List<Theatre> theaterList= new ArrayList<>();
        DbHelper db = new DbHelper(context);
        Theatre t1 = new Theatre();
        t1.setId(1);
        t1.setThName("Savoy");
        t1.setThLat("");
        t1.setThLong("");
        t1.setThDiscrption("12 Galle Rd, Colombo");

        Theatre t2 = new Theatre();
        t2.setId(2);
        t2.setThName("Tarzon");
        t2.setThLat("");
        t2.setThLong("");
        t2.setThDiscrption("Kegalle");

        Theatre t3 = new Theatre();
        t3.setId(3);
        t3.setThName("Jothi");
        t3.setThLat("");
        t3.setThLong("");
        t3.setThDiscrption("Bandaranaike Mawatha, Ratnapura");

        Theatre t4 = new Theatre();
        t4.setId(4);
        t4.setThName("Regal");
        t4.setThLat("");
        t4.setThLong("");
        t4.setThDiscrption("Peradeniya Rd, Kandy");

        Theatre t5 = new Theatre();
        t5.setId(5);
        t5.setThName("Queens");
        t5.setThLat("");
        t5.setThLong("");
        t5.setThDiscrption("Wakwella Road, Galle");

        theaterList.add(t1);
        theaterList.add(t2);
        theaterList.add(t3);
        theaterList.add(t4);
        theaterList.add(t5);
        for (Theatre thea: theaterList) {
            db.AddTheat(thea);
        }


    }

    public void foodInit(){
        List<Food> foodsList= new ArrayList<>();

        Food f1 = new Food();
        f1.setId(1);
        f1.setFName("Pop Corn");
        f1.setPrice(35.00);
        f1.setThDiscrption("");

        Food f2 = new Food();
        f1.setId(1);
        f1.setFName("Snacks");
        f1.setPrice(40.00);
        f1.setThDiscrption("");

        Food f3 = new Food();
        f1.setId(1);
        f1.setFName("Ice Cream");
        f1.setPrice(30.00);
        f1.setThDiscrption("");

        Food f4 = new Food();
        f1.setId(1);
        f1.setFName("Coca Cola");
        f1.setPrice(45.00);
        f1.setThDiscrption("");

        Food f5 = new Food();
        f1.setId(1);
        f1.setFName("Milo");
        f1.setPrice(50.00);
        f1.setThDiscrption("");

        foodsList.add(f1);
        foodsList.add(f2);
        foodsList.add(f3);
        foodsList.add(f4);
        foodsList.add(f5);

    }

    public void seatInit(){
        List<Seat> seatList= new ArrayList<>();

        Seat s1 = new Seat();
        s1.setId(1);
        s1.setTheaterId(25);
        s1.setSeatNumber("1");
        s1.setSeatStatus("");
    }

}
