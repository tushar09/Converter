package com.triumphit.converter;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by muhai on 8/30/2015.
 */
public class HandleXML {
    private String Name = "Name";
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
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text=null;

        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String name=myParser.getName();

                switch (event){
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
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
                        break;
                }
                event = myParser.next();
            }
            parsingComplete = false;
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------
    public void fetchXML(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

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
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }



}
