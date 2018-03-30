package com.k4acreators.cinemaroo.Views;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.k4acreators.cinemaroo.Models.Theatre;
import com.k4acreators.cinemaroo.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.Calendar;

public class ShowTimeBookActivity extends BaseActivity implements View.OnClickListener
{

    //date picker
    Button btn;
    int yearx,monthx,dayx;
    static final int DILOG_ID=0;
    String  thi = " ";
    int sheatCountF = 0;
    int sheatCountH = 0;
    String[] ShowList = {"10.30 a.m - 12.30 p.m", "02.30 p.m - 04.30 p.m", "06.30 p.m - 08.30 p.m"};
    String selected = "";
    String[] SeatType = {"ODC", "Balcony", "BOX"};
    Button btnSubmit = null;
    MaterialBetterSpinner showTime=null;
    MaterialBetterSpinner seatType=null;
    EditText fulTickets=null;
    EditText halfTickets=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time_book);
        Bundle extras = getIntent().getExtras();
        thi = extras.getString("THE_NAME");
        initComponent();
        setListners();

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ShowList);
        MaterialBetterSpinner materialDesignSpinner1 = (MaterialBetterSpinner)
                findViewById(R.id.spinnerShowTime);
        materialDesignSpinner1.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SeatType);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner)
                findViewById(R.id.spinnerSeatType);
        materialDesignSpinner2.setAdapter(arrayAdapter2);

        ///date picker
        final Calendar cal=Calendar.getInstance();
        yearx=cal.get(Calendar.YEAR);
        monthx=cal.get(Calendar.MONTH);
        dayx=cal.get(Calendar.DAY_OF_MONTH);

        showDialogOnButtonClick();



        seatType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selected = parentView.getItemAtPosition(position).toString();
                if(selected.contentEquals("BOX")){
                    halfTickets.setEnabled(false);
                }else {
                    halfTickets.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }




    @Override
    public void onClick(View view) {
        switch (view.getId())
        {

            case R.id.bt_submit:
                Double sum =0.0;
                int count = 0;
                sheatCountF = Integer.parseInt(String.valueOf(fulTickets.getText())) ;
                sheatCountH = Integer.parseInt(String.valueOf(halfTickets.getText())) ;
                count = sheatCountF+sheatCountH;
                if (thi.equals("Savoy")){
                    sum = (sheatCountF * 800.00) + (sheatCountH*450.00);
                }else if (thi.equals("Liberty")){
                    sum = (sheatCountF * 600.00) + (sheatCountH*350.00);
                }
                Intent i = new Intent(ShowTimeBookActivity.this, SheatStructureActivity.class);
                i.putExtra("SUMOF",sum);
                i.putExtra("SHEATCOUNT",count);
                i.putExtra("THENAME",thi);
                startActivity(i);
                break;

            default:
                break;
        }
    }


    private void initComponent()
    {
        btnSubmit = (Button)findViewById(R.id.bt_submit);
        seatType=(MaterialBetterSpinner)findViewById(R.id.spinnerSeatType);
        showTime=(MaterialBetterSpinner)findViewById(R.id.spinnerShowTime);
        fulTickets=(EditText)findViewById(R.id.tf_full_tickets);
        halfTickets=(EditText)findViewById(R.id.tf_half_tickets);



    }

    private void setListners()
    {
        btnSubmit.setOnClickListener(this);
    }

    //datepicker
    public void showDialogOnButtonClick(){
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DILOG_ID);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if (id==DILOG_ID){
            return new DatePickerDialog(this,dpickerListner,yearx,monthx,dayx);
        }
        return null;

    }
    private DatePickerDialog.OnDateSetListener dpickerListner=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            yearx=year;
            monthx=month+1;
            dayx=dayOfMonth;
            Toast.makeText(ShowTimeBookActivity.this,yearx+"/"+monthx+"/"+dayx,Toast.LENGTH_LONG).show();
        }
    };


}
