package com.triumphit.converter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class Menues extends AppCompatActivity {

    TextView version, about;
    RippleView rv;
    Tracker t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menues);

        t = ((GoogleAnalyticsApp) getApplication()).getTracker(GoogleAnalyticsApp.TrackerName.APP_TRACKER);
        t.setScreenName("About");
        t.send(new HitBuilders.AppViewBuilder().build());

        Account account = getAccount(AccountManager.get(getApplicationContext()));
        final String accountName;
        if(account == null){
            accountName = "notSet";
        } else{
            accountName = account.name;
        }

        version = (TextView) findViewById(R.id.version);
        about = (TextView) findViewById(R.id.about);
        rv = (RippleView) findViewById(R.id.more);
        String s = "About: Currency converter is an android application made by TRIUMPHIT which has the ability to show the real time currency exchange. It can also store date for offline use. Currency Converter has the greatest look and feel and you will be having an unbelievable user friendly experience.";

        s = s.replaceAll("TRIUMPHIT", "<font color='#d1006c'>" + "TRIUMPHIT" + "</font>");

        about.setText(Html.fromHtml(s));

        try {
            version.setText("Version: " + getPackageManager()
                    .getPackageInfo(getPackageName(), 0).versionName);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            version.setText("*.*.*.*");
        }

        rv.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                t.send(new HitBuilders.EventBuilder()
                        .setCategory("Rated")
                        .setAction(accountName)
                        .build());
                Uri uri = Uri.parse("market://details?id=" + Menues.this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + Menues.this.getPackageName())));
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(Menues.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(Menues.this).reportActivityStop(this);
    }

    public static Account getAccount(AccountManager accountManager) {
        Account[] accounts = accountManager.getAccountsByType("com.google");
        Account account;
        if (accounts.length > 0) {
            account = accounts[0];
        } else {
            account = null;
        }
        return account;
    }
}
