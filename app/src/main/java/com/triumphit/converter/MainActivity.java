package com.triumphit.converter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_face);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d1006c")));
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        pc = new PicCurrency();

        tvFrom = (TextView) findViewById(R.id.from);
        tvTo = (TextView) findViewById(R.id.to);



        b = (Button) findViewById(R.id.button);
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
                startActivityForResult(i, 1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra("result");
                //String from_where = data.getStringExtra("from_where");
                if(from_where.equals("from")){
                    tvFrom.setText(result);
                }else if(from_where.equals("to")){
                    tvTo.setText(result);
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
    protected void onResume() {
//        Bundle extras = getIntent().getExtras();
//        String cur;
//
//        if (extras != null) {
//            cur = extras.getString("cur");
//            tvFrom.setText(cur);
//            //Log.e("curr Clicked after", "" + curr);
//        }
        super.onResume();
//        Intent intent = getIntent();
//        String goID = intent.getStringExtra("goID");
//        if(goID == null){
//            //
//        }else if( !goID.equals("") ){
//            tvFrom.setText(goID);
//        }
    }
}
