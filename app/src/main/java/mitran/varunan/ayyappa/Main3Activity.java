package mitran.varunan.ayyappa;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/Uni Ila.Sundaram-03.ttf");
        TextView txtView5 = (TextView) findViewById(R.id.textView);
        Toolbar btn1 = (Toolbar) findViewById(R.id.toolbar);
        //btn1.setTypeface(tf);
        txtView5.setTypeface(tf);
        txtView5.setPadding(5,0,0,0);
        txtView5.setText(getIntent().getStringExtra("id"));
        txtView5.setMovementMethod(new ScrollingMovementMethod());
        btn1.setTitle(getIntent().getStringExtra("title"));
        TextView txtView1 = (TextView) findViewById(R.id.textView1);
        txtView1.setText("\n\n");

        MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView1);

        AdRequest adRequest = new AdRequest.Builder()
                //.setRequestAgent("android_studio:ad_template")
                .build();
        adView.loadAd(adRequest);
    }

}
