package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.gradle.builditbigger.databinding.ActivityMainBinding;
import com.udacity.gradle.builditbigger.showjokelibrary.JokeActivity;

/**
 * Class to handle the main activity
 */
public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.AsyncResponse,
        View.OnClickListener {
    // Declare variables
    MainActivityFragment mMainActivityFragment;
    AdUtility mAdUtility;


    /**
     *Method to create and initialize the main activity
     * @param savedInstanceState to deal with state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Declare variables
        com.udacity.gradle.builditbigger.databinding.ActivityMainBinding mBinding =
                ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        if (savedInstanceState == null) {
            // load main activity fragment
            mMainActivityFragment = MainActivityFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(mBinding.fragment.getId(), mMainActivityFragment)
                    .commitNow();
        }
        if (getResources().getBoolean(R.bool.is_free)) {
            mAdUtility = new AdUtility(this);
            mAdUtility.setupInterstitialAd();
        }
    }

    /**
     * Method on resume to load new Interstitial ad in free mode
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (getResources().getBoolean(R.bool.is_free)) {
            // load a new Interstitial ad
            mAdUtility.loadInterstitialAd();
        }
    }

    /**
     * Method to initialize the menu
     * @param menu to initialize
     * @return true if complete
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Method to deal with menu clicks
     * @param item clicked
     * @return true if handled
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void asyncCompleted(String output) {
        // turn off loading indicator
        mMainActivityFragment.setIsLoading(false);
        // setup intent to joke activity android library
        Intent intent = new Intent(this, JokeActivity.class);
        // use bundle to send joke through intent
        Bundle bundle = new Bundle();
        bundle.putString(JokeActivity.JOKE_STRING_KEY, output);
        intent.putExtras(bundle);
        // start joke activity in the android library
        startActivity(intent);
    }

    /**
     * Method to handle clicks in fragment
     * @param view that was clicked
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.b_tell_joke) {
            // show ad in free mode
            if (getResources().getBoolean(R.bool.is_free)) {
                mAdUtility.showInterstitialAd();
            }
            // show loading indicator
            mMainActivityFragment.setIsLoading(true);
            // create async task
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            // set up listener for endpoints completion
            endpointsAsyncTask.delegate = this;
            // retrieve joke through endpoints
            endpointsAsyncTask.execute();
        }
    }
}
