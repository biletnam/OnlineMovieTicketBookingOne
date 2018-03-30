package com.k4acreators.cinemaroo.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.k4acreators.cinemaroo.R;

public class MainActivity extends BaseActivity implements  View.OnClickListener {

    ImageView ivBooking;
    ImageView ivMovies;
    ImageView ivProfile;
    ImageView ivFbshare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        setLisners();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.iv_booking:
                Intent intent3=new Intent(MainActivity.this,TheaterSelectActivity.class);
                startActivity(intent3);
                break;
            case R.id.iv_movies:
                Intent intent=new Intent(MainActivity.this,TheaterMovieListActivity.class);
                intent.putExtra("THENAME", "Savoy");
                startActivity(intent);
                break;
            case R.id.iv_profile:
                Intent intent2=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent2);
                break;
            case R.id.iv_fbshare:
                Intent intent4=new Intent(MainActivity.this,FbShereActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
    public void initComponent()
    {
        ivBooking=(ImageView)findViewById(R.id.iv_booking);
        ivMovies=(ImageView)findViewById(R.id.iv_movies);
        ivProfile=(ImageView)findViewById(R.id.iv_profile);
        ivFbshare=(ImageView)findViewById(R.id.iv_fbshare);
    }
    public void setLisners()
    {
        ivBooking.setOnClickListener(this);
        ivMovies.setOnClickListener(this);
        ivProfile.setOnClickListener(this);
        ivFbshare.setOnClickListener(this);
    }
}
