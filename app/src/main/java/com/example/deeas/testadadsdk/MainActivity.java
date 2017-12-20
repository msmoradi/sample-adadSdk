package com.example.deeas.testadadsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ir.adad.adadsdkv6.core.banner.BannerAdListener;
import ir.adad.adadsdkv6.core.banner.BannerAdView;
import ir.adad.adadsdkv6.core.interstitial.InterstitialAd;
import ir.adad.adadsdkv6.core.interstitial.InterstitialAdListener;
import ir.adad.adadsdkv6.core.video.VideoAdFactory;
import ir.adad.adadsdkv6.core.video.VideoAdListener;
import ir.adad.adadsdkv6.core.video.fullscvideo.VideoAd;
import ir.adad.adadsdkv6.utils.AdType;

public class MainActivity extends AppCompatActivity {


    public BannerAdView bannerAdView;
    public InterstitialAd interstitialAd;
    public VideoAd videoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise bannerAdView
        bannerAdView = findViewById(R.id.banner);

        // @optional
        // set Your User Id
        bannerAdView.setUserId("");

        // set Your Banner Listener
        bannerAdView.setBannerAdListener(new BannerAdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdShow() {
                // Code to be executed when an ad show.

            }

            @Override
            public void onAdClosed() {
                // Code to be executed when an ad closed.
            }

            @Override
            public void onAdAvailable() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when an ad clicked.
            }
        });


        // just call this method when autoBannerView Boolean is False
        // bannerAdView.loadAd();


        // initialise interstitialAd
        interstitialAd = new InterstitialAd(this);

        // @optional
        // set Your User Id
        interstitialAd.setUserId("");

        // set Your Interstitial Listener
        interstitialAd.setInterstitialAdListener(new InterstitialAdListener() {
            @Override
            public void onAdOpened() {
                // Code to be executed when an ad show.

            }

            @Override
            public void onAdClosed() {
                // Code to be executed when an ad closed.

            }

            @Override
            public void onAdClicked() {
                // Code to be executed when an ad clicked.

            }

            @Override
            public void onAdFailedToLoad(int i) {
                // Code to be executed when an ad request fails.

            }

            @Override
            public void onAdLoaded(InterstitialAd interstitialAd) {
                // Code to be executed when an ad loaded.

            }
        });

        // initialise videoAd
        videoAd = VideoAdFactory.getInstance(this)
                .setAdType(AdType.FULLSCVIDEO)
                .setUserId("User Id")
                .build();

        videoAd.setVideoAdListener(new VideoAdListener() {
            @Override
            public void onAdFinished(boolean b, boolean b1, int i) {

                Log.d("ADAD SDK", "onAdFinished -> " + " wasSuccessfulView  : " + b + " wasCallToActionClicked : " + b1 + " skipTime :" + i);

            }
            @Override
            public void onAdStarted() {

            }
            @Override
            public void onAdFailedToLoad(int i) {

            }
        });


        findViewById(R.id.btn_interstitial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isAdLoaded())
                    interstitialAd.showAd();
            }
        });

        findViewById(R.id.btn_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoAd.isAdLoaded())
                    videoAd.showAd();
            }
        });
        findViewById(R.id.btn_prepareVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoAd.prepareAd();
            }
        });
        findViewById(R.id.btn_preparInterstitial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                interstitialAd.prepareAd();
            }
        });


    }

    @Override
    protected void onStop() {
        if (bannerAdView != null) {
            bannerAdView.onStop();
        }
        super.onStop();
    }


    @Override
    protected void onResume() {
        if (bannerAdView != null) {
            bannerAdView.onResume();
        }
        super.onResume();
    }


    @Override
    protected void onPause() {
        if (bannerAdView != null) {
            bannerAdView.onPause();
        }
        super.onPause();
    }
}
