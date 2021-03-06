package com.triumphit.converter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PicCurrency extends AppCompatActivity {

    ListView lv;
    ArrayList country, cur;
    EditText cnty, crncy;
    public static String coun, curr = "USD";
    private static LayoutInflater inflater = null;
    View v = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_currency);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.piccurrency, null);
        //RippleView rv = (RippleView) v.findViewById(R.id.listviewClicked);


        country = new ArrayList();
        cur = new ArrayList();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#d1006c")));
        cnty = (EditText) findViewById(R.id.country);
        crncy = (EditText) findViewById(R.id.usd);
        crncy.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);

        country.add("Afghanistan");
        country.add("Åland Islands (Finland)");
        country.add("Albania");
        country.add("Algeria");
        country.add("American Samoa (USA)");
        country.add("Andorra");
        country.add("Angola");
        country.add("Anguilla (UK)");
        country.add("Antigua and Barbuda");
        country.add("Argentina");
        country.add("Armenia");
        country.add("Aruba (Netherlands)");
        country.add("Australia");
        country.add("Austria");
        country.add("Azerbaijan");
        country.add("Bahamas");
        country.add("Bahrain");
        country.add("Bangladesh");
        country.add("Barbados");
        country.add("Belarus");
        country.add("Belgium");
        country.add("Belize");
        country.add("Benin");
        country.add("Bermuda (UK)");
        country.add("Bhutan");
        country.add("Bolivia");
        country.add("Bosnia and Herzegovina");
        country.add("Botswana");
        country.add("Brazil");
        country.add("British Indian Ocean Territory (UK)");
        country.add("British Virgin Islands (UK)");
        country.add("Brunei");
        country.add("Bulgaria");
        country.add("Burkina Faso");
        country.add("Burundi");
        country.add("Cabo Verde");
        country.add("Cambodia");
        country.add("Cameroon");
        country.add("Canada");
        country.add("Caribbean Netherlands (Netherlands)");
        country.add("Cayman Islands (UK)");
        country.add("Central African Republic");
        country.add("Chad");
        country.add("Chile");
        country.add("China");
        country.add("Christmas Island (Australia)");
        country.add("Cocos (Keeling) Islands (Australia)");
        country.add("Colombia");
        country.add("Comoros");
        country.add("Congo, Republic of the");
        country.add("Congo, Democratic Republic of the");

        country.add("Costa Rica");
        country.add("Cote d'Ivoire");
        country.add("Croatia");
        country.add("Cuba");
        country.add("Curaçao (Netherlands)");
        country.add("Cyprus");
        country.add("Czech Republic");
        country.add("Denmark");
        country.add("Djibouti");
        country.add("Dominica");
        country.add("Dominican Republic");
        country.add("Ecuador");
        country.add("Egypt");
        country.add("El Salvador");
        country.add("Equatorial Guinea");
        country.add("Eritrea");
        country.add("Estonia");
        country.add("Ethiopia");
        country.add("Falkland Islands (UK)");

        country.add("Fiji");
        country.add("Finland");
        country.add("France");
        country.add("French Guiana (France)");
        country.add("French Polynesia (France)");
        country.add("Gabon");
        country.add("Gambia");
        country.add("Georgia");
        country.add("Germany");
        country.add("Ghana");
        country.add("Gibraltar (UK)");
        country.add("Greece");
        country.add("Greenland (Denmark)");
        country.add("Grenada");
        country.add("Guadeloupe (France)");
        country.add("Guam (USA)");
        country.add("Guatemala");
        country.add("Guernsey (UK)");
        country.add("Guinea");
        country.add("Guinea-Bissau");
        country.add("Guyana");
        country.add("Haiti");
        country.add("Honduras");
        country.add("Hong Kong (China)");
        country.add("Hungary");
        country.add("Iceland");
        country.add("India");
        country.add("Indonesia");
        country.add("International Monetary Fund (IMF)");
        country.add("Iran");
        country.add("Iraq");
        country.add("Ireland");
        country.add("Isle of Man (UK)");
        country.add("Israel");
        country.add("Italy");
        country.add("Jamaica");
        country.add("Japan");
        country.add("Jersey (UK)");
        country.add("Jordan");
        country.add("Kazakhstan");
        country.add("Kenya");
        country.add("Kiribati");
        country.add("Kosovo");
        country.add("Kuwait");
        country.add("Kyrgyzstan");
        country.add("Laos");
        country.add("Latvia");
        country.add("Lebanon");
        country.add("Lesotho");
        country.add("Liberia");
        country.add("Libya");
        country.add("Liechtenstein");
        country.add("Lithuania");
        country.add("Luxembourg");
        country.add("Macau (China)");
        country.add("Macedonia");
        country.add("Madagascar");
        country.add("Malawi");
        country.add("Malaysia");
        country.add("Maldives");
        country.add("Mali");
        country.add("Malta");
        country.add("Marshall Islands");
        country.add("Martinique (France)");
        country.add("Mauritania");
        country.add("Mauritius");
        country.add("Mayotte (France)");
        country.add("Mexico");
        country.add("Micronesia");
        country.add("Moldova");
        country.add("Monaco");
        country.add("Mongolia");
        country.add("Montenegro");
        country.add("Montserrat (UK)");
        country.add("Morocco");
        country.add("Mozambique");
        country.add("Myanmar");
        country.add("Namibia");
        country.add("Nauru");
        country.add("Nepal");
        country.add("Netherlands");
        country.add("New Caledonia (France)");
        country.add("New Zealand");
        country.add("Nicaragua");
        country.add("Niger");
        country.add("Nigeria");
        country.add("Niue (New Zealand)");
        country.add("Norfolk Island (Australia)");
        country.add("North Korea");
        country.add("Northern Mariana Islands (USA)");
        country.add("Norway");
        country.add("Oman");
        country.add("Pakistan");
        country.add("Palau");
        country.add("Palestine");
        country.add("Panama");
        country.add("Papua New Guinea");
        country.add("Paraguay");
        country.add("Peru");
        country.add("Philippines");
        country.add("Pitcairn Islands (UK)");
        country.add("Poland");
        country.add("Portugal");
        country.add("Puerto Rico (USA)");
        country.add("Qatar");
        country.add("Reunion (France)");
        country.add("Romania");
        country.add("Russia");
        country.add("Rwanda");
        country.add("Saint Barthélemy (France)");
        country.add("Saint Helena (UK)");
        country.add("Saint Kitts and Nevis");
        country.add("Saint Lucia");
        country.add("Saint Martin (France)");
        country.add("Saint Pierre and Miquelon (France)");
        country.add("Saint Vincent and the Grenadines");
        country.add("Samoa");
        country.add("San Marino");
        country.add("Sao Tome and Principe");
        country.add("Saudi Arabia");
        country.add("Senegal");
        country.add("Serbia");
        country.add("Seychelles");
        country.add("Sierra Leone");
        country.add("Singapore");
        country.add("Sint Maarten (Netherlands)");
        country.add("Slovakia");
        country.add("Slovenia");
        country.add("Solomon Islands");
        country.add("Somalia");
        country.add("South Africa");
        country.add("South Korea");
        country.add("South Sudan");
        country.add("Spain");
        country.add("Sri Lanka");
        country.add("Sudan");
        country.add("Suriname");
        country.add("Svalbard and Jan Mayen (Norway)");
        country.add("Swaziland");
        country.add("Sweden");
        country.add("Switzerland");
        country.add("Syria");
        country.add("Taiwan");
        country.add("Tajikistan");
        country.add("Tanzania");
        country.add("Thailand");
        country.add("Timor-Leste");
        country.add("Togo");
        country.add("Tokelau (New Zealand)");
        country.add("Tonga");
        country.add("Trinidad and Tobago");
        country.add("Tunisia");
        country.add("Turkey");
        country.add("Turkmenistan");
        country.add("Turks and Caicos Islands (UK)");
        country.add("Tuvalu");
        country.add("Uganda");
        country.add("Ukraine");
        country.add("United Arab Emirates");
        country.add("United Kingdom");
        country.add("United States of America");
        country.add("Uruguay");
        country.add("US Virgin Islands (USA)");
        country.add("Uzbekistan");
        country.add("Vanuatu");
        country.add("Vatican City (Holy See)");
        country.add("Venezuela");
        country.add("Vietnam");
        country.add("Wallis and Futuna Islands (France)");
        country.add("Yemen");
        country.add("Zambia");
        country.add("Zimbabwe");

        cur.add("AFN");
        cur.add("EUR");
        cur.add("ALL");
        cur.add("DZD");
        cur.add("USD");
        cur.add("EUR");
        cur.add("AOA");
        cur.add("XCD");
        cur.add("XCD");
        cur.add("ARS");
        cur.add("AMD");
        cur.add("AWG");
        cur.add("AUD");
        cur.add("EUR");
        cur.add("AZN");
        cur.add("BSD");
        cur.add("BHD");
        cur.add("BDT");
        cur.add("BBD");
        cur.add("BYR");
        cur.add("EUR");
        cur.add("BZD");
        cur.add("XOF");
        cur.add("BMD");
        cur.add("BTN");
        cur.add("BOB");
        cur.add("BAM");
        cur.add("BWP");
        cur.add("BRL");
        cur.add("USD");
        cur.add("USD");
        cur.add("BND");
        cur.add("BGN");
        cur.add("XOF");
        cur.add("BIF");
        cur.add("CVE");
        cur.add("KHR");
        cur.add("XAF");
        cur.add("CAD");
        cur.add("USD");
        cur.add("KYD");
        cur.add("XAF");
        cur.add("XAF");
        cur.add("CLP");
        cur.add("CNY");
        cur.add("AUD");
        cur.add("AUD");
        cur.add("COP");
        cur.add("KMF");
        cur.add("XAF");
        cur.add("CDF");
        cur.add("CRC");
        cur.add("XOF");
        cur.add("HRK");
        cur.add("CUP");
        cur.add("ANG");
        cur.add("EUR");
        cur.add("CZK");
        cur.add("DKK");
        cur.add("DJF");
        cur.add("XCD");
        cur.add("DOP");
        cur.add("USD");
        cur.add("EGP");
        cur.add("USD");
        cur.add("XAF");
        cur.add("ERN");
        cur.add("EUR");
        cur.add("ETB");
        cur.add("FKP");
        cur.add("FJD");
        cur.add("EUR");
        cur.add("EUR");
        cur.add("EUR");
        cur.add("XPF");
        cur.add("XAF");
        cur.add("GMD");
        cur.add("GEL");
        cur.add("EUR");
        cur.add("GHS");
        cur.add("GIP");
        cur.add("EUR");
        cur.add("DKK");
        cur.add("XCD");
        cur.add("EUR");
        cur.add("USD");
        cur.add("GTQ");
        cur.add("GGP");
        cur.add("GNF");
        cur.add("XOF");
        cur.add("GYD");
        cur.add("HTG");
        cur.add("HNL");
        cur.add("HKD");
        cur.add("HUF");
        cur.add("ISK");
        cur.add("INR");
        cur.add("IDR");
        cur.add("XDR");
        cur.add("IRR");
        cur.add("IQD");
        cur.add("EUR");
        cur.add("IMP");
        cur.add("ILS");
        cur.add("EUR");
        cur.add("JMD");
        cur.add("JPY");
        cur.add("JEP");
        cur.add("JOD");
        cur.add("KZT");
        cur.add("KES");
        cur.add("AUD");
        cur.add("EUR");
        cur.add("KWD");
        cur.add("KGS");
        cur.add("LAK");
        cur.add("EUR");
        cur.add("LBP");
        cur.add("LSL");
        cur.add("LRD");
        cur.add("LYD");
        cur.add("CHF");
        cur.add("EUR");
        cur.add("EUR");
        cur.add("MOP");
        cur.add("MKD");
        cur.add("MGA");
        cur.add("MWK");
        cur.add("MYR");
        cur.add("MVR");
        cur.add("XOF");
        cur.add("EUR");
        cur.add("USD");
        cur.add("EUR");
        cur.add("MRO");
        cur.add("MUR");
        cur.add("EUR");
        cur.add("MXN");
        cur.add("USD");
        cur.add("MDL");
        cur.add("EUR");
        cur.add("MNT");
        cur.add("EUR");
        cur.add("XCD");
        cur.add("MAD");
        cur.add("MZN");
        cur.add("MMK");
        cur.add("NAD");
        cur.add("AUD");
        cur.add("NPR");
        cur.add("EUR");
        cur.add("XPF");
        cur.add("NZD");
        cur.add("NIO");
        cur.add("XOF");
        cur.add("NGN");
        cur.add("NZD");
        cur.add("AUD");
        cur.add("KPW");
        cur.add("USD");
        cur.add("NOK");
        cur.add("OMR");
        cur.add("PKR");
        cur.add("USD");
        cur.add("ILS");
        cur.add("USD");
        cur.add("PGK");
        cur.add("PYG");
        cur.add("PEN");
        cur.add("PHP");
        cur.add("NZD");
        cur.add("PLN");
        cur.add("EUR");
        cur.add("USD");
        cur.add("QAR");
        cur.add("EUR");
        cur.add("RON");
        cur.add("RUB");
        cur.add("RWF");
        cur.add("EUR");
        cur.add("SHP");
        cur.add("XCD");
        cur.add("XCD");
        cur.add("EUR");
        cur.add("EUR");
        cur.add("XCD");
        cur.add("WST");
        cur.add("EUR");
        cur.add("STD");
        cur.add("SAR");
        cur.add("XOF");
        cur.add("RSD");
        cur.add("SCR");
        cur.add("SLL");
        cur.add("SGD");
        cur.add("ANG");
        cur.add("EUR");
        cur.add("EUR");
        cur.add("SBD");
        cur.add("SOS");
        cur.add("ZAR");
        cur.add("KRW");
        cur.add("SSP");
        cur.add("EUR");
        cur.add("LKR");
        cur.add("SDG");
        cur.add("SRD");
        cur.add("NOK");
        cur.add("SZL");
        cur.add("SEK");
        cur.add("CHF");
        cur.add("SYP");
        cur.add("TWD");
        cur.add("TJS");
        cur.add("TZS");
        cur.add("THB");
        cur.add("USD");
        cur.add("XOF");
        cur.add("NZD");
        cur.add("TOP");
        cur.add("TTD");
        cur.add("TND");
        cur.add("TRY");
        cur.add("TMT");
        cur.add("USD");
        cur.add("AUD");
        cur.add("UGX");
        cur.add("UAH");
        cur.add("AED");
        cur.add("GBP");
        cur.add("USD");
        cur.add("UYU");
        cur.add("USD");
        cur.add("UZS");
        cur.add("VUV");
        cur.add("EUR");
        cur.add("VEF");
        cur.add("VND");
        cur.add("XPF");
        cur.add("YER");
        cur.add("ZMW");
        cur.add("USD");

