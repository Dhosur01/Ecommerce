package com.demoblaze.tests;

import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.Logout;
import com.demoblaze.pages.SignupPage;

public class EcommerseTest {
    WebDriver driver;
    SignupPage signupPage;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    Logout logoutPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\klaks\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe"); // Update the path as per your system
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new EdgeDriver(options);
        driver.get("https://www.demoblaze.com/");
        signupPage = new SignupPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        logoutPage = new Logout(driver);
    }

    @Test
    public void testEcommerseFlow() {
        String randomUsername = "user" + UUID.randomUUID().toString().substring(0, 8);
        String randomPassword = "pass" + UUID.randomUUID().toString().substring(0, 8);

        try {
            // Signup
            signupPage.clickSignupLink();
            signupPage.enterUsername(randomUsername);
            signupPage.enterPassword(randomPassword);
            signupPage.clickSignupButton();
            signupPage.handleAlert();

            // Wait for signup modal to disappear
            Thread.sleep(3000);

            // Login
            loginPage.clickLoginLink();
            Thread.sleep(3000);
            loginPage.enterUsername(randomUsername);
            loginPage.enterPassword(randomPassword);
            loginPage.clickLoginButton();
            handleAlert();

            // Add laptop to cart
            homePage.clickLaptopsCategory();
            Thread.sleep(3000);
            homePage.clickFirstLaptop();
            Thread.sleep(3000);
            homePage.clickAddToCart();
            handleAlert(); // Handling popup

            // Place order
            homePage.clickCartLink();
            Thread.sleep(3000);
            cartPage.clickPlaceOrder();
            cartPage.enterDetails("John Doe", "USA", "New York", "1234567890", "12", "2025");
            cartPage.clickPurchase();
            cartPage.handleOrderAlert(); // Handle order alert

            // Click OK in the pop-up after placing the order
            cartPage.clickOkButton();
            
            // Logout
            logoutPage.clickLogout();
        } catch (UnhandledAlertException e) {
            handleAlert(); // Handling unexpected alert
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
            System.out.println("Element not interactable: " + e.getMessage());
        }
    }

    private void handleAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            // No alert to handle
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


