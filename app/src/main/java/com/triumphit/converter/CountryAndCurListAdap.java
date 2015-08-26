package com.triumphit.converter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by Tushar on 8/25/2015.
 */
public class CountryAndCurListAdap extends BaseAdapter {

    ArrayList country, cur;
    Context context;
    private static LayoutInflater inflater = null;

    CountryAndCurListAdap(Context con, ArrayList country, ArrayList cur){
        this.country = country;
        this.cur = cur;
        context = con;
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        Holder holder;
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

        holder.curTextView.setText("" + cur.get(i));
        holder.countryTextView.setText("" + country.get(i));

        return convertView;
    }
    public static class Holder {
        TextView countryTextView, curTextView;
        ImageButton menu;
        int position;
    }
}
