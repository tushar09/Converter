package com.triumphit.converter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    @Override
    protected void onStart() {
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("amzn://apps/android?p=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("amzn://apps/android?p=" + appPackageName)));
            //String url = "http://www.amazon.com/TriumphIT-Music-Player/dp/B00ZD2D1T2/ref=sr_1_16?s=mobile-apps&ie=UTF8&qid=1434885049&sr=1-16&keywords=amazon+mp3&pebp=1434885051870&perid=10M3Z3SR7RE5RBMZ1M1N";
            //String url = "https://play.google.com/store/apps/details?id=" + appPackageName;
            //Intent i = new Intent(Intent.ACTION_VIEW);
            //i.setData(Uri.parse(url));
            //startActivity(i);
        }
        onBackPressed();

        super.onStart();
    }
}
