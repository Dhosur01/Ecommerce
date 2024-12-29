package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class SignupPage {
    WebDriver driver;

    By signupLink = By.id("signin2");
    By username = By.id("sign-username");
    By password = By.id("sign-password");
    By signupBtn = By.xpath("//button[text()='Sign up']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupLink() {
        WebElement element = driver.findElement(signupLink);
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

    public void clickSignupButton() {
        WebElement element = driver.findElement(signupBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void handleAlert() {
        try {
            Thread.sleep(3000); // Wait for the alert to appear
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
