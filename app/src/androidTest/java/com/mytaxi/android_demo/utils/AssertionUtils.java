package com.mytaxi.android_demo.utils;

import android.support.test.espresso.ViewInteraction;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class AssertionUtils {

    private AssertionUtils() {}

    public static ViewInteraction isElementDisplayed(Matcher<View> matcher) {
        return onView(matcher).check(matches(isCompletelyDisplayed()));
    }
}
