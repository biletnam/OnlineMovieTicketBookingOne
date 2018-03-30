package com.k4acreators.cinemaroo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.k4acreators.cinemaroo.Models.Movie;
import com.k4acreators.cinemaroo.R;
import com.k4acreators.cinemaroo.Views.MainActivity;
import com.k4acreators.cinemaroo.Views.ShowTimeBookActivity;
import com.k4acreators.cinemaroo.Views.TheaterMovieListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 1/25/2018.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    List<Movie> data = new ArrayList<>();
    Context context;
    String theater;

    public MovieListAdapter(List<Movie> data, Context c, String theater)
    {
        context = c;
        this.data = data;
        this.theater = theater;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView strDate;
        public TextView endDate;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_movie_name);
            strDate = (TextView) view.findViewById(R.id.txt_start_date);
            endDate = (TextView) view.findViewById(R.id.txt_end_date);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent=new Intent(context,ShowTimeBookActivity.class);
            intent.putExtra("THE_NAME", theater);
            context.startActivity(intent);
        }
    }

    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MyViewHolder holder, int position) {
        Movie movie = data.get(position);
        holder.title.setText(movie.getMovName());
        holder.strDate.setText(movie.getMovStartDate());
        holder.endDate.setText(movie.getMovEndDate());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
