package com.k4acreators.cinemaroo.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.k4acreators.cinemaroo.R;

public class FoodActivity extends BaseActivity implements  View.OnClickListener {

    Button submit;
    double sum = 0.00;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Bundle extras = getIntent().getExtras();
        sum = extras.getDouble("SUMOF");
        initComponent();
        setLisners();


    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSubmit:
                Intent i = new Intent(FoodActivity.this, ParkingArea.class);
                i.putExtra("SUMOF",sum);
                startActivity(i);
                break;

            default:
                break;
        }
    }
    private void initComponent()
    {
        submit=(Button)findViewById(R.id.btnSubmit);

    }
    private void setLisners()
    {
        submit.setOnClickListener(this);

    }
}
