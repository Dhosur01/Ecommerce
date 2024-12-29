package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class CartPage {
    WebDriver driver;

    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By name = By.id("name");
    By country = By.id("country");
    By city = By.id("city");
    By creditCard = By.id("card");
    By month = By.id("month");
    By year = By.id("year");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");
    By okBtn = By.xpath("/html/body/div[10]/div[7]/div/button"); // XPath for the "OK" button in the pop-up alert

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPlaceOrder() {
        WebElement element = driver.findElement(placeOrderBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void enterDetails(String customerName, String customerCountry, String customerCity, String customerCard, String customerMonth, String customerYear) {
        setInputField(name, customerName);
        setInputField(country, customerCountry);
        setInputField(city, customerCity);
        setInputField(creditCard, customerCard);
        setInputField(month, customerMonth);
        setInputField(year, customerYear);
    }

    private void setInputField(By locator, String value) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
    }

    public void clickPurchase() {
        WebElement element = driver.findElement(purchaseBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickOkButton() {
        try {
            Thread.sleep(3000); // Wait for the alert to appear
            WebElement element = driver.findElement(okBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void handleOrderAlert() {
        try {
            Thread.sleep(3000); // Wait for the alert to appear
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
