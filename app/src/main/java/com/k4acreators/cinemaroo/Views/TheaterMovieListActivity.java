package com.k4acreators.cinemaroo.Views;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.k4acreators.cinemaroo.Adapters.MovieListAdapter;
import com.k4acreators.cinemaroo.Models.Movie;
import com.k4acreators.cinemaroo.R;
import com.k4acreators.cinemaroo.Utilitys.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class TheaterMovieListActivity extends BaseActivity  {

    List<Movie> movieList = new ArrayList<>();
    MovieListAdapter mAdapter;
    RecyclerView movieListView;
    String thi = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_movie_list);
        Bundle extras = getIntent().getExtras();
        thi = extras.getString("THENAME");
        initComponent();
        setMovieList();

    }


    private void initComponent(){
        movieListView = (RecyclerView) findViewById(R.id.list_movies);
        movieListView.setHasFixedSize(true);
        mAdapter = new MovieListAdapter(movieList, this,thi);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        movieListView.setLayoutManager(mLayoutManager);
        movieListView.setItemAnimator(new DefaultItemAnimator());
        movieListView.setAdapter(mAdapter);

        Log.i("List", String.valueOf((movieList.size())));
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
        m2.setMovDiscrption("");
        m2.setLink("https://www.youtube.com/watch?v=mKph2rmPP5s");

        Movie m3 = new Movie();
        m3.setId(3);
        m3.setMovName("Padmaawat");
        m3.setMovStartDate("2017-12-01");
        m3.setMovEndDate("2018-02-31");
        m3.setMovDiscrption("");
        m3.setLink("https://www.youtube.com/watch?v=mMbEtL62bww");

        Movie m4 = new Movie();
        m4.setId(4);
        m4.setMovName("5 Samath");
        m4.setMovStartDate("2017-12-01");
        m4.setMovEndDate("2018-02-31");
        m4.setMovDiscrption("");
        m4.setLink("https://www.youtube.com/watch?v=fcS90hhvT_8");

        Movie m5 = new Movie();
        m5.setId(5);
        m5.setMovName("Coco");
        m5.setMovStartDate("2017-12-01");
        m5.setMovEndDate("2018-02-31");
        m5.setMovDiscrption("");
        m5.setLink("https://www.youtube.com/watch?v=zNCz4mQzfEI");

        Movie m6 = new Movie();
        m6.setId(6);
        m6.setMovName("Downsizing");
        m6.setMovStartDate("2017-12-01");
        m6.setMovEndDate("2018-02-31");
        m6.setMovDiscrption("");
        m6.setLink("https://www.youtube.com/watch?v=UCrBICYM0yM");


        Movie m7 = new Movie();
        m7.setId(7);
        m7.setMovName("Ferdinand");
        m7.setMovStartDate("2017-12-01");
        m7.setMovEndDate("2018-02-31");
        m7.setMovDiscrption("");
        m7.setLink("https://www.youtube.com/watch?v=jyJgGsZo2wA");

        Movie m8 = new Movie();
        m8.setId(8);
        m8.setMovName("Jumanji");
        m8.setMovStartDate("2017-12-01");
        m8.setMovEndDate("2018-02-31");
        m8.setMovDiscrption("");
        m8.setLink("https://www.youtube.com/watch?v=2QKg5SZ_35I");

        Movie m9 = new Movie();
        m9.setId(9);
        m9.setMovName("Mannar Vagaiyara");
        m9.setMovStartDate("2017-12-01");
        m9.setMovEndDate("2018-02-31");
        m9.setMovDiscrption("");
        m9.setLink("https://www.youtube.com/watch?v=14AhK7y40gU");

        Movie m10 = new Movie();
        m10.setId(10);
        m10.setMovName("Maze Runner Deth Cure");
        m10.setMovStartDate("2017-12-01");
        m10.setMovEndDate("2018-02-31");
        m10.setMovDiscrption("");
        m10.setLink("https://www.youtube.com/watch?v=4-BTxXm8KSg");

      if (thi.equals("Savoy")){
          movieList.add(m1);
          movieList.add(m2);
          movieList.add(m3);
          movieList.add(m8);
          movieList.add(m9);
      }else if (thi.equals("Liberty")){
          movieList.add(m1);
          movieList.add(m4);
          movieList.add(m5);
          movieList.add(m6);
          movieList.add(m7);
          movieList.add(m10);
      }
       // mAdapter.notifyDataSetChanged();
    }


}
