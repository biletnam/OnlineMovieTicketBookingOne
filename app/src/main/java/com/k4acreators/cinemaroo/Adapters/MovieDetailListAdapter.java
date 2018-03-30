package com.k4acreators.cinemaroo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.k4acreators.cinemaroo.Models.Movie;
import com.k4acreators.cinemaroo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 1/28/2018.
 */

public class MovieDetailListAdapter extends RecyclerView.Adapter<MovieDetailListAdapter.MyViewHolder> {
    List<Movie> data = new ArrayList<>();
    Context context;

    public MovieDetailListAdapter(List<Movie> data, Context c)
    {
        context = c;
        this.data = data;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public TextView link;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_movie_name);
            link = (TextView) view.findViewById(R.id.txt_link);
        }
    }

    @Override
    public MovieDetailListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_detail_item, parent, false);

        return new MovieDetailListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieDetailListAdapter.MyViewHolder holder, int position) {
        Movie movie = data.get(position);
        holder.title.setText(movie.getMovName());
        holder.description.setText(movie.getMovDiscrption());
        holder.link.setText(movie.getLink());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

