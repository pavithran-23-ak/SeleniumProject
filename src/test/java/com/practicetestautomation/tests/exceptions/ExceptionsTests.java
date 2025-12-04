package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageobjects.ExceptionPage;
import com.practicetestautomation.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExceptionsTests extends BaseTest {
    @Test
    public void noSuchElementExceptionTest(){
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();
        Assert.assertTrue(exceptionPage.isRow2IsDisplayedAfterWait(),"Row 2 input field is not displayed");
    }
    @Test
    public void timeoutExceptionTest(){
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();
        Assert.assertTrue(exceptionPage.isRow2IsDisplayedAfterWait(),"Row 2 input field is not displayed");
    }
    @Test
    public void elementNotInteractableException(){
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushAddButton();
        exceptionPage.isRow2IsDisplayedAfterWait();
        exceptionPage.enterFoodInRow2("burger");
        exceptionPage.saveRow2();
        Assert.assertEquals(exceptionPage.getSuccessMessage(),"Row 2 was saved","Message is not expected");
        }
        @Test
    public void invalidElementStateExceptionTest() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushEditButton();
        exceptionPage.enterFoodInRow1("Sushi");
        exceptionPage.saveRow1();
        Assert.assertEquals(exceptionPage.getSuccessMessage(),"Row 1 was saved","Message is not expected");
    }
        @Test
    public void staleElementReferenceExceptionTest() {
        ExceptionPage exceptionPage = new ExceptionPage(driver);
        exceptionPage.visit();
        exceptionPage.pushEditButton();
        Assert.assertTrue(exceptionPage.isInstructionElementHiddenAfterWait(), "Instruction is still shown");
    }

}
