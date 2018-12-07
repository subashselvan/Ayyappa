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

import java.io.IOException;
import java.io.InputStream;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
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
        Intent i = new Intent(getApplicationContext(), Main3Activity.class);
        // Pass image index
        int id = v.getId();
        Button btnTxt = (Button) findViewById(id);
        switch (v.getId()) {
            case R.id.button1:
                i.putExtra("id", ReadFile("songs/harivarasanam.txt"));
                i.putExtra("title", "ஹரிவராசனம்");
                ;
                break;
            case R.id.button2:
                i.putExtra("id", ReadFile("songs/vannasanthrothaiyam.txt"));
                i.putExtra("title", "வண்ண சந்த்ரோதயம்");

                break;
            case R.id.button3:
                i.putExtra("id", ReadFile("songs/DeadukintraKankal.txt"));
                i.putExtra("title", "தேடுகின்ற கண்களுக்குள்");
                break;

            case R.id.button4:
                i.putExtra("id", ReadFile("songs/thulsimalai.txt"));
                i.putExtra("title", "துளசிமணி மாலை");
                break;

            case R.id.button5:
                i.putExtra("id", ReadFile("songs/AchanCoilArasae.txt"));
                i.putExtra("title", "அச்சன் கோவில் அரசே");
                break;
            case R.id.button6:
                i.putExtra("id", ReadFile("songs/AnnathanaPrabhuvae.txt"));
                i.putExtra("title", "அன்னதான பிரபுவே");
                break;
            case R.id.button7:
                i.putExtra("id", ReadFile("songs/AriyumAranumInnaintha.txt"));
                i.putExtra("title", "அரியும் அரனும் இணைந்து");
                break;

            case R.id.button8:
                i.putExtra("id", ReadFile("songs/ArulManakkumAandavanae.txt"));
                i.putExtra("title", "அருள் மணக்கும் ஆண்டவனே");
                break;
            case R.id.button9:
                i.putExtra("id", ReadFile("songs/AyyappanaiKanaVarungal.txt"));
                i.putExtra("title", "ஐயப்பனை காண வாருங்கள்");
                break;
            case R.id.button10:
                i.putExtra("id", ReadFile("songs/AyyappaSaranamAyyappa.txt"));
                i.putExtra("title", "ஐயப்பா சரணம் ஐயப்பா");
                break;
            case R.id.button11:
                i.putExtra("id", ReadFile("songs/BhavaanSaranam.txt"));
                i.putExtra("title", "பகவான் சரணம் பகவதி சரணம்");
                break;
            case R.id.button12:
                i.putExtra("id", ReadFile("songs/ElloramSarnthuSollunga.txt"));
                i.putExtra("title", "எல்லோரும் சேர்ந்து சொல்லுங்கோ");
                break;
            case R.id.button13:
                i.putExtra("id", ReadFile("songs/EngaeManakuthu.txt"));
                i.putExtra("title", "எங்கே மணக்குது சந்தனம்");
                break;

            case R.id.button14:
                i.putExtra("id", ReadFile("songs/EnnaVaramVendum.txt"));
                i.putExtra("title", "என்ன வரம் வேண்டும் கேளுங்கள்");
                break;
            case R.id.button15:
                i.putExtra("id", ReadFile("songs/JeevanEnbathuUllaVarai.txt"));
                i.putExtra("title", "ஜீவன் என்பது உள்ளவரை");
                break;
            case R.id.button16:
                i.putExtra("id", ReadFile("songs/KanniMoolaKanapathii.txt"));
                i.putExtra("title", "கன்னிமூல கணபதியை வேண்டி");
                break;
            case R.id.button17:
                i.putExtra("id", ReadFile("songs/MagarathinManiVilakku.txt"));
                i.putExtra("title", "மகரத்தின் மணிவிளக்கு");
                break;
            case R.id.button18:
                i.putExtra("id", ReadFile("songs/MalaiyamMalaiyam.txt"));
                i.putExtra("title", "மலையாம் மலையாம் சபரிமலையாம்");
                break;
            case R.id.button19:
                i.putExtra("id", ReadFile("songs/NalMuthuManiyadu.txt"));
                i.putExtra("title", "நல் முத்து மணியோடு");
                break;
            case R.id.button20:
                i.putExtra("id", ReadFile("songs/OamOamAyyappa.txt"));
                i.putExtra("title", "ஓம் ஓம் அய்யப்பா");
                break;
            case R.id.button21:
                i.putExtra("id", ReadFile("songs/PallikattuSabarimalaikku.txt"));
                i.putExtra("title", "பள்ளிக்கட்டு சபரி மலைக்கு");
                break;
            case R.id.button22:
                i.putExtra("id", ReadFile("songs/PanthalaRajaPambaVasa.txt"));
                i.putExtra("title", "பந்தளராஜா பம்பாவாசா");
                break;
            case R.id.button23:
                i.putExtra("id", ReadFile("songs/SaranamVilithalMaranam.txt"));
                i.putExtra("title", "சரணம் விளித்தால் மரணம்");
                break;
            case R.id.button24:
                i.putExtra("id", ReadFile("songs/SannathilKattumKatti.txt"));
                i.putExtra("title", "சன்னதியில் கட்டும் கட்டி");
                break;
            case R.id.button25:
                i.putExtra("id", ReadFile("songs/Thirupadisaranam.txt"));
                i.putExtra("title", "ஒண்ணாம் திருப்படி");
                break;
            case R.id.button26:
                i.putExtra("id", ReadFile("songs/EngaKaruppasamyAvar.txt"));
                i.putExtra("title", "எங்க கருப்ப சாமி அவர் எங்க");
                break;
            case R.id.button27:
                i.putExtra("id", ReadFile("songs/OruMandalamNonbu.txt"));
                i.putExtra("title", "ஒரு மண்டலம் நோன்பிருந்தோம்");
                break;
            case R.id.button28:
                i.putExtra("id", ReadFile("songs/Akashapuli.txt"));
                i.putExtra("title", "ஆகாசமாம் புள்ளி புலிமேல்");
                break;
            case R.id.button29:
                i.putExtra("id", ReadFile("songs/enjananam.txt"));
                i.putExtra("title", "என் ஜனனம் முதல் என் மரணம்");
                break;
            case R.id.button30:
                i.putExtra("id", ReadFile("songs/suprabaatham.txt"));
                i.putExtra("title", "சுப்ரபாதம் சுவாமி பள்ளி");
                break;
            case R.id.button31:
                i.putExtra("id", ReadFile("songs/SabarimalaiKaadu.txt"));
                i.putExtra("title", "சபரிமலைக்காடு அது");
                break;
        }

        startActivity(i);

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
}
