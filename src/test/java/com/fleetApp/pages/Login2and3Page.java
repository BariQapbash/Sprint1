package com.fleetApp.pages;

import com.fleetApp.utilities.ConfigurationReader;
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
    public WebElement WarningMessage;





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
