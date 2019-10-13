package mitran.varunan.ayyappa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

public class ReviewDialog {
    private static final int LAUNCHES_UNTIL_PROMPT = 10;
    private static final int DAYS_UNTIL_PROMPT = 3;
    private static final int MILLIS_UNTIL_PROMPT = DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000;
    private static final String PREF_NAME = "APP_RATER3";
    private static final String LAST_PROMPT = "LAST_PROMPT";
    private static final String LAUNCHES = "LAUNCHES";
    private static final String DISABLED = "DISABLED";

    private  Context mContext;


    public void ShowRateDialog(Context context) {
        mContext = context;
        boolean shouldShow = false;
        SharedPreferences sharedPreferences = getSharedPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        long currentTime = System.currentTimeMillis();
        long lastPromptTime = sharedPreferences.getLong(LAST_PROMPT, 0);
        Log.d("Subash", "lastPromptTime: "+ lastPromptTime);
        if (lastPromptTime == 0) {
            lastPromptTime = currentTime;
            editor.putLong(LAST_PROMPT, lastPromptTime);
        }

        if (!sharedPreferences.getBoolean(DISABLED, false)) {
            Log.d("Subash", "Review Dailog disabled: false");
            int launches = sharedPreferences.getInt(LAUNCHES, 0) + 1;
            Log.d("Subash", "Review Dailog  launch count:"+ launches);
            if (launches > LAUNCHES_UNTIL_PROMPT) {
                if (currentTime > lastPromptTime + MILLIS_UNTIL_PROMPT) {
                    Log.d("Subash", "Show Review Dialog");
                    shouldShow = true;
                }
            }
            editor.putInt(LAUNCHES, launches);
        }

        if (shouldShow) {
            ShowDialog();
            editor.putInt(LAUNCHES, 0).putLong(LAST_PROMPT, System.currentTimeMillis()).commit();
        } else {
            editor.commit();
        }

    }
  
    private  SharedPreferences getSharedPreferences() {
        return mContext.getSharedPreferences(PREF_NAME, 0);
    }


    private void ShowDialog() {
        final AlertDialog dlg = new AlertDialog.Builder(mContext)
                .setTitle("Rate this app")
                .setMessage("If you enjoy this app, please take a moment to rate this app. It won't take more than a minute. Thank you for your support!!!")
                .setPositiveButton("Rate now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("Subash", "Rate dialog is invoked3"+ BuildConfig.APPLICATION_ID);
                        Intent obj = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID));
                        mContext.startActivity(obj);
                        getSharedPreferences().edit().putBoolean(DISABLED, true).commit();
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("Remind later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No, thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getSharedPreferences().edit().putBoolean(DISABLED, true).commit();
                        dialog.dismiss();
                    }
                }).create();
        dlg.show();
    }
}
