package com.udacity.gradle.builditbigger.showjokelibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.udacity.gradle.builditbigger.showjokelibrary.databinding.FragmentJokeBinding;


/**
 * Class to handle qand inflate the main fragment
 */
public class JokeFragment extends Fragment {
    // Declare constant
    private static final String JOKE_PARAM = JokeActivity.JOKE_STRING_KEY;
    // Declare variables
    private FragmentJokeBinding mBinding;
    private String mJoke;

    /**
     * Default constructor
     */
    public JokeFragment() {}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param joke to pass
     * @return A new instance of fragment BlankFragment.
     */
    public static JokeFragment newInstance(String joke) {
        JokeFragment fragment = new JokeFragment();
        Bundle args = new Bundle();
        args.putString(JOKE_PARAM, joke);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Method to get the arguments passed to fragment
     * @param savedInstanceState for state issues
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mJoke = getArguments().getString(JOKE_PARAM);
        }
    }

    /**
     * Methof to create and inflate fragment_joke view
     * @param inflater to use
     * @param container that holds view
     * @param savedInstanceState for state issues
     * @return created view
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentJokeBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        // Set joke to joke text view
        mBinding.tvJoke.setText(mJoke);

        return view;
    }
}
