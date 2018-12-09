package mitran.varunan.ayyappa;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;



public class BtnYoutubeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btnyoutube);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView1);

        AdRequest adRequest = new AdRequest.Builder()
                //.setRequestAgent("android_studio:ad_template")
                .build();
        adView.loadAd(adRequest);


    }

    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), YoutubeActivity.class);
        // Pass image index
        int id = v.getId();
        Button btnTxt = (Button) findViewById(id);
        switch (v.getId()) {
            case R.id.button1:
                i.putExtra("id", "SaNZ7lS4eZQ");
                i.putExtra("title", "ஹரிவராசனம்");
                break;
            case R.id.button2:
                i.putExtra("id", "65suFw_obn8");
                i.putExtra("title", "பள்ளிக்கட்டு சபரி மலைக்கு");

                break;
            case R.id.button3:
                i.putExtra("id", "LucIfo5NhQ0");
                i.putExtra("title", "எங்க கருப்பசாமி");
                break;

            case R.id.button4:
                i.putExtra("id", "_84tIv0XfaM");
                i.putExtra("title", "ஒண்ணாம் திருப்படி சரணம் பொன் ஐயப்பா");
                break;

            case R.id.button5:
                i.putExtra("id", "7k5zDLBZpWc");
                i.putExtra("title", "சன்னதியில் கட்டும் கட்டி");
                break;
            case R.id.button6:
                i.putExtra("id", "ipjbMRizhXI");
                i.putExtra("title", "கட்டோடு கட்டுமுடி");
                break;
            case R.id.button7:
                i.putExtra("id", "Bn3a3LodoI8");
                i.putExtra("title", "இருமுடிக்கட்டு சபரிமலைக்கு");
                break;

        }

        startActivity(i);

    }
}
