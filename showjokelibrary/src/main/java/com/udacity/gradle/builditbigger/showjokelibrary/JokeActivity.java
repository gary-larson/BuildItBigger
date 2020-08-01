package com.udacity.gradle.builditbigger.showjokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.udacity.gradle.builditbigger.showjokelibrary.databinding.ActivityJokeBinding;



/**
 * Class to display a Joke
 */
public class JokeActivity extends AppCompatActivity {
    // Declare constant
    public static final String JOKE_STRING_KEY = "JokeStringKey";
    // Declare variables
    ActivityJokeBinding mBinding;

    /**
     * Method to create and inflate the main activity
     * @param savedInstanceState to deal with state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityJokeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(mBinding.container.getId(),
                                JokeFragment.newInstance(bundle.getString(JOKE_STRING_KEY)))
                        .commitNow();
            }
        }
        // Get a support ActionBar corresponding to this toolbar
        ActionBar actionBar = getSupportActionBar();

        // Enable the Up button
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Method to process toolbar clicks
     * @param item to process
     * @return either true or super
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // process the up button
        if (item.getItemId() == android.R.id.home) {
            finish();
            return(true);
        }
        return super.onOptionsItemSelected(item);
    }
}