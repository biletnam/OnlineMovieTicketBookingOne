package com.k4acreators.cinemaroo.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.k4acreators.cinemaroo.Adapters.MovieDetailListAdapter;
import com.k4acreators.cinemaroo.Adapters.MovieListAdapter;
import com.k4acreators.cinemaroo.Models.Movie;
import com.k4acreators.cinemaroo.R;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailListActivity extends AppCompatActivity {

    List<Movie> movieDetailList = new ArrayList<>();
    MovieDetailListAdapter mAdapter;
    RecyclerView movieDetailListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail_list);
        initComponent();
        setMovieList();

    }


    private void initComponent(){
        movieDetailListView = (RecyclerView) findViewById(R.id.list_movies);
        movieDetailListView.setHasFixedSize(true);
        mAdapter = new MovieDetailListAdapter(movieDetailList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        movieDetailListView.setLayoutManager(mLayoutManager);
        movieDetailListView.setItemAnimator(new DefaultItemAnimator());
        movieDetailListView.setAdapter(mAdapter);

        Log.i("List", String.valueOf((movieDetailList.size())));
    }

    private void setMovieList()
    {
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

        movieDetailList.add(m1);
        movieDetailList.add(m2);
        movieDetailList.add(m3);
        movieDetailList.add(m4);
        movieDetailList.add(m5);
        movieDetailList.add(m6);
        movieDetailList.add(m7);
        movieDetailList.add(m8);
        movieDetailList.add(m9);
        movieDetailList.add(m10);
        // mAdapter.notifyDataSetChanged();
    }


}
