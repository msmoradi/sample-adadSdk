package com.example.deeas.testadadsdk;

import android.app.Application;

import ir.adad.adadsdkv6.utils.ADAD;


public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // Input Your Token
        ADAD.init("173c94e65cec46faa1c29b3547cff707");

    }
}
