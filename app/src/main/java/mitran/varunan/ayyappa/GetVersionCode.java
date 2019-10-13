package mitran.varunan.ayyappa;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;

public class GetVersionCode extends AsyncTask<Void, String, String> {

    private  Context mcontext = null;
    public GetVersionCode(Context context) {
        mcontext = context;
    }
    @Override
    protected String doInBackground(Void... voids) {

        String newVersion = null;String CurrentVersion = null;
        try {
            PackageInfo pInfo = mcontext.getPackageManager().getPackageInfo(mcontext.getPackageName(), 0);
            CurrentVersion = pInfo.versionName;
            Log.d("Subash", "The Current version is :"+ CurrentVersion);
            Log.d("Subash", "Application ID is :"+ BuildConfig.APPLICATION_ID);
            newVersion = Jsoup.connect("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "&hl=it")
                    .timeout(3000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select(".hAyfc .htlgb")
                    .get(7)
                    .ownText();
            Log.d("Subash", "The New version is :"+ newVersion);
            if (newVersion != null && !newVersion.isEmpty()) {
                if (Float.valueOf(CurrentVersion) < Float.valueOf(newVersion)) {
                    return "1";
                }
            }
            return "0";
        } catch (Exception e) {
            return "0";
        }
    }
}
