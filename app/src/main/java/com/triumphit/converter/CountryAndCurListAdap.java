package com.triumphit.converter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.util.ArrayList;

/**
 * Created by Tushar on 8/25/2015.
 */
public class CountryAndCurListAdap extends BaseAdapter {

    ArrayList country, cur;
    Context context;
    PicCurrency pc;
    String curr;
    private static LayoutInflater inflater = null;

    CountryAndCurListAdap(Context con, ArrayList country, ArrayList cur){
        this.country = country;
        this.cur = cur;
        context = con;
        pc = new PicCurrency();
    }

    @Override
    public int getCount() {
        return country.size();
    }

    @Override
    public Object getItem(int i) {
        return country.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        Holder holder;
        RippleView listClicked = null;
        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.piccurrency, null);

            holder = new Holder();
            holder.countryTextView = (TextView) convertView.findViewById(R.id.textView);
            holder.curTextView = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(holder);
        } else {
            //Log.i("TAG","inside");
            holder = (Holder) convertView.getTag();
            //rowView.setTag(holder);
        }
        listClicked = (RippleView) convertView.findViewById(R.id.listviewClicked);
        holder.curTextView.setText("" + cur.get(i));
        holder.countryTextView.setText("" + country.get(i));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = "" + cur.get(i);
                Log.e("curr Clicked", "list clicked");
//                pc.curr = (String) cur.get(i);
//                Intent returnIntent = new Intent();
//                ((Activity)context).setResult(1, returnIntent);
//                ((Activity)context).finish();
            }
        });
        listClicked.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView v) {


                TextView t = (TextView) v.findViewById(R.id.textView2);
                //Log.e("curr Clicked", "" + t.getText());
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "" + t.getText());
                ((Activity)context).setResult(Activity.RESULT_OK,returnIntent);
                ((Activity)context).finish();

            }
        });
        Animation animation = AnimationUtils.loadAnimation(((Activity)context), android.R.anim.slide_in_left);
        convertView.startAnimation(animation);
        return convertView;
    }
    public static class Holder {
        TextView countryTextView, curTextView;
        ImageButton menu;
        int position;
    }
}
