package com.triumphit.converter;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.andexert.library.RippleView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.pushbots.push.Pushbots;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements CustomEvents {

    Button b;
    Spinner from;
    ArrayList country;
    ArrayList cur;
    TextView tvFrom, tvTo;
    PicCurrency pc;
    String curr, from_where;
    EditText edfrom, edto;
    SharedPreferences sp;
    CustomEvents ce;
    TextView tvRate, tvDate, tvTime, tvAsk, tvBid;
    ProgressBar pb;
    private AdView mAdView;

    //Abir
    private String url1 = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22USDEUR%22%29&env=store://datatables.org/alltableswithkeys";
    Button ab;
    EditText ae;
    private HandleXML obj;
    boolean connected = false;


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(true);
        setContentView(R.layout.front_final);
        //getS/upportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d1006c")));
        ce = this;

        Pushbots.sharedInstance().init(this);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        pc = new PicCurrency();
        sp = getSharedPreferences("Currency", Context.MODE_PRIVATE);

        final Animation anim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        tvFrom = (TextView) findViewById(R.id.from);
        tvTo = (TextView) findViewById(R.id.to);
        tvRate = (TextView) findViewById(R.id.tvRate);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvAsk = (TextView) findViewById(R.id.tvAsk);
        tvBid = (TextView) findViewById(R.id.tvBid);
        edfrom = (EditText) findViewById(R.id.edfrom);
        edto = (EditText) findViewById(R.id.edto);
        pb = (ProgressBar) findViewById(R.id.progressBar2);



        //tvFrom.startAnimation(anim);

        //tvTo.startAnimation(anim);

        b = (Button) findViewById(R.id.button);
        //b.startAnimation(anim);
        b.setBackgroundColor(Color.parseColor("#d1006c"));
        RippleView pv = (RippleView) findViewById(R.id.more);
        pv.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {

            }
        });



        RippleView fromRipple = (RippleView) findViewById(R.id.fromRipple);
        RippleView toRipple = (RippleView) findViewById(R.id.toRipple);
        fromRipple.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView v) {
                Intent i = new Intent(MainActivity.this, PicCurrency.class);
                from_where = "from";
                startActivityForResult(i, 1);

            }
        });
        toRipple.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent i = new Intent(MainActivity.this, PicCurrency.class);
                from_where = "to";
                //hideComponent();
                startActivityForResult(i, 1);
            }
        });

        //Abir-xml handler

        List<Currency> c = null;
        ab = (Button) findViewById(R.id.button);
        //ae = (EditText) findViewById(R.id.e1);

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String g = "" + tvFrom.getText() + tvTo.getText() + "rate";
                String name = tvFrom.getText().toString() + tvTo.getText().toString();

                if(connected){
                    pb.setVisibility(View.VISIBLE);
                    String url = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22" + tvFrom.getText() + tvTo.getText() + "%22%29&env=store://datatables.org/alltableswithkeys";
                    obj = new HandleXML(url, MainActivity.this, ("" + tvFrom.getText().toString() + tvTo.getText().toString()), ce);
                    obj.fetchXML();

                }else{
                    if(!sp.getString(g, "").equals("")){
                        String rate = sp.getString(g, "");
                        String date = sp.getString(name + "date", "");
                        String time = sp.getString(name + "time", "");
                        String ask = sp.getString(name + "ask", "");
                        String bid = sp.getString(name + "bid", "");

                        setOnAllComplete(rate, date, time, bid, ask);
                    }
                }

                //edto.setText("" + sp.getFloat(g, 0.0f));

                //while (obj.parsingComplete) ;


            }
        });
        showComponent();
        //rate us count
        try {

            // Get the app's shared preferences
            SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

            // Get the value for the run counter
            int counter = app_preferences.getInt("counter", 0);

            // Do every x times
            int RunEvery = 3;

            if(counter != 0  && counter % RunEvery == 0 )
            {
                //Toast.makeText(this, "This app has been started " + counter + " times.", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alert = new AlertDialog.Builder(
                        MainActivity.this);
                alert.setTitle("Please rate");
                alert.setIcon(R.drawable.ic_launcher); //app icon here
                alert.setMessage("Thanks for using this free app. Please take a moment to rate it.");

                alert.setPositiveButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                //Do nothing
                            }
                        });

                alert.setNegativeButton("Rate it",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                final String appName = getApplicationContext().getPackageName();
                                try {
                                    startActivity(new Intent(Intent.ACTION_VIEW,
                                            Uri.parse("market://details?id="
                                                    + appName)));
                                } catch (ActivityNotFoundException anfe) {
                                    startActivity(new Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("http://play.google.com/store/apps/details?id="
                                                    + appName)));
                                }

                            }
                        });
                alert.show();
            }


            // Increment the counter
            SharedPreferences.Editor editor = app_preferences.edit();
            editor.putInt("counter", ++counter);
            editor.commit(); // Very important

        } catch (Exception e) {
            //Do nothing, don't run but don't break
        }


    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void showComponent() {
        edfrom.setVisibility(View.VISIBLE);
        edfrom.setX(-500);
        edfrom.animate()
                .translationY(edfrom.getWidth())
                .setDuration(500)
                .x(0).setStartDelay(100);

        edto.setVisibility(View.VISIBLE);
        edto.setX(-500);
        edto.animate()
                .translationY(edto.getWidth())
                .setDuration(500)
                .x(0).setStartDelay(250);

        tvFrom.setVisibility(TextView.VISIBLE);
        tvFrom.setX(-150);
        tvFrom.animate()
                .translationY(tvFrom.getWidth())
                .setDuration(500)
                .x(10).setStartDelay(400);

        tvTo.setVisibility(TextView.VISIBLE);
        tvTo.setX(-150);
        tvTo.animate()
                .translationY(tvTo.getWidth())
                .setDuration(500)
                .x(10).setStartDelay(550);

        b.setVisibility(View.VISIBLE);
        b.setX(-900);
        b.animate()
                .translationY(b.getWidth())
                .setDuration(500)
                .x(0).setStartDelay(500);

    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private void hideComponent() {
        edfrom.setVisibility(View.VISIBLE);
        edfrom.setX(0);
        edfrom.animate()
                .translationX(edfrom.getWidth())
                .setDuration(500).alpha(0.0f)
                .x(-500).setStartDelay(100);

        edto.setVisibility(View.VISIBLE);
        edto.setX(0);
        edto.animate()
                .translationX(edto.getWidth())
                .setDuration(500).alpha(0.0f)
                .x(-500).setStartDelay(250);

        tvFrom.setVisibility(TextView.VISIBLE);
        tvFrom.setX(10);
        tvFrom.animate()
                .translationX(tvFrom.getWidth())
                .setDuration(500).alpha(0.0f)
                .x(-150).setStartDelay(400);

        tvTo.setVisibility(TextView.VISIBLE);
        tvTo.setX(10);
        tvTo.animate()
                .translationX(tvTo.getWidth())
                .setDuration(500).alpha(0.0f)
                .x(-150).setStartDelay(550);

        b.setVisibility(View.VISIBLE);
        b.setX(0);
        b.animate()
                .translationX(b.getWidth())
                .setDuration(500).alpha(0.0f)
                .x(-600).setStartDelay(500);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //showComponent();
                String result = data.getStringExtra("result");
                //String from_where = data.getStringExtra("from_where");
                if (from_where.equals("from")) {
                    tvFrom.setText(result);
                } else if (from_where.equals("to")) {
                    tvTo.setText(result);
                }

                //Log.e("Got", "got");

            }
            if (resultCode == RESULT_CANCELED) {
                //Log.e("Got", "got2");
            }
        }
    }//onActivityResult

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //
        switch (id){
            case R.id.credit:
                Intent i=new Intent(this,Credit.class);
                startActivity(i);
                return true;
            case R.id.rate:
                Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);

                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
                }
                return true;
            case R.id.contact:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/triumphITbd"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void setOnAllComplete(String rate, String date, String time, String bid, String ask) {
        //double from = Double.parseDouble(edfrom.getText().toString());
        //double to = Double.parseDouble(edfrom.getText().toString());
        //double rate2 = Double.parseDouble(rate);
        //edto.setText("" + (from * rate2));

