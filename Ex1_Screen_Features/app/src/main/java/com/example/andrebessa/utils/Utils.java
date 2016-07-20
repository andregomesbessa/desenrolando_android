package com.example.andrebessa.utils;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;

/**
 * Created by andrebessa on 14/07/16.
 */
public class Utils {

    int orientation = 0;
    float density = 0;
    float height = 0;
    float width = 0;
    int mcc = 0;
    int mnc = 0;
    Locale locale = null;

    public Utils(Configuration configuration, DisplayMetrics metrics) {

        orientation = configuration.orientation;
        density = metrics.density;
        height = metrics.heightPixels;
        width = metrics.widthPixels;
        mcc = configuration.mcc;
        mnc = configuration.mnc;
        Locale locale = configuration.locale;
    }

    public void printLogDadosTela(){

        Log.d("NGVL", "density: " + density);
        Log.d("NGVL", "orientation: "+ orientation);
        Log.d("NGVL", "height: "+ height);
        Log.d("NGVL", "width: "+ width);
        if(locale != null){
            Log.d("NGVL", "language: "+ locale.getLanguage() + "-" + locale.getCountry());
        }

        Log.d("NGVL", "mcc: "+ mcc);
        Log.d("NGVL", "mnc: "+ mnc);

    }

    public int getOrientation() {
        return orientation;
    }

    public float getDensity() {
        return density;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public int getMcc() {
        return mcc;
    }

    public int getMnc() {
        return mnc;
    }

    public Locale getLocale() {
        return locale;
    }
}
