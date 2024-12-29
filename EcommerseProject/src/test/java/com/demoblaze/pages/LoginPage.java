package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By loginLink = By.linkText("Log in");
    By username = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginBtn = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        WebElement element = driver.findElement(loginLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void enterUsername(String user) {
        WebElement element = driver.findElement(username);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + user + "';", element);
    }

    public void enterPassword(String pass) {
        WebElement element = driver.findElement(password);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + pass + "';", element);
    }

    public void clickLoginButton() {
        WebElement element = driver.findElement(loginBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
