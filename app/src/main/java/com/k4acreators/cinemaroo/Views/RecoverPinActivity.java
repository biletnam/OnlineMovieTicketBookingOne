package com.k4acreators.cinemaroo.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.k4acreators.cinemaroo.R;
import com.k4acreators.cinemaroo.Utilitys.Util;

public class RecoverPinActivity extends BaseActivity {
    Button recover;
    EditText nickName;
    RecoverPinActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_pin);

        context = this;
        recover = (Button) findViewById(R.id.bt_continue);
        nickName = (EditText) findViewById(R.id.tf_nick_name);

        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo = nickName.getText().toString().trim();

                if(phoneNo.length() == 0){
                    showHintDialog(context, Util.noPhoneNumber1, Util.alert);
                    return;
                }

                if(phoneNo.length() < 10 || phoneNo.length() > 10){
                    showHintDialog(context, Util.invalidNumber, Util.alert);
                    return;
                }

                if(!phoneNo.matches("[0-9]+")){
                    showHintDialog(context, Util.invalidNumber, Util.alert);
                    return;
                }

                if(phoneNo.length() < 9){
                    showHintDialog(context, Util.invalidPhoneNumber, Util.alert);
                    return;
                }

                int firstDigit = Integer.parseInt(phoneNo.substring(0, 1));
                if(firstDigit == 0){
                    phoneNo = phoneNo.substring(1);
                }

                //send service call if internet is available
                /*if (checkInternet(context)) {
                    showProgressDialog(context, Utility.pleaseWait);
                    YaluWebService.recoverPin(context, phoneNo);
                } else {
                    showHintDialog(context, Utility.noInternet, Utility.alert);
                }*/

            }
        });

    }

    /*public void didReceiveRecoverPinResponse(int statusCode, JSONObject response) {

        Log.e("Response ", response.toString());
        try {
            if (response.has("success")) {

                Toast.makeText(context, "We have sent your pin number via SMS to " + response.getJSONObject("success").getJSONObject("result").getString("mobile_number") + ". Please wait for the SMS.", Toast.LENGTH_LONG).show();
                finish();
            } else {
                int errorCode = response.getJSONObject("error").getInt("code");

                if (errorCode == Utility.NO_USER_FOUND) {
                    showHintDialog(context, nickName.getText().toString().trim() + " is not a registered nick name", Utility.alert);
                } else {
                    showHintDialog(context, Utility.somwthing_wrong, Utility.alert);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        hideProgressDialog();
    }*/
}
