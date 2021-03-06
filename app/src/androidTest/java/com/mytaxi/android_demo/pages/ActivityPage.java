package com.mytaxi.android_demo.pages;

import com.mytaxi.android_demo.R;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.utils.AssertionUtils.isElementDisplayed;

public class ActivityPage implements Page {
    private static final Logger LOG = LoggerFactory.getLogger(ActivityPage.class);

    private static final int ACTIVITY_VIEW_ID = R.id.nav_view;
    private static final int USER_NAME_ID = R.id.nav_username;
    private static final String LOGOUT_BUTTON_NAME = "Logout";


    public LoginPage logout() {
        LOG.info("Logging out");
        onView(withText(LOGOUT_BUTTON_NAME)).perform(click());
        return new LoginPage();
    }

    public ActivityPage shouldDisplayUserName(String userName) {
        LOG.info("Check that user name is displayer");
        onView(withId(USER_NAME_ID)).check(matches(withText(userName)));
        return this;
    }

    @Override
    public boolean isPageOpen() {
        try {
            isElementDisplayed(withId(ACTIVITY_VIEW_ID));
            LOG.info("Activity menu is open");
            return true;
        } catch (Exception exception) {
            LOG.info("Activity page is NOT opened");
            return false;
        }
    }
}
