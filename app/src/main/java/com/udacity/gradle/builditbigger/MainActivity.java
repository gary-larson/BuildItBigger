package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.gradle.builditbigger.databinding.ActivityMainBinding;
import com.udacity.gradle.builditbigger.showjokelibrary.JokeActivity;

/**
 * Class to handle the main activity
 */
public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.AsyncResponse {

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
            getSupportFragmentManager().beginTransaction()
                    .replace(mBinding.fragment.getId(), MainActivityFragment.newInstance())
                    .commitNow();
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
        MainActivityFragment.isLoading = false;
        // setup intent to joke activity android library
        Intent intent = new Intent(this, JokeActivity.class);
        // use bundle to send joke through intent
        Bundle bundle = new Bundle();
        bundle.putString(JokeActivity.JOKE_STRING_KEY, output);
        intent.putExtras(bundle);
        // start joke activity in the android library
        startActivity(intent);
    }
}
