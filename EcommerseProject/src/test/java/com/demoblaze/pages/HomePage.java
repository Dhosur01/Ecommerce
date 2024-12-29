package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {
    WebDriver driver;

    By laptopsCategory = By.linkText("Laptops");
    By firstLaptop = By.linkText("Sony vaio i5"); // Example laptop
    By addToCartBtn = By.xpath("//a[text()='Add to cart']");
    By cartLink = By.id("cartur");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLaptopsCategory() {
        WebElement element = driver.findElement(laptopsCategory);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickFirstLaptop() {
        WebElement element = driver.findElement(firstLaptop);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickAddToCart() {
        WebElement element = driver.findElement(addToCartBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickCartLink() {
        WebElement element = driver.findElement(cartLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
