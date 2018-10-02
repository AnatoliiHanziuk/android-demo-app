package com.mytaxi.android_demo.pages;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.exceptions.PageNotOpenException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.utils.AssertionUtils.isElementDisplayed;

public class DriverDetailsPage implements BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(DriverDetailsPage.class);

    private static final int DRIVER_NAME_ID = R.id.textViewDriverName;
    private static final int CALL_BUTTON_ID = R.id.fab;

    public DriverDetailsPage() {
        try {
            isPageOpen();
        } catch (PageNotOpenException e) {
            e.printStackTrace();
        }
    }

    public void callToDriver() {
        LOG.info("Call to driver");
        onView(withId(CALL_BUTTON_ID)).perform(click());
    }

    public DriverDetailsPage shouldBeFound(String driverFullName) {
        LOG.info("Check that searched driver is found and displayed");
        onView(withId(DRIVER_NAME_ID)).check(matches(withText(driverFullName)));
        return this;
    }

    @Override
    public void isPageOpen() throws PageNotOpenException {
        try {
            isElementDisplayed(withId(DRIVER_NAME_ID));
            LOG.info("Driver details page is open");
        } catch (Exception exception) {
            throw new PageNotOpenException("Driver details page is not opened");
        }
    }
}
