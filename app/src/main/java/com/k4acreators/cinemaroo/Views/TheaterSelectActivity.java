package com.k4acreators.cinemaroo.Views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.k4acreators.cinemaroo.Models.Theatre;
import com.k4acreators.cinemaroo.R;
import com.k4acreators.cinemaroo.Utilitys.DbHelper;
import com.k4acreators.cinemaroo.Utilitys.DbInitializer;
import com.k4acreators.cinemaroo.Utilitys.MapImpl;
import com.k4acreators.cinemaroo.Utilitys.Util;

import org.json.JSONObject;

import java.util.List;

public class TheaterSelectActivity extends BaseActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    protected GoogleMap googleMap;
    Spinner spin1;
    DbHelper db;
    private static final LatLng SAVOY = new LatLng(6.8791, 79.8597);
    private static final LatLng SAVOY2 = new LatLng(6.927079, 79.861244);
    private Marker mSavy;
    private Marker mSavy2;
    List<Theatre> theaters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_select);
        spin1 = (Spinner)findViewById(R.id.spinnerCity);
        initComponent();

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(TheaterSelectActivity.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.city));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        MapImpl.MAP_API_URL = getResources().getString(R.string.map_api_url);

        spin1.setAdapter(myAdapter);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = spin1.getSelectedItem().toString();
                //text = text.replaceAll(" ","%20");
                try {
                    if(text.equals("-Select-")) {
                        moveMap(6.8741, 79.8605, 10);
                    } else {
                        //JSONObject jsonObject = new MapClient(MapsActivity.this).execute(getResources().getString(R.string.map_api_url) + "address=" + text).get();
                        //JSONObject geo = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
                        //moveMap(geo.getDouble("lat"), geo.getDouble("lng"), 10);
                        //new MapClient(MapsActivity.this).execute(getResources().getString(R.string.map_api_url) + "address=" + text);
                        new MapClient(TheaterSelectActivity.this).execute(text);
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void initComponent()
    {
db = new DbHelper(TheaterSelectActivity.this);
       if (db.getAllTheater().size()>0){
           theaters =  db.getAllTheater();
       }else {
           DbInitializer initDb = new DbInitializer();
           initDb.theaterInit(TheaterSelectActivity.this);
           theaters =  db.getAllTheater();
       }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        //  moveMap(7.7428599, 80.8561285, 7);

        mSavy = googleMap.addMarker(new MarkerOptions()
                .position(SAVOY)
                .title("Savoy"));
        mSavy.setTag(0);

        mSavy2 = googleMap.addMarker(new MarkerOptions()
                .position(SAVOY2)
                .title("Liberty"));
        mSavy2.setTag(0);

        // Set a listener for marker click.
        googleMap.setOnMarkerClickListener(this);

    }
    @Override
    public boolean onMarkerClick(Marker marker) {


        Intent b = new Intent(getApplicationContext(),TheaterMovieListActivity.class);
        b.putExtra("THENAME", marker.getTitle());
        startActivity(b);

        return false;
    }
    protected void moveMap(double lat, double lng, int zoom) {
        try {
            LatLng latLng = new LatLng(lat, lng);

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(latLng)      // Sets the center of the map to location user
                    .zoom(zoom)
                    .build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    class MapClient extends AsyncTask<String, Integer, JSONObject> {

        ProgressDialog dialog;
        TheaterSelectActivity mapsActivity;
        JSONObject geo;

        public MapClient(TheaterSelectActivity activity) {
            this.mapsActivity = activity;
            dialog = new ProgressDialog(activity);
        }

        //declare other objects as per your need
        protected void onPreExecute() {
            dialog.setMessage("Getting location, please wait...");
            dialog.show();
        }

        @Override
        protected JSONObject doInBackground(String... names) {

            // Getting JSON from Response
            geo = MapImpl.getLocationByCity(names[0]);
            publishProgress(100);
            return geo;
        }

        protected void onProgressUpdate(Integer... progress) {
            try {
                mapsActivity.moveMap(geo.getDouble("lat"), geo.getDouble("lng"), 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPostExecute(JSONObject result)
        {
            super.onPostExecute(result);
            dialog.dismiss();
        }
    }
}
