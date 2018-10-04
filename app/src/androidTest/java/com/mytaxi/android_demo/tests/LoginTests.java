package com.mytaxi.android_demo.tests;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginTests extends BaseTest {
    
    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Before
    public void logoutIfLoggedIn() {
        if (mainPage.isPageOpen()) {
            mainPage.navigateToActivityChoice().logout();
        }
    }

    @Test
    public void testCanLoginWithValidCredentials() {
        loginPage.login(USER_NAME, PASSWORD)
                .navigateToActivityChoice()
                .shouldDisplayUserName(USER_NAME);
    }

}
