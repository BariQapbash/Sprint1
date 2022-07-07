package com.fleetApp.pages;

import com.fleetApp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

    public LogOutPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(xpath = "//*[text()='Logout']")
    public WebElement logOutBtn;

    @FindBy(xpath = "//a[@href='javascript: void(0);']")
    public WebElement userNameBtn;

}
