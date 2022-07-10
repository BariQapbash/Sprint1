package com.fleetApp.pages;

import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login2and3Page extends BasePage {


    //---locators----------------

    @FindBy(id = "prependedInput")
    public WebElement usernameField;

    @FindBy(id = "prependedInput2")
    public WebElement passwordField;

    @FindBy(id = "_submit")
    public WebElement loginBtn;


    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement warningMessage;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public  WebElement rememberMeCheckBox;



    public String errorMessageText(String field) {

        String message = null;

        try {
            if (field.equals("username")) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                message = (String) js.executeScript("return arguments[0].validationMessage;", usernameField);
            } else if (field.equals("password")) {
                JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                message = (String) js.executeScript("return arguments[0].validationMessage;", passwordField);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(message);
        return message;

    }








    //---methods-----------------

    public void goLoginPage(){
        driver.get(ConfigurationReader.get("url"));
    }


    public void loginAsUserType(String userType){

        String password = "";
        String username = "";

        if (userType.equalsIgnoreCase("Driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }
        else if (userType.equalsIgnoreCase("Sales Manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        }
        else if (userType.equalsIgnoreCase("Store Manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }


    public void loginWithCredentials(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }






}
