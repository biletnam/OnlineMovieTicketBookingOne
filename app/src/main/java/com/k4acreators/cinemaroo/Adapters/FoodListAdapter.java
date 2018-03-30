package com.k4acreators.cinemaroo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.k4acreators.cinemaroo.Models.Food;
import com.k4acreators.cinemaroo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 1/28/2018.
 */

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.MyViewHolder> {
    List<Food> data = new ArrayList<>();
    Context context;

    public FoodListAdapter(List<Food> data, Context c)
    {
        context = c;
        this.data = data;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView price;
        public TextView endDate;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.txt_food_name);
            price = (TextView) view.findViewById(R.id.txt_price);
        }
    }

    @Override
    public FoodListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item, parent, false);

        return new FoodListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodListAdapter.MyViewHolder holder, int position) {
        Food food = data.get(position);
        holder.title.setText(food.getFName());
        holder.price.setText((int) food.getPrice());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
