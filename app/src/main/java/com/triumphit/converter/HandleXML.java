package com.triumphit.converter;


<<<<<<< HEAD
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

=======
>>>>>>> origin/master
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> origin/master

/**
 * Created by muhai on 8/30/2015.
 */
public class HandleXML {
<<<<<<< HEAD
    //new
    CustomEvents ce;
    private String urlString = null;
    List<Currency> allcurrency = new ArrayList<Currency>();
    private Currency cur;
    private Context context;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    String name;
    private final String RATE = "rate", DATE = "date", TIME = "time", ASK = "ask", BID = "bid";
    private boolean rate = false, date = false, time = false, bid = false, ask = false;

    public HandleXML(String url, Context context, String name, CustomEvents ce) {
        this.ce = ce;
        this.name = name;
        this.urlString = url;
        this.context = context;
        sp = context.getSharedPreferences("Currency", Context.MODE_PRIVATE);
        ed = sp.edit();

        //allcurrency=new ArrayList<Currency>();
    }

    public List<Currency> getcurrency() {
        return allcurrency;
    }

    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    //
    /*private String Name = "Name";
=======
    private String Name = "Name";
>>>>>>> origin/master
    private String Rate = "Rate";
    private String Date = "Date";
    private String Time = "Time";
    private String Ask = "Ask";
    private String Bid = "Bid";
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public HandleXML(String url){
        this.urlString = url;
    }

    public String getName(){
        return Name;
    }

    public String getRate(){
        return Rate;
    }

    public String getDate(){
        return Date;
    }

    public String getTime(){
        return Time;
    }
    public String Ask(){
        return Ask;
    }

    public String getBid(){
        return Bid;
<<<<<<< HEAD
    }*/

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;
=======
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text=null;
>>>>>>> origin/master

        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
<<<<<<< HEAD
                String tagname = myParser.getName();

                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("rate")) {
                            cur = new Currency();
                        }
=======
                String name=myParser.getName();

                switch (event){
                    case XmlPullParser.START_TAG:
>>>>>>> origin/master
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
<<<<<<< HEAD
                        if (tagname.equalsIgnoreCase("rate")) {
                            //allcurrency.add(cur);
                            cur.setRate(text);
                            Log.e("Rate", "" + cur.getRate());
                            ed.putString((name + RATE), cur.getRate());
                            ed.commit();
                            //ce.setRateComplete(cur.getRate());
                            rate = true;
                        } else if (tagname.equalsIgnoreCase("Name")) {
                            cur.setName(text);
                            Log.e("Name", "" + cur.getName());

                        } else if (tagname.equalsIgnoreCase("Date")) {
                            cur.setDate(text);
                            Log.e("Date", "" + cur.getDate());
                            ed.putString((name + DATE), cur.getDate());
                            ed.commit();
                            //ce.setDateComplete(cur.getDate());
                            date = true;
                        } else if (tagname.equalsIgnoreCase("Time")) {
                            cur.setTime(text);
                            Log.e("Time", "" + cur.getTime());
                            ed.putString((name + TIME), cur.getTime());
                            ed.commit();
                            //ce.setTimeComplete(cur.getTime());
                            time = true;
                        } else if (tagname.equalsIgnoreCase("Ask")) {
                            cur.setAsk(text);
                            Log.e("ask", "" + cur.getAsk());
                            ed.putString((name + ASK), cur.getAsk());
                            ed.commit();
                            //ce.setAskComplete(cur.getAsk());
                            ask = true;
                        } else if (tagname.equalsIgnoreCase("Bid")) {
                            cur.setBid(text);
                            Log.e("Bid", "" + cur.getBid());
                            ed.putString((name + BID), cur.getBid());
                            ed.commit();
                            //ce.setBidComplete(cur.getBid());
                            bid = true;
                            ce.setOnAllComplete(cur.getRate(), cur.getDate(), cur.getTime(), cur.getAsk(), cur.getBid());
                        } else {
                        }

//                        if(rate == true && date == true && time == true && bid == true && ask == true){
//                            ce.setOnAllComplete("" + rate, "" + date, "" + time, "" + ask, "" + bid);
//                            Log.e("check", " " + rate + " " + date+ " " + time + " " + ask + " " + bid);
//                        }else {
//                            Log.e("check false", " " + rate + " " + date+ " " + time + " " + ask + " " + bid);
//                        }

                        //Log.e("Abir", "" + cur.getName());
=======
                        if(name.equals("Name")){
                            Name = text;
                        }

                        else if(name.equals("Rate")){
                            Rate= text;
                        }

                        else if(name.equals("Date")){
                            Date=text;
                        }

                        else if(name.equals("Time")){
                            Time = text;
                        }
                        else if(name.equals("Ask")){
                            Ask=text;
                        }

                        else if(name.equals("Bid")){
                            Bid = text;
                        }

                        else{
                        }
>>>>>>> origin/master
                        break;
                }
                event = myParser.next();
            }
            parsingComplete = false;
<<<<<<< HEAD

        } catch (Exception x) {
            Log.e("Error", "" + x.toString());
=======
        }

        catch (Exception e) {
            e.printStackTrace();
>>>>>>> origin/master
        }
    }

    //------------------
<<<<<<< HEAD
    public void fetchXML() {
        Thread thread = new Thread(new Runnable() {
=======
    public void fetchXML(){
        Thread thread = new Thread(new Runnable(){
>>>>>>> origin/master
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
<<<<<<< HEAD
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
=======
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
>>>>>>> origin/master

                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream stream = conn.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);

                    parseXMLAndStoreIt(myparser);
                    stream.close();
<<<<<<< HEAD

                } catch (Exception e) {
=======
                }
                catch (Exception e) {
>>>>>>> origin/master
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


<<<<<<< HEAD
=======

>>>>>>> origin/master
}
