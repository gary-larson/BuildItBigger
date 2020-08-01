package com.udacity.gradle.builditbigger;

import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class JavaMainActivityTest {
    // Declare constants
    private static final String BUTTON_TEXT = "Tell Joke";
    private static final String MAIN_TITLE_TEXT = "Build it Bigger";

    /**
     * Method to set create rule
     */
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new
            ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test to verify button text
     */
    @Test
    public void testJokeInJokeActivity () {
        onView(withText(BUTTON_TEXT)).check(matches(isDisplayed()));
    }

    /**
     * Test to verify title text
     */
    @Test
    public void testMainActivityTitle() {
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(MAIN_TITLE_TEXT)));
    }
}
