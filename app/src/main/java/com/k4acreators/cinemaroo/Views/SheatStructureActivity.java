package com.k4acreators.cinemaroo.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.k4acreators.cinemaroo.Adapters.SeatAdapter;
import com.k4acreators.cinemaroo.R;

public class SheatStructureActivity extends BaseActivity  {

    GridView gridView;
    int count = 0;
    TextView txtCout = null;
    Button submit = null;
    int sheCount = 0;
    Double sum = 0.00;
    String thi = "";

    static final String[] numbers = new String[] {

            " ",  " ",  "A1", "A2", "A3", " ", "A4", "A5", "A6", " ", "A7", "A8",  "A9",  " ",   " ",
            " ",  "B1", "B2", "B3", "B4", " ", "B5", "B6", "B7", " ", "B8", "B9",  "B10", "B11", " ",
            "C1", "C2", "C3", "C4", "C5", " ", "C6", "C7", "C8", " ", "C9", "C10", "C11", "C12", "C13",
            "D1", "D2", "D3", "D4", "D5", " ", "D6", "D7", "D8", " ", "D9", "D10", "D11", "D12", "D13",
            "E1", "E2", "E3", "E4", "E5", " ", "E6", "E7", "E8", " ", "E9", "E10", "E11", "E12", "E13",

            " ",  " ",  " ",  " ",  " ",   " ",  " ",   " ",  " ",  " ",  " ",   " ",   " ",   " ",  " ",
            "F1", "F2", "F3", "F4", "F5",  "F6", "F7",  " ",  "F8", "F9", "F10", "F11", "F12", "F13","F14",
            "G1", "G2", "G3", "G4", "G5",  "G6", "G7",  " ",  "G8", "G9", "G10", "G11", "G12", "G13","G14",
            "H1", "H2", "H3", "H4", "H5",  "H6", "H7",  " ",  "H8", "H9", "H10", "H11", "H12", "H13","H14",
            "I1", "I2", "I3", "I4", "I5",  "I6", "I7",  " ",  "I8", "I9", "I10", "I11", "I12", "I13","I14",
            "J1", "J2", "J3", "J4", "J5",  "J6", "J7",  " ",  "J8", "J9", "J10", "J11", "J12", "J13","J14",
            "K1", "K2", "K3", "K4", "k5",  "K6", "K7",  " ",  "K8", "K9", "K10", "K11", "K12", "K13","K14",
            "L1", "L2", "L3", "L4", "L5",  "L6", "L7",  " ",  "L8", "L9", "L10", "L11", "L12", "L13","L14"
    };
    String[] seat1 = new String[]{
            "E","E","N","N","N","E","N","N","N","E","N","N","N","E","E",
            "E","N","N","N","N","E","N","N","N","E","N","N","N","N","E",
            "N","N","N","N","N","E","N","N","N","E","N","N","N","N","N",
            "N","N","N","N","N","E","N","N","N","E","N","N","N","N","N",
            "N","N","N","N","N","E","N","N","N","E","N","N","N","N","N",


            "E","E","E","E","E","E","E","E","E","E","E","E","E","E","E",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N"
    };
    String[] seat3 = new String[]{
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "E","E","E","E","E","E","E","E","E","E","E","E","E","E","E",

            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "E","E","E","E","E","E","E","E","E","E","E","E","E","E","E",

            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N",
            "N","N","N","N","N","N","N","E","N","N","N","N","N","N","N"


    };
    String[] numbers3 = new String[]{
            "A1", "A2", "A3", "A4", "A5", "A6", "A7", " ", "A8", "A9", "A10", "A11", "A12", "A13", "A14",
            "B1", "B2", "B3", "B4", "B5", "B6", "B7", " ", "B8", "B9", "B10", "B11", "B13", "B13", "B14",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", " ", "C8", "C9", "C10", "C11", "C12", "C13", "C14",
            " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
            "D1", "D2", "D3", "D4", "D5", "D6", "D7", " ", "D8", "D9", "D10", "D11", "D12", "D13", "D14",
            "E1", "E2", "E3", "E4", "E5", "E6", "E7", " ", "E8", "E9", "E10", "E11", "E12", "E13", "E14",
            "F1", "F2", "F3", "F4", "F5", "F6", "F7", " ", "F8", "F9", "F10", "F11", "F12", "F13", "F14",
            "G1", "G2", "G3", "G4", "G5", "G6", "G7", " ", "G8", "G9", "G10", "G11", "G12", "G13", "G14",
            " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
            "H1", "H2", "H3", "H4", "H5", "H6", "H7", " ", "H8", "H9", "H10", "H11", "H12", "H13", "H14",
            "I1", "I2", "I3", "I4", "I5", "I6", "I7", " ", "I8", "I9", "I10", "I11", "I12", "I13", "I14",
            "J1", "J2", "J3", "J4", "J5", "J6", "J7", " ", "J8", "J9", "J10", "J11", "J12", "J13", "J14",
            "K1", "K2", "K3", "K4", "k5", "K6", "K7", " ", "K8", "K9", "K10", "K11", "K12", "K13", "K14",
            "L1", "L2", "L3", "L4", "L5", "L6", "L7", " ", "L8", "L9", "L10", "L11", "L12", "L13", "L14",
            "M1", "M2", "M3", "M4", "M5", "M6", "M7", " ", "M8", "M9", "M10", "M11", "M12", "M13", "M14"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheat_structure);
        Bundle extras = getIntent().getExtras();
        sheCount = extras.getInt("SHEATCOUNT");
        sum = extras.getDouble("SUMOF");
        thi = extras.getString("THENAME");

        txtCout = (TextView)findViewById(R.id.txt_count);
        gridView = (GridView) findViewById(R.id.gridView1);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //       android.R.layout.simple_list_item_1, numbers);
        if (thi.equals("Savoy")){
            SeatAdapter gridViewAdapter=new SeatAdapter(numbers,getApplicationContext(),seat1);
            gridView.setAdapter(gridViewAdapter);
        }else if (thi.equals("Liberty")){
            SeatAdapter gridViewAdapter=new SeatAdapter(numbers3,getApplicationContext(),seat3);
            gridView.setAdapter(gridViewAdapter);
        }

        submit = (Button)findViewById(R.id.confirm);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (seat1[position] == "N") {
                    if (count < sheCount) {
                        seat1[position] = "Y";
                        count++;
                        txtCout.setText(String.valueOf(count));
                    }
                  /*  Toast.makeText(getApplicationContext(),
                            ((TextView) v).getText(), Toast.LENGTH_SHORT).show();*/


                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(SheatStructureActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("This seat already booked.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(SheatStructureActivity.this, FoodActivity.class);
                i.putExtra("SUMOF",sum);
                startActivity(i);
            }
        });

    }
}
