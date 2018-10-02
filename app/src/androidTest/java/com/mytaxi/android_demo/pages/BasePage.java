package com.mytaxi.android_demo.pages;

import com.mytaxi.android_demo.exceptions.PageNotOpenException;

public interface BasePage {

    void isPageOpen() throws PageNotOpenException;
}
