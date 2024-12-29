package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
    WebDriver driver;

    By logoutLink = By.id("logout2");

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}
