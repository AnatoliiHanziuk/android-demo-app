package com.mytaxi.android_demo.pages;

import com.mytaxi.android_demo.R;
import com.mytaxi.android_demo.exceptions.PageNotOpenException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.mytaxi.android_demo.utils.AssertionUtils.isElementDisplayed;

public class LoginPage implements BasePage {
    private static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);

    private static final int USER_NAME_FIELD_ID = R.id.edt_username;
    private static final int USER_PASSWORD_FIELD_ID = R.id.edt_password;
    private static final int LOGIN_BUTTON_ID = R.id.btn_login;

    public LoginPage() {
        try {
            isPageOpen();
        } catch (PageNotOpenException e) {
            e.printStackTrace();
        }
    }

    public MainPage login(String userName, String password) {
        LOG.info("Logging in a user with name {} and password {}", userName, password);
        onView(withId(USER_NAME_FIELD_ID)).perform(typeText(userName));
        onView(withId(USER_PASSWORD_FIELD_ID)).perform(typeText(password));
        onView(withId(LOGIN_BUTTON_ID)).perform(click());

        return new MainPage();
    }

    @Override
    public void isPageOpen() throws PageNotOpenException {
        try {
            isElementDisplayed(withId(USER_NAME_FIELD_ID));
            isElementDisplayed(withId(USER_PASSWORD_FIELD_ID));
            isElementDisplayed(withId(LOGIN_BUTTON_ID));
            LOG.info("Login page is open");
        } catch (Exception exception) {
            throw new PageNotOpenException("Login Page is not opened");
        }
    }
}
