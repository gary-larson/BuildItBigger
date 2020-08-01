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
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.notNullValue;

public class JavaLibraryAndroidLibraryEndpointsTest {
    // Declare constants
    private static final String BUTTON_TEXT = "Tell Joke";
    private static final String JOKE_TITLE_TEXT = "Enjoy Our Joke!";

    /**
     * Method to set create rule
     */
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule = new
            ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test to check random joke supplied by GCE as well as async task
     */
    @Test
    public void testJokeInJokeActivity () {
        onView(withText(BUTTON_TEXT)).perform(click());
        onView(withId(R.id.tv_joke)).check(matches(notNullValue()));
    }

    /**
     * Test to verify title
     */
    @Test
    public void testJokeActivityTitle() {
        onView(withText(BUTTON_TEXT)).perform(click());
        onView(allOf(isAssignableFrom(TextView.class), withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(JOKE_TITLE_TEXT)));
    }

}