//        getSupportActionBar().hide();
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//        getWindow().setLayout((int)(width * .9), (int)(height * .7));\
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new CountryAndCurListAdap(PicCurrency.this, country, cur));
        cnty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    String s = editable.toString();
                    ArrayList cn = new ArrayList(), cr = new ArrayList();
                    for (int i = 0; i < country.size(); i++) {
                        if (country.get(i).toString().toLowerCase().startsWith(s.toLowerCase())) {
                            cn.add(country.get(i));
                            cr.add(cur.get(i));
                        }
                    }
                    lv.setAdapter(new CountryAndCurListAdap(PicCurrency.this, cn, cr));
                } else {
                    lv.setAdapter(new CountryAndCurListAdap(PicCurrency.this, country, cur));
                }
            }
        });

        crncy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    String s = editable.toString();
                    ArrayList cn = new ArrayList(), cr = new ArrayList();
                    for (int i = 0; i < country.size(); i++) {
                        if (cur.get(i).toString().toLowerCase().startsWith(s.toLowerCase())) {
                            cn.add(country.get(i));
                            cr.add(cur.get(i));
                        }
                    }
                    lv.setAdapter(new CountryAndCurListAdap(PicCurrency.this, cn, cr));
                } else {
                    lv.setAdapter(new CountryAndCurListAdap(PicCurrency.this, country, cur));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pic_currency, menu);
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

    void getFinins(){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }

}
