package com.mytaxi.android_demo.pages;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.activities.MainActivity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.utils.AssertionUtils.isElementDisplayed;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class MainPage implements Page {
    private static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

    private static final int SEARCH_CONTAINER_ID = R.id.searchContainer;
    private static final int SEARCH_TEXT_ID = R.id.textSearch;
    private static final int ACTIVITY_MENU_CHOICE_ID = R.id.drawer_layout;

    public MainPage() {
        this.isPageOpen();
    }

    public DriverDetailsPage searchDriver(String searchInput,
                                          String driverFullName,
                                          ActivityTestRule<MainActivity> mainActivityRule) throws InterruptedException {
        MainActivity currentActivity = mainActivityRule.getActivity();
        clearSearch();
        // need to wait until mHttpClient.fetchDrivers() in MainActivity class will finish it's work
        Thread.sleep(1000);

        LOG.info("Type {} to driver search textbox", searchInput);
        onView(withId(SEARCH_TEXT_ID))
                .perform(typeText(searchInput), closeSoftKeyboard());

        LOG.info("Select {} name from found drivers", driverFullName);
        onView(withText(driverFullName))
                .inRoot(RootMatchers.withDecorView(
                        not(is(currentActivity.getWindow().getDecorView()))))
                        .perform(click());

        return new DriverDetailsPage();
    }

    public ActivityPage navigateToActivityChoice() {
        LOG.info("Navigate to activity choice menu");
        onView(withId(ACTIVITY_MENU_CHOICE_ID)).perform(DrawerActions.open());
        return new ActivityPage();
    }

    public MainPage clearSearch() {
        LOG.info("Removing data from search driver textbox");
        onView(withId(SEARCH_TEXT_ID))
                .perform(clearText(), closeSoftKeyboard());
        return this;
    }

    @Override
    public boolean isPageOpen() {
        try {
            isElementDisplayed(withId(SEARCH_CONTAINER_ID));
            LOG.info("Main page is open");
            return true;
        } catch (Exception exception) {
            LOG.info("Main page is NOT opened");
            return false;
        }
    }
}
