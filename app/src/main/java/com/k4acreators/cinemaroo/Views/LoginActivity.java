package com.k4acreators.cinemaroo.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.k4acreators.cinemaroo.Models.User;
import com.k4acreators.cinemaroo.R;
import com.k4acreators.cinemaroo.Utilitys.DbHelper;
import com.k4acreators.cinemaroo.Utilitys.Util;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity implements  View.OnClickListener{

    private TextView tvNewUser, recoverPin = null;
    EditText nickName, pin;
    LoginActivity context;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initComponent();
        setLisners();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bt_continue:
                logUserIn();
                break;
            case R.id.tv_new_user:
                Intent i = new Intent(LoginActivity.this, VerificationActivity.class);
                startActivity(i);
                break;
            case R.id.tv_recover_pin:
                Intent x = new Intent(LoginActivity.this, RecoverPinActivity.class);
                startActivity(x);
                break;
            default:
                break;
        }
    }


    private void initComponent()
    {
        tvNewUser = (TextView)findViewById(R.id.tv_new_user);
        recoverPin = (TextView)findViewById(R.id.tv_recover_pin);
        nickName = (EditText) findViewById(R.id.tf_nick_name);
        login = (Button) findViewById(R.id.bt_continue);
        pin = (EditText) findViewById(R.id.tf_pin_number);
        context = this;
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

    }
    private void setLisners()
    {
        tvNewUser.setOnClickListener(this);
        recoverPin.setOnClickListener(this);
        login.setOnClickListener(this);
    }
    /*
   Call sign up user service with the typed details
    */
    private void logUserIn(){

        String typedNickName = nickName.getText().toString().trim();
        String typedPin = pin.getText().toString().trim();

        if(typedNickName.length() == 0){
            showHintDialog(context, Util.noNickName, Util.alert);
            return;
        }

        if(typedPin.length() == 0){
            showHintDialog(context, Util.noPin, Util.alert);
            return;
        }

        if(typedPin.length() < 4){
            showHintDialog(context, Util.invalidPin, Util.alert);
            return;
        }
        DbHelper db = new DbHelper(this);
        List<User> users = new ArrayList<>();
        users = db.getAllUsers();
        for (User u:users) {
            if (u.getUsername() == typedNickName){
                if (u.getPassword() == typedPin){
                    loginPrefsEditor.putString("accessToken",u.getToken() );
                    loginPrefsEditor.commit();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        }


    }
}
