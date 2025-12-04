package com.practicetestautomation.tests.login;

import com.practicetestautomation.pageobjects.LoginPage;
import com.practicetestautomation.pageobjects.SuccessfulLoginPage;
import com.practicetestautomation.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginTests extends BaseTest {

    @Test (groups = {"positive","regression","smoke"})
    public void testLoginFunctionality(){
        logger.info("Starting testLoginFunctionality");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        SuccessfulLoginPage successfulLoginPage =loginPage.excuteLogin("student","Password123");
        successfulLoginPage.load();
        logger.info("Verify login functionalitity");
        Assert.assertEquals(successfulLoginPage.getCurrentUrl(),"https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertTrue(successfulLoginPage.getPageSource().contains("Congratulations student. You successfully logged in!"));
        Assert.assertTrue(successfulLoginPage.isLogoutButtonDisplayed());
    }

    @Parameters({"username","password","expectedErrorMessage"})
    @Test (groups = {"negative","regression"})
    public void negativeLoginTest(String username, String password, String expectedErrorMessage){
        logger.info("Starting negativeLoginTest");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.excuteLogin(username,password);
        loginPage.getErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage);
    }
}
