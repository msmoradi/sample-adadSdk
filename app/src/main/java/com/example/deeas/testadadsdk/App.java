package com.example.deeas.testadadsdk;

import android.app.Application;

import ir.adad.adadsdkv6.utils.ADAD;


public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        // Input Your Token
        ADAD.init("2ca798994fbe474daa7f6f4f09112612");
        ADAD.setTestMode(1);
    }
}
