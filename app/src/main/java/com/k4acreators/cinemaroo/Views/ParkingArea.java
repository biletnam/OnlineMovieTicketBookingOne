package com.k4acreators.cinemaroo.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.k4acreators.cinemaroo.R;

public class ParkingArea extends BaseActivity implements  View.OnClickListener  {

        RadioGroup rg;
        Button b1;
        RadioButton rb;
        Button submit;
        double sum = 0.00;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_parking_area);
            Bundle extras = getIntent().getExtras();
            sum = extras.getDouble("SUMOF");
            initComponent();
            setLisners();
            rg = (RadioGroup) findViewById(R.id.radiodGrpOne);
            b1 = (Button)findViewById(R.id.btnSubmitParkingArea);
        }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSubmitParkingArea:
                Intent i = new Intent(ParkingArea.this, PPaymentActivity.class);
                i.putExtra("SUMOF",sum);
                startActivity(i);
                break;

            default:
                break;
        }
    }
    private void initComponent()
    {
        submit=(Button)findViewById(R.id.btnSubmitParkingArea);

    }
    private void setLisners()
    {
        submit.setOnClickListener(this);

    }

        //To create the radio button
        public void rbclick(View v) {
            int radioBtnId = rg.getCheckedRadioButtonId();
            rb = (RadioButton) findViewById(radioBtnId);

            Toast.makeText(getBaseContext(), rb.getText(), Toast.LENGTH_LONG).show();
        }

    }
