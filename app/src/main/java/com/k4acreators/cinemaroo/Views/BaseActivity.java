package com.k4acreators.cinemaroo.Views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by PC on 1/23/2018.
 */

public class BaseActivity extends AppCompatActivity {

    ProgressDialog dialog;
    public static boolean progressCalled = false;
    public SharedPreferences loginPreferences;
    public SharedPreferences.Editor loginPrefsEditor;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
    /**
     * initializes the progress bar
     *
     * @param context
     */
    protected void progressDialog(Context context) {

        if (dialog == null) {
            dialog = new ProgressDialog(context);
            dialog.setCancelable(false);
            dialog.setMessage("Please Wait...");
            dialog.setCancelable(false);
        }

        BaseActivity.progressCalled = true;
    }

    /**
     * hides the progress bar
     */
    protected void hideProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        BaseActivity.progressCalled = false;
    }

    /**
     * shows the progress bar
     *
     * @param context
     * @param message
     */
    protected void showProgressDialog(Context context, String message) {

        if (dialog == null) {
            progressDialog(context);
        }
        if (!dialog.isShowing()) {
            hideProgressDialog();
            dialog.setMessage(message);
        }
        dialog.show();
        BaseActivity.progressCalled = true;

    }

    /**
     * shows messages in a dialog
     *
     * @param context
     * @param message
     * @param title
     */
    protected final void showHintDialog(Context context, String message,
                                        String title) {
        new AlertDialog.Builder(context).setMessage(message).setTitle(title)
                .setPositiveButton("Done", null).create().show();
    }

    public void hideKeybord(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    //////////////////////
}
