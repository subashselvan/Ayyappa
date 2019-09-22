package mitran.varunan.ayyappa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;

public class MandhiramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandhiram);

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

    private  String ReadFile(String strfile)
    {
        try {
            InputStream is1 = getAssets().open(strfile);
            // check size
            int size = is1.available();
            // create buffer for IO
            byte[] buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            return new String(buffer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), Main3Activity.class);
        // Pass image index
        int id = v.getId();
        Button btnTxt = (Button) findViewById(id);
        switch (v.getId()) {
            case R.id.button1:
                String strValues = new String("ஓம் ஹரி ஹர புத்ராய\n \tபுத்ரலாபாய!\n" +
                        "ஸத்ருநாசனாய\n மதகஜ வாகனாய\nமகா சாஸ்த்ரே நமஹ!");
                i.putExtra("id", strValues);
                i.putExtra("title", "ஐயப்பன் மூல மந்திரம்");


                break;
            case R.id.button2:
                i.putExtra("id", ReadFile("logoveeram.txt"));
                i.putExtra("title", "சாஸ்தா லோக வீரம்");

                break;

            case R.id.button3:
                i.putExtra("id", ReadFile("MalaiAniaMandhiram.txt"));
                i.putExtra("title", "மாலை அணியும் போது சொல்ல வேண்டிய மந்திரம்");

                break;
            case R.id.button4:
                i.putExtra("id", ReadFile("MalaiKalatraMandhiram.txt"));
                i.putExtra("title", "மாலை அவிழ்க்க சொல்ல வேண்டிய மந்திரம்");

                break;

        }

        startActivity(i);

    }


}
