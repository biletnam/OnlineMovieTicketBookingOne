package com.k4acreators.cinemaroo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.k4acreators.cinemaroo.R;

/**
 * Created by PC on 1/28/2018.
 */

public class SeatAdapter extends BaseAdapter {
    // private int image[]={R.drawable.download,R.drawable.images};
    private String status[];
    private String number[];
    private Context context;
    private LayoutInflater thisInflater;

    public SeatAdapter( String[] number, Context context, String[] stat) {
        this.number = number;
        this.context = context;
        this.status = stat;
        this.thisInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return number.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=thisInflater.inflate(R.layout.grid_item,viewGroup,false);
            TextView txt=(TextView)view.findViewById(R.id.txt_number);
            //ImageView img=(ImageView)view.findViewById(R.id.imgseat);
            txt.setText(number[i]);
            if (status[i] ==  "N") {
                txt.setBackgroundResource(R.drawable.green);
            }else if (status[i] == "Y"){
                txt.setBackgroundResource(R.drawable.red);
            }else if (status[i] == "E"){
                // txt.setBackgroundResource(R.drawable.download);
            }
        }
        return view;
    }
}