//        tvRate.setText(rate);
//        tvDate.setText(date);
//        tvTime.setText(time);
//        tvBid.setText(bid);
//        tvAsk.setText(ask);
        Message msg = handler.obtainMessage();
        Bundle b = new Bundle();
        b.putString("rate", rate);
        b.putString("date", date);
        b.putString("time", time);
        b.putString("ask", ask);
        b.putString("bid", bid);
        msg.setData(b);
        handler.sendMessage(msg);
    }

    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            Bundle b = msg.getData();
            double from;
            try{
                from = Double.parseDouble(edfrom.getText().toString());
            }catch (NumberFormatException ne){
                from = 1;
            }

            //double to = Double.parseDouble(edfrom.getText().toString());
            double rate2 = Double.parseDouble(b.getString("rate"));
            edto.setText("" + (from * rate2));
            //copy clip board
            setClipboard(MainActivity.this,String.valueOf((from * rate2)));
            Toast.makeText(getApplicationContext(), "Text Copied to Clipboard",
                    Toast.LENGTH_SHORT).show();

            tvRate.setText("Rate: " + b.getString("rate"));
            tvDate.setText("Date: " + b.getString("date"));
            tvTime.setText("Time: " + b.getString("time"));
            tvAsk.setText("Ask: " + b.getString("ask"));
            tvBid.setText("Bid: " + b.getString("bid"));
            pb.setVisibility(View.GONE);
        }
    };
    //copy to click
    private void setClipboard(Context context,String text) {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
        }
    }
}
