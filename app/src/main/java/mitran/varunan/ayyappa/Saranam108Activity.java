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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.io.InputStream;

public class Saranam108Activity extends AppCompatActivity {

    private String[] strValues = new String[2];
    public String[] mStringIds = {
            "சுவாமி ஐயப்பன் சரணம் 108-1", "சுவாமி ஐயப்பன் சரணம் 108-2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saranam108);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new mitran.varunan.ayyappa.SaranamImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                // Pass image index
                i.putExtra("id", strValues[position]);
                i.putExtra("title", mStringIds[position]);
                startActivity(i);
            }
        });

        InputStream is1 = null;
        try {
            is1 = getAssets().open("new1.txt");
            // check size
            int size = is1.available();
            // create buffer for IO
            byte[] buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[0] = new String(buffer);

            is1 = getAssets().open("new2.txt");
            // check size
            size = is1.available();
            // create buffer for IO
            buffer = new byte[size];
            // get data to buffer
            is1.read(buffer);
            // close stream
            is1.close();

            strValues[1] = new String(buffer);

            MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
            // Load an ad into the AdMob banner view.
            AdView adView = (AdView) findViewById(R.id.adView1);

            AdRequest adRequest = new AdRequest.Builder()
                    //.setRequestAgent("android_studio:ad_template")
                    .build();
            adView.loadAd(adRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
