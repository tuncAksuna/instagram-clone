package com.example.instagramcloneparseexample;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        //LogCatte PARSE'IN HATALARINI GÖRMEK İÇİN setLogLeve METODUNU KULLANDIK.
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("xMWiGJXlPl4X8TAAH1X4xZgUCrANXrSuTZoXQq7F")
                // if desired
                .clientKey("AVFqyUE1KftOsgnpe2UshSY2nssSEJPbSGFsvIls")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
