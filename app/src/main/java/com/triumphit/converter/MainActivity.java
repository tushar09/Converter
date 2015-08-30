package com.triumphit.converter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.andexert.library.RippleView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button b;
    Spinner from;
    ArrayList country;
    ArrayList cur;
    TextView tvFrom, tvTo;
    PicCurrency pc;
    String curr, from_where;
    EditText edfrom, edto;
    //Abir
    private String url1 = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22USDEUR%22,%20%22USDJPY%22,%20%22USDBGN%22,%20%22USDCZK%22,%20%22USDDKK%22,%20%22USDGBP%22,%20%22USDHUF%22,%20%22USDLTL%22,%20%22USDLVL%22,%20%22USDPLN%22,%20%22USDRON%22,%20%22USDSEK%22,%20%22USDCHF%22,%20%22USDNOK%22,%20%22USDHRK%22,%20%22USDRUB%22,%20%22USDTRY%22,%20%22USDAUD%22,%20%22USDBRL%22,%20%22USDCAD%22,%20%22USDCNY%22,%20%22USDHKD%22,%20%22USDIDR%22,%20%22USDILS%22,%20%22USDINR%22,%20%22USDKRW%22,%20%22USDMXN%22,%20%22USDMYR%22,%20%22USDNZD%22,%20%22USDPHP%22,%20%22USDSGD%22,%20%22USDTHB%22,%20%22USDZAR%22,%20%22USDISK%22%29&env=store://datatables.org/alltableswithkeys";
    Button ab;
    EditText ae;
    private HandleXML obj;


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_face);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d1006c")));
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        pc = new PicCurrency();

        final Animation anim = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        tvFrom = (TextView) findViewById(R.id.from);
        tvTo = (TextView) findViewById(R.id.to);
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

        ab=(Button)findViewById(R.id.b2);
        ae=(EditText)findViewById(R.id.e1);

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obj = new HandleXML(url1);
                obj.fetchXML();

                while (obj.parsingComplete) ;
                ae.setText(obj.getRate());
            }
        });




    }

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
        b.setX(-600);
        b.animate()
                .translationY(b.getWidth())
                .setDuration(500)
                .x(0).setStartDelay(500);

    }

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
                    if(result.equals("")){
                        tvFrom.setText("USD");
                    }else{
                        tvFrom.setText(result);
                    }

                } else if (from_where.equals("to")) {
                    if(result.equals("")){
                        tvTo.setText("USD");
                    }else{
                        tvTo.setText(result);
                    }
                }

            }
            if (resultCode == RESULT_CANCELED) {
                tvFrom.setText(pc.curr);
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
    protected void onStart() {
        showComponent();
        super.onStart();
    }

}
