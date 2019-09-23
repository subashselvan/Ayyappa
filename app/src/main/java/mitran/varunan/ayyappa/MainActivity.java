package mitran.varunan.ayyappa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private int postab;
    private String[] strValues = new String[13];
    public String[] mStringIds = {
            "சுவாமி ஐயப்பன் சரணம் 108-1", "சுவாமி ஐயப்பன் மந்திரங்கள்",
            "சபரிமலை செல்வோரின் விரத முறைகள்", "சபரிமலை பதினெட்டுப் படிகளின் தத்துவம்",
            "ஐயப்பன் வரலாறு", "சிறப்புத் தகவல்கள்",
            "சபரிமலை வழிகள்","சபரிமலை வழிநடை சரணம்", "வாபர் சுவாமி கதை",
            "ஐயப்பன் பாடல்கள்", "வீடியோ பாடல்கள்","கோயில்கள்",
            "மங்களம்"
    };

    private RewardedVideoAd mRewardedVideoAd;
    private InterstitialAd interstitialAd;
    private static final String AD_UNIT_ID = "ca-app-pub-8029348846516333/6256076571";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new mitran.varunan.ayyappa.ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Toast.makeText(HelloGridView.this, "" + position,
                //Toast.LENGTH_SHORT).show();
                if (position == 9 || position == 1 || position == 5 || position == 11) {
                    postab  = position;
                    showInterstitial();
                }
                else  if(position == 10)
                {
                    loadRewardedVideoAd();
                    showRewardedVideo();
                }
                else  if(position == 0) {
                    Intent i = new Intent(getApplicationContext(), Saranam108Activity.class);
                    // Pass image index
                    i.putExtra("id", strValues[position]);
                    i.putExtra("title", mStringIds[position]);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                    // Pass image index
                    i.putExtra("id", strValues[position]);
                    i.putExtra("title", mStringIds[position]);
                    startActivity(i);
                }
            }
        });


        InputStream is1 = null;
        try {
            strValues[0] = new String("108 Saranam");

            is1 = getAssets().open("viradham.txt");
            // check size
            int size = is1.available();
            // create buffer for IO
            byte[] buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[2] = new String(buffer);


            strValues[1] = new String("ஓம் ஹரி ஹர புத்ராய\n \tபுத்ரலாபாய!\n" +
                    "ஸத்ருநாசனாய\n மதகஜ வாகனாய\nமகா சாஸ்த்ரே நமஹ!");

            strValues[11] = "அறிந்தும் அறியாமலும், தெரிந்தும் தெரியாமலும் செய்த ஸகல குற்றங்களையும் பொருத்து காத்து ரக்க்ஷித்து அருள வேண்டும்." +
                    "ஓம் ஸ்ரீ சத்யமான பொண்ணு பதினெட்டு படிமேல் வாழும், வில்லாளி வீரன், வீரமணி கண்டன், காசி இராமேஸ்வரம்  பாண்டி மலையாளம் அடக்கி ஆளும்" +
                    "ஓம் ஸ்ரீ ஹரிஹர சுதன் கலியுக வரதன் ஆனந்த சித்தன் என் அய்யன் ஐயப்பன் சுவாமியே சரணம் ஐயப்பா";

            is1 = getAssets().open("18stepsThatuvam.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();
            strValues[3] = new String(buffer);



            is1 = getAssets().open("varalaru.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[4] = new String(buffer);

            is1 = getAssets().open("yaathirai.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[5] = new String(buffer);


            is1 = getAssets().open("vazhaligal.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[6] = new String(buffer);

            is1 = getAssets().open("new3.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[7] = new String(buffer);

            is1 = getAssets().open("vabar.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[8] = new String(buffer);

            is1 = getAssets().open("songs.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[9] = new String(buffer);


            MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
            // Load an ad into the AdMob banner view.
            AdView adView = (AdView) findViewById(R.id.adView1);

            AdRequest adRequest = new AdRequest.Builder()
                    //.setRequestAgent("android_studio:ad_template")
                    .build();
            adView.loadAd(adRequest);

            MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
            mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
            mRewardedVideoAd.setRewardedVideoAdListener(this);
            loadRewardedVideoAd();

            MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
            interstitialAd = new InterstitialAd(this);
            // Defined in res/values/strings.xml
            interstitialAd.setAdUnitId("ca-app-pub-8029348846516333/7522848795");
            AdRequest adRequest1 = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest1);

            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    //startGame();
                    AdRequest adRequest = new AdRequest.Builder().build();
                    interstitialAd.loadAd(adRequest);
                    ShowAllButton();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            ShowAllButton();
        }
    }

    private void loadRewardedVideoAd()  {
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
            //Toast.makeText(this, "load Ads is loaded", Toast.LENGTH_SHORT).show();
        }
        else {
            //Toast.makeText(this, "load Ads is not loaded", Toast.LENGTH_SHORT).show();
        }

    }

    private void showRewardedVideo() {
        //showVideoButton.setVisibility(View.INVISIBLE);
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
            //Toast.makeText(this, "show Ads is loaded", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent (getApplicationContext (), BtnYoutubeActivity.class);
            startActivity (i);
            //Toast.makeText(this, "show Ads is not loaded", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        //Toast.makeText(this, "Reward Ads is loaded", Toast.LENGTH_SHORT).show();
        //showRewardedVideo();
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        //Toast.makeText(this, "Reward Ads is closed", Toast.LENGTH_SHORT).show();
        loadRewardedVideoAd();
        //ShowSongsLyricsButton ();
        Intent i = new Intent (getApplicationContext (), BtnYoutubeActivity.class);
        startActivity (i);
    }

    private void ShowAllButton() {
        if(postab == 9) {
            ShowSongsLyricsButton();
        }
        else if(postab == 1){
            ShowMandhiramButton();
        }
        else if(postab == 5){
            ShowInformationButton();
        }
        else if(postab == 11){
            ShowTemplesButton();
        }
    }

    private void ShowSongsLyricsButton() {
        Intent i = new Intent (getApplicationContext (), ButtonActivity.class);
        // Pass image index
        i.putExtra ("id", strValues[8]);
        i.putExtra ("title", mStringIds[8]);
        startActivity (i);
    }

    private void ShowMandhiramButton() {
        Intent i = new Intent (getApplicationContext (), MandhiramActivity.class);
        // Pass image index
        i.putExtra ("id", strValues[1]);
        startActivity (i);
    }

    private void ShowInformationButton() {
        Intent i = new Intent (getApplicationContext (), information.class);
        // Pass image index
        i.putExtra ("id", strValues[1]);
        startActivity (i);
    }

    private void ShowTemplesButton() {
        Intent i = new Intent (getApplicationContext (), Temples.class);
        // Pass image index
        i.putExtra ("id", strValues[1]);
        startActivity (i);
    }



    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        //Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        //Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }
}


