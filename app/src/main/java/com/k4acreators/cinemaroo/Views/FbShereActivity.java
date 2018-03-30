package com.k4acreators.cinemaroo.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.widget.ShareButton;
import com.k4acreators.cinemaroo.R;

public class FbShereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb_shere);
        ShareOpenGraphObject object = new ShareOpenGraphObject.Builder()
                .putString("og:title", "Cinema Roo")
                .putString("og:description","Math haduva app ekak").build();

        ShareOpenGraphAction action = new ShareOpenGraphAction.Builder()
                .setActionType("books.reads").putObject("book", object)
                .build();
        ShareOpenGraphContent content = new ShareOpenGraphContent.Builder()
                .setPreviewPropertyName("book")
                .setAction(action)
                .build();
        //b1 = (Button) findViewById(R.id.login_button);
        ShareButton shareButton = (ShareButton)findViewById(R.id.login_button);
        shareButton.setShareContent(content);
    }
}
