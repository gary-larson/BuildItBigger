package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {
    // Declare constant
    private static final String LOADING_KEY = "LoadingKey";
    // Declare variables
    private FragmentMainBinding mBinding;
    public static boolean isLoading;


    /**
     * Method to create the main activity fragment instance
     * @return main activity fragment instance
     */
    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    /**
     * Method to create and initialize view
     * @param inflater to use
     * @param container that holds view
     * @param savedInstanceState of fragment
     * @return view created
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentMainBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        isLoading = false;
        // get banner ads
        AdUtility.getBannerAds(mBinding);
        // set on click listener for tell joke button
        mBinding.bTellJoke.setOnClickListener(this);
        if (savedInstanceState != null) {
            isLoading = savedInstanceState.getBoolean(LOADING_KEY);
            if (isLoading) {
                mBinding.loadingIndicator.setVisibility(View.VISIBLE);
            } else {
                mBinding.loadingIndicator.setVisibility(View.GONE);
            }
        }
        return view;
    }

    /**
     * Mehtod to adjust fragment when resuming
     */
    @Override
    public void onResume() {
        super.onResume();
        // Set loading indicator to current value of is loading
        if (isLoading) {
            mBinding.loadingIndicator.setVisibility(View.VISIBLE);
        } else {
            mBinding.loadingIndicator.setVisibility(View.GONE);
        }
    }

    /**
     * Method to save state
     * @param outState bundle to save to
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(LOADING_KEY, isLoading);
    }

    /**
     * Method to handle clicks in fragment
     * @param view that was clicked
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == mBinding.bTellJoke.getId()) {
            // show loading indicator
            isLoading = true;
            mBinding.loadingIndicator.setVisibility(View.VISIBLE);
            // create async task
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            // set up listener for endpoints completion
            endpointsAsyncTask.delegate = (EndpointsAsyncTask.AsyncResponse) getContext();
            // retrieve joke through endpoints
            endpointsAsyncTask.execute();
        }
    }
}
