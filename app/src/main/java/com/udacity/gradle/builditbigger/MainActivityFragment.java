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
public class MainActivityFragment extends Fragment {
    // Declare constant
    private static final String LOADING_KEY = "LoadingKey";
    // Declare variables
    private FragmentMainBinding mBinding;
    private boolean isLoading;


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
        // get banner ads if in free flavor
        if (getResources().getBoolean(R.bool.is_free)) {
            AdUtility adUtility = new AdUtility(getContext());
            adUtility.getBannerAds(mBinding);
        }
        // set on click listener for tell joke button
        mBinding.bTellJoke.setOnClickListener((View.OnClickListener) getActivity());
        if (savedInstanceState != null) {
            setIsLoading(savedInstanceState.getBoolean(LOADING_KEY));
        }
        return view;
    }

    /**
     * Method to adjust fragment when resuming
     */
    @Override
    public void onResume() {
        super.onResume();
        // Set loading indicator to current value of is loading
        setIsLoading(isLoading);
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
     * Method to set visibility on loading indicator
     * @param loading indicator
     */
    public void setIsLoading(boolean loading) {
        isLoading = loading;
        if (isLoading) {
            mBinding.loadingIndicator.setVisibility(View.VISIBLE);
        } else {
            mBinding.loadingIndicator.setVisibility(View.GONE);
        }
    }
}
