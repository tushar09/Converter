package com.triumphit.converter;

/**
 * Created by muhai on 8/31/2015.
 */
public class Currency {
    private String Name = "Name";
    private String Rate = "Rate";
    private String Date = "Date";
    private String Time = "Time";
    private String Ask = "Ask";
    private String Bid = "Bid";

    public String getName() {
        return Name;
    }

    public void setName(String n) {
        this.Name = n;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String p) {
        this.Rate = p;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String q) {
        this.Date = q;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String s) {
        this.Time = s;
    }

    public String getAsk() {
        return Ask;
    }

    public void setAsk(String ra) {
        this.Ask = ra;
    }

    public String getBid() {
        return Bid;
    }

    public void setBid(String na) {
        this.Bid = na;
    }

    public String toString() {
        return "" + Name + ": " + Rate + ": " + Date + ": " + Time + ": " + Ask + "";
    }
}
