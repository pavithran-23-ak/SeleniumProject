package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExceptionPage extends BasePage{
    private By addButtonLocator = By.id("add_btn");
    private By row2InputField = By.xpath("//div[@ id='row2']/input");
    private By row2SaveButton = By.xpath("//div[@ id='row2']/button[@name='Save']");
    private By successMessage = By.id("confirmation");
    private By editButtonLocator = By.xpath("//div[@id='row1']/button[@name='Edit']");
    private By row1InputField = By.xpath("//div[@id='row1']/input");
    private By row1SaveButton = By.xpath("//div[@id='row1']/button[@name='Save']");
    private By instructionMessage = By.id("instruction");


    public ExceptionPage(WebDriver driver){
        super(driver);
    }
    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }
    public void pushAddButton(){
        driver.findElement(addButtonLocator).click();

    }
    public boolean isRow2IsDisplayedAfterWait(){
      return waitIsDisplayed(row2InputField);
    }
    public void enterFoodInRow2(String name){
        driver.findElement(row2InputField).sendKeys(name);
    }
    public void saveRow2(){
        driver.findElement(row2SaveButton).click();
    }
    public String getSuccessMessage(){
        return waitForElement(successMessage).getText();
    }
    public void pushEditButton(){
        driver.findElement(editButtonLocator).click();
    }
    public void enterFoodInRow1(String name1){
        driver.findElement(row1InputField).clear();
        driver.findElement(row1InputField).sendKeys(name1);
    }
    public void saveRow1(){
        driver.findElement(row1SaveButton).click();
    }
    public Boolean isInstructionElementHiddenAfterWait(){
        return waitForIsHidden(instructionMessage);
    }
}
