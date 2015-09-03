package com.triumphit.converter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.widget.Spinner;
import android.widget.TextView;

import com.andexert.library.RippleView;

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
        //c=obj.getcurrency();
        /*for(int i = 0; i < c.size(); i++) {
            Log.d(c.get(i).getName(),"ABir");
        }*/

        showComponent();


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

            double from = Double.parseDouble(edfrom.getText().toString());
            //double to = Double.parseDouble(edfrom.getText().toString());
            double rate2 = Double.parseDouble(b.getString("rate"));
            edto.setText("" + (from * rate2));

            tvRate.setText("Rate: " + b.getString("rate"));
            tvDate.setText("Date: " + b.getString("date"));
            tvTime.setText("Time: " + b.getString("time"));
            tvAsk.setText("Ask: " + b.getString("ask"));
            tvBid.setText("Bid: " + b.getString("bid"));
        }
    };
}
