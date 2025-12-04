package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    private By usernameInputLocater = By.id("username");
    private By passwordInputLocater = By.id("password");
    private By submitButtonLocater = By.id("submit");
    private By errorMessageLocater = By.id("error");


    public LoginPage(WebDriver driver){
       super(driver);
    }
    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-login/");
    }
    public void enterUsername(String username){
        driver.findElement(usernameInputLocater).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInputLocater).sendKeys(password);
    }
    public void clickSubmitButton(){
        driver.findElement(submitButtonLocater).click();
    }
    public SuccessfulLoginPage excuteLogin(String username, String password){
       enterUsername(username);
       enterPassword(password);
       clickSubmitButton();
       return new SuccessfulLoginPage(driver);
    }
    public String getErrorMessage(){
       WebElement errorMessageElement = waitForElement(errorMessageLocater);
       return errorMessageElement.getText();
    }
}
