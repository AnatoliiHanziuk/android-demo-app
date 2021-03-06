package com.mytaxi.android_demo.tests;

import android.support.test.runner.AndroidJUnit4;
import com.mytaxi.android_demo.pages.LoginPage;
import com.mytaxi.android_demo.pages.MainPage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DriverTests extends BaseTest {

    private MainPage mainPage = new MainPage();

    private static final String INPUT_SEARCH_TEXT = "sa";
    private static final String DRIVER_TO_BE_FOUND = "Sarah Scott";

    @Before
    public void loginBeforeTest() {
        if (!mainPage.isPageOpen()) {
            LoginPage loginPage = new LoginPage();
            mainPage = loginPage.login(USER_NAME, PASSWORD);
        }
    }

    @Test
    public void testCanSearchDriver() throws InterruptedException {
        mainPage.searchDriver(INPUT_SEARCH_TEXT, DRIVER_TO_BE_FOUND, activityTestRule)
                .shouldBeFound(DRIVER_TO_BE_FOUND)
                .callToDriver();
    }

}
