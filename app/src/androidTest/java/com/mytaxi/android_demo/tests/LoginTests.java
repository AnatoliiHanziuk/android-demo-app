package com.mytaxi.android_demo.tests;

import android.support.test.runner.AndroidJUnit4;
import com.mytaxi.android_demo.pages.LoginPage;
import com.mytaxi.android_demo.pages.MainPage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginTests extends BaseTest {
    
    private LoginPage loginPage;

    @Before
    public void logoutIfLoggedIn() {
        MainPage mainPage = new MainPage();
        if (mainPage.isPageOpen()) {
            mainPage.navigateToActivityChoice().logout();
        } else {
            loginPage = new LoginPage();
        }
    }

    @Test
    public void testCanLoginWithValidCredentials() {
        loginPage.login(USER_NAME, PASSWORD)
                .navigateToActivityChoice()
                .shouldDisplayUserName(USER_NAME);
    }

}
