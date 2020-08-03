package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;

/**
 * Class to display ads in free version
 */
public class AdUtility {
    // Declare variables
    private InterstitialAd mInterstitialAd;

    public AdUtility (Context context) {
        mInterstitialAd = new InterstitialAd(context);
    }

    /**
     * Method to display ads in free version
     * @param binding to access the ad view
     */
    public void getBannerAds(FragmentMainBinding binding) {
        AdView adView = binding.adView;
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    /**
     * Method to setup Interstitial Ads
     */
    public void setupInterstitialAd () {
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        //mInterstitialAd.setAdUnitId("/6499/example/interstitial");
        loadInterstitialAd();
    }

    /**
     * Method to load Interstitial Ads
     */
    public void loadInterstitialAd() {
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    /**
     * Method to show Interstitial Ads
     */
    public void showInterstitialAd () {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("MainActivity", "The interstitial wasn't loaded yet.");
        }
    }
}
