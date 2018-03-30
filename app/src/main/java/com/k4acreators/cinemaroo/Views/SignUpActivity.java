package com.k4acreators.cinemaroo.Views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.k4acreators.cinemaroo.Models.User;
import com.k4acreators.cinemaroo.R;
import com.k4acreators.cinemaroo.Utilitys.DbHelper;
import com.k4acreators.cinemaroo.Utilitys.Util;

import java.util.Calendar;


public class SignUpActivity extends BaseActivity implements View.OnClickListener{

    private String userName, phoneNo, nic, password, rePassword , date , token ;

    private EditText editUserName = null;
    private EditText editPhone = null;
    private EditText editNic = null;
    private EditText editPassword = null;
    private EditText editRePassword = null;
    private Button  btn_resart = null;
    private Button btn_submit  = null;
    private EditText etPhoneNumber = null;




    SignUpActivity context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        InitComponent();
        SetLisners();



    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSubmitSignUp:
                userSignUp();
                break;
            case R.id.btnReset:
               resetDetail();
                break;
            default:
                break;
        }
    }

    private void resetDetail() {
        editNic.setText("");
        etPhoneNumber.setText("");
        editPassword.setText("");
        editRePassword.setText("");
        editUserName.setText("");

    }

    private void userSignUp() {
        initialize();
        if (validation()){
            DbHelper db = new DbHelper(this);
            User user = new User(0,userName,phoneNo,nic,date,password,token);
            db.addUser(user);
            Intent b = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(b);
        }else {
            Toast.makeText(this, "Sign Up has Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void InitComponent()
    {
        editUserName = (EditText) findViewById(R.id.edtUserNameSignIn);
        editPhone = (EditText) findViewById(R.id.tf_phone_number);
        etPhoneNumber = (EditText) findViewById(R.id.tf_phone_number);
        editNic = (EditText) findViewById(R.id.edtNic);
        editPassword = (EditText) findViewById(R.id.edtPassword);
        editRePassword = (EditText) findViewById(R.id.edtRePassword);
        btn_submit = (Button) findViewById(R.id.btnSubmitSignUp);
        btn_resart = (Button) findViewById(R.id.btnReset);
        context = this;
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        token = loginPreferences.getString("accessToken", "");

    }

    private void SetLisners()
    {
        btn_submit.setOnClickListener(this);
        btn_resart.setOnClickListener(this);
    }


    public Boolean   validation(){
        boolean valid = true;
        if(userName.isEmpty()||userName.length()>32){
            editUserName.setError("please Enter the Valid Name");
            valid = false;
            return false;
        }

        /*if(!(editNic.getText().toString().trim().matches("/^[0-9]{9}[vVxX]$/"))){
            editNic.setError("please Enter the Valid  NIC number");
            valid = false;
        }*/
        if(nic.isEmpty()||nic.length()>10){
            editNic.setError("please Enter the Valid Phone NIC number");
            valid = false;
            return false;
        }
     /*   if(!(nic.trim().matches("^[0-9]{10}[vVxX]$")))
        {
            showHintDialog(context, "please Enter the Valid Phone NIC number", Util.alert);
            return false;
        }*/
        if(password.isEmpty()){
            editPassword.setError("please Enter the password between 8 and 16 characters");
            valid = false;
            return false;
        }
        if(rePassword.isEmpty()||(password == rePassword)){
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
            valid = false;
        }


        return valid;
    }

    public void initialize(){
        userName = editUserName.getText().toString().trim();
        nic = editNic.getText().toString().trim();
        password = editPassword.getText().toString();
        rePassword = editRePassword.getText().toString().trim();
        phoneNo = editPhone.getText().toString().trim();
        date = nic.length() < 2 ? nic : nic.substring(0, 2);

    }



}

