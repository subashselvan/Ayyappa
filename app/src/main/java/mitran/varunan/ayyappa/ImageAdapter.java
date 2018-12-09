package mitran.varunan.ayyappa;

/**
 * Created by subash on 4/15/2017.
 */

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout;
        ImageView imageView;
        TextView txt ;

        if (convertView == null) {
            layout = new LinearLayout(mContext);
            layout.setOrientation(LinearLayout.VERTICAL);

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(1, 1, 1, 1);
            imageView.setImageResource(mThumbIds[position]);

            txt = new TextView(mContext);
            txt.setLayoutParams(new GridView.LayoutParams(350, 60));
            txt.setPadding(10,0,0,0);
            txt.setText(mStringIds[position]);


            layout.addView(imageView);
            layout.addView(txt);
        }
        else
        {
            //imageView = (ImageView) convertView;
            layout = (LinearLayout)convertView;
        }


        return layout;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.mipmap.ayyappa1, R.mipmap.ayyappa2,
            R.mipmap.ayyappa3, R.mipmap.ayyappa4,
            R.mipmap.ayyappa5, R.mipmap.ayyappa6,
            R.mipmap.ayyappa7, R.mipmap.ayyappa8,
            R.mipmap.ayyappa9, R.mipmap.ayyappa10,
            R.mipmap.ayyappa11
    };

    public String[] mStringIds = {
            "சரணம் 108-1", "சரணம் 108-2",
            "மூலமந்திரம்", "வழிநடைசரணம்",
            "வரலாறு","யாத்திரை",
            "வழிகள்","வாபர்",
            "பாடல்கள்", "வீடியோ பாடல்", "மங்களம்"

    };
}
