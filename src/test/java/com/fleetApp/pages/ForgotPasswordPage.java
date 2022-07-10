package com.fleetApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class ForgotPasswordPage {

    @FindBy(id = "prependedInput")
    public WebElement forgotPasswordInput;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement warningMessage;

}
