package com.k4acreators.cinemaroo.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.k4acreators.cinemaroo.R;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private Button logOut = null;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initComponent();
        setLisners();
    }

    void initComponent()
    {
        logOut = (Button)findViewById(R.id.btnOlgOut);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
    }
    void setLisners()
    {
        logOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnOlgOut:
                loginPrefsEditor.putString("accessToken"," " );
                loginPrefsEditor.commit();
                Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
                break;
                default:
                    break;
        }
    }
}
