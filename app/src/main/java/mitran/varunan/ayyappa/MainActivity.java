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

public class MainActivity extends AppCompatActivity {


        private String[] strValues = new String[10];
        public String[] mStringIds = {
                "சுவாமி ஐயப்பன் சரணம் 108-1", "சுவாமி ஐயப்பன் சரணம் 108-2",
                "ஐயப்பன் மூலமந்திரம்","சபரிமலை வழிநடை சரணம்",
                "ஐயப்பன் வரலாறு","சபரிமலை யாத்திரை",
                "சபரிமலை வழிகள்","வாபர் சுவாமி கதை",
                "ஐயப்பன் பாடல்கள்", "மங்களம்"
        };

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
                    if(position ==8) {
                        Intent i = new Intent(getApplicationContext(), ButtonActivity.class);
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
            try
            {
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


                strValues[2] =  new String("ஓம் ஹரி ஹர புத்ராய\n \tபுத்ரலாபாய!\n" +
                        "ஸத்ருநாசனாய\n மதகஜ வாகனாய\nமகா சாஸ்த்ரே நமஹ!");

                strValues[9] = "அறிந்தும் அறியாமலும், தெரிந்தும் தெரியாமலும் செய்த ஸகல குற்றங்களையும் பொருத்து காத்து ரக்க்ஷித்து அருள வேண்டும்." +
                        "ஓம் ஸ்ரீ சத்யமான பொண்ணு பதினெட்டு படிமேல் வாழும், வில்லாளி வீரன், வீரமணி கண்டன், காசி இராமேஸ்வரம்  பாண்டி மலையாளம் அடக்கி ஆளும்" +
                        "ஓம் ஸ்ரீ ஹரிஹர சுதன் கலியுக வரதன் ஆனந்த சித்தன் என் அய்யன் ஐயப்பன் சுவாமியே சரணம் ஐயப்பா";

                is1 = getAssets().open("new3.txt");
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

                is1 = getAssets().open("vabar.txt");
                // check size
                size = is1.available();
                // create buffer for IO
                buffer = new byte[size];
                // get data to buffer
                is1.read(buffer);
                // close stream
                is1.close();

                strValues[7] = new String(buffer);

                is1 = getAssets().open("songs.txt");
                // check size
                size = is1.available();
                // create buffer for IO
                buffer = new byte[size];
                // get data to buffer
                is1.read(buffer);
                // close stream
                is1.close();

                strValues[8] = new String(buffer);


                MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
                // Load an ad into the AdMob banner view.
                AdView adView = (AdView) findViewById(R.id.adView1);

                AdRequest adRequest = new AdRequest.Builder()
                        //.setRequestAgent("android_studio:ad_template")
                        .build();
                adView.loadAd(adRequest);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }


