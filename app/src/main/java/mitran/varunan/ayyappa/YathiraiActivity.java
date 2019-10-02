package mitran.varunan.ayyappa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class YathiraiActivity extends AppCompatActivity {
    Map<Integer, activityContent> hm = new HashMap<Integer,activityContent>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yathirai);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        MobileAds.initialize(this, "ca-app-pub-8029348846516333~6696244962");
        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView1);

        AdRequest adRequest = new AdRequest.Builder()
                //.setRequestAgent("android_studio:ad_template")
                .build();
        adView.loadAd(adRequest);

        Log.d("Subash", "Read File");
        ReadFile("yaathirai.txt");
        String str= getResources().getResourceEntryName(R.id.button1);
        Log.d("Subash", "Size of the hashmap:"+hm.size() );
        Button btnTxt = null;
        activityContent conObjVal  = null;
        for (int i= 1; i < hm.size()+1; i++ ){
            String btnresourceString = "button"+ i;
            Log.d("Subash", btnresourceString);
            int drawableResourceId = getResources().getIdentifier(btnresourceString, "id", getPackageName());
            Log.d("Subash", String.valueOf(drawableResourceId));
            btnTxt = (Button) findViewById(drawableResourceId);
            conObjVal = (activityContent)hm.get(i-1);
            btnTxt.setText(conObjVal.getBtnName());

        }
    }

    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), Main3Activity.class);
        // Pass image index
        int id = v.getId();
        Log.d("Subash", "button id:" + id);
        Button btnTxt = (Button) findViewById(id);
        activityContent conObjVal = null;
        switch (v.getId()) {
            case R.id.button1:
                conObjVal = (activityContent)hm.get(0);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button2:
                conObjVal = (activityContent)hm.get(1);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button3:
                conObjVal = (activityContent)hm.get(2);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;

            case R.id.button4:
                conObjVal = (activityContent)hm.get(3);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;

            case R.id.button5:
                conObjVal = (activityContent)hm.get(4);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button6:
                conObjVal = (activityContent)hm.get(5);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button7:
                conObjVal = (activityContent)hm.get(6);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button8:
                conObjVal = (activityContent)hm.get(7);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button9:
                conObjVal = (activityContent)hm.get(8);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button10:
                conObjVal = (activityContent)hm.get(9);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;

            case R.id.button11:
                conObjVal = (activityContent)hm.get(10);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;

            case R.id.button12:
                conObjVal = (activityContent)hm.get(11);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button13:
                conObjVal = (activityContent)hm.get(12);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button14:
                conObjVal = (activityContent)hm.get(13);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button15:
                conObjVal = (activityContent)hm.get(14);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button16:
                conObjVal = (activityContent)hm.get(15);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button17:
                conObjVal = (activityContent)hm.get(16);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button18:
                conObjVal = (activityContent)hm.get(17);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button19:
                conObjVal = (activityContent)hm.get(18);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button20:
                conObjVal = (activityContent)hm.get(19);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;

            case R.id.button21:
                conObjVal = (activityContent)hm.get(20);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;

            case R.id.button22:
                conObjVal = (activityContent)hm.get(21);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button23:
                conObjVal = (activityContent)hm.get(22);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button24:
                conObjVal = (activityContent)hm.get(23);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button25:
                conObjVal = (activityContent)hm.get(24);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button26:
                conObjVal = (activityContent)hm.get(25);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button27:
                conObjVal = (activityContent)hm.get(26);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
            case R.id.button28:
                conObjVal = (activityContent)hm.get(27);
                i.putExtra("id", conObjVal.getContent());
                i.putExtra("title", conObjVal.getTitle());
                break;
        }
        startActivity(i);
    }

    private  void ReadFile(String strfile)
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open(strfile)));
            String strCurrentLine;
            String strContent = "<br>";
            String strBtnName = "<name>";
            String strTitle = "<title>";

            // create StringBuffer object
            StringBuffer sb = new StringBuffer();
            activityContent contObj = new activityContent();
            int i = 0;
            while ((strCurrentLine = br.readLine()) != null) {

                if( strCurrentLine.equals(strContent)) {
                    contObj.setContent(sb.toString());
                    //myList.add(sb.toString());
                    hm.put(i,contObj);
                    contObj = new activityContent();
                    sb.delete(0, sb.length());
                    i++;
                }
                else if(strCurrentLine.endsWith(strBtnName)){
                    strCurrentLine = strCurrentLine.replace(strBtnName, "");
                    contObj.setBtnName(strCurrentLine);
                }
                else if(strCurrentLine.endsWith(strTitle)){
                    strCurrentLine = strCurrentLine.replace(strTitle, "");
                    contObj.setTitle(strCurrentLine);
                }
                else{
                    sb.append(strCurrentLine);
                    sb.append("\r\n\r\n");
                }
                //Log.d("Subash",strCurrentLine);
            }

            // Getting an iterator
            Iterator hmIterator = hm.entrySet().iterator();
            while (hmIterator.hasNext()) {
                Map.Entry mapElement = (Map.Entry)hmIterator.next();
                activityContent conObjVal = (activityContent) mapElement.getValue();
                //Log.d("Subash", conObjVal.getBtnName());
                //Log.d("Subash", conObjVal.getContent());
                Log.d("Subash", conObjVal.getTitle());
            }
        }
        catch (IOException e)
        {
            Log.d("Subash", "This is Exception" + e.getMessage());
            e.printStackTrace();
            return;
        }
    }

}
