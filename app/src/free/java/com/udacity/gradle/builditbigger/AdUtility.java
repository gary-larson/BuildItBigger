package com.udacity.gradle.builditbigger;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;

/**
 * Class to display ads in free version
 */
public class AdUtility {

    /**
     * Method to display ads in free version
     * @param binding to access the ad view
     */
    public static void getBannerAds(FragmentMainBinding binding) {
        AdView adView = binding.adView;
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
