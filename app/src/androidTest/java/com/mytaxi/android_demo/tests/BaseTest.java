package com.mytaxi.android_demo.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import com.mytaxi.android_demo.activities.MainActivity;
import com.mytaxi.android_demo.pages.LoginPage;
import com.mytaxi.android_demo.pages.MainPage;

import org.junit.Rule;

public class BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    static final String USER_NAME = "crazydog335";
    static final String PASSWORD = "venture";

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule
            .grant(android.Manifest.permission.ACCESS_FINE_LOCATION);

}
