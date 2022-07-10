package com.fleetApp.step_definitions;

import com.fleetApp.pages.ForgotPasswordPage;
import com.fleetApp.pages.LogOutPage;
import com.fleetApp.pages.Login2and3Page;
import com.fleetApp.utilities.ConfigurationReader;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.Set;

public class LoginSteps {

    Login2and3Page login2and3Page = new Login2and3Page();

    LogOutPage logOutPage = new LogOutPage();

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    String copiedUrl = "";
    Set<Cookie> coockies = new HashSet<>();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        login2and3Page.goLoginPage();
    }
    @When("The user logs in as a {string}")
    public void the_user_logs_in_as_a(String string) {
        login2and3Page.loginAsUserType(string);
        login2and3Page.waitUntilLoaderScreenDisappear();
    }
    @Then("The user is on the {string} page")
    public void the_user_is_on_the_page(String string) {
        String currentTitle = login2and3Page.getPageTitle();
        Assert.assertEquals(string,currentTitle);
    }







    @When("the user logs in as {string}")
    public void the_user_logs_in_as(String string) {
        login2and3Page.loginAsUserType(string);
    }
    @When("the user copy the current url")
    public void the_user_copy_the_current_url() {
        copiedUrl= Driver.get().getCurrentUrl();
        System.out.println(copiedUrl);

    }

    @Then("the user clicks on logout button")
    public void the_user_clicks_on_logout_button() {
        logOutPage.userNameBtn.click();
        logOutPage.logOutBtn.click();
    }
    @Then("the user goes to copied url")
    public void the_user_goes_to_copied_url() {
        Driver.get().get(copiedUrl);
    }
    @Then("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String string) {
        String currentTitle = login2and3Page.getPageTitle();

        Assert.assertEquals(string,currentTitle);
    }


    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        //login2and3Page.goLoginPage();
        login2and3Page.loginWithCredentials(username,password);

    }
    @Then("user should see warning message {string}")
    public void user_should_see_warning_message(String string) {
        String actualWarningMessage = login2and3Page.warningMessage.getText();
        System.out.println(actualWarningMessage);
        Assert.assertEquals(string,actualWarningMessage);
    }


    @Then("User should see warning message {string} in {string}")
    public void userShouldSeeWarningMessageIn(String validationMessage, String field) {
        Assert.assertEquals(validationMessage,login2and3Page.errorMessageText(field));

    }



    @When("user enters any {string} in password field")
    public void user_enters_any_in_password_field(String string) {
       login2and3Page.passwordField.sendKeys(string);
    }



    @Then("user should see the bullet sign in field")
    public void user_should_see_the_bullet_sign_in_field(){

        String attributeText = login2and3Page.passwordField.getAttribute("type");

        System.out.println("attributeText = " + attributeText);
        Assert.assertTrue(attributeText.equals("password"));

    }


    @When("user clicks Forgot your password? link")
    public void user_clicks_forgot_your_password_link() {
        login2and3Page.forgotPassword.click();

    }
    @When("user is on {string} page")
    public void user_is_on_page(String string) {
        String currentTitle = Driver.get().getTitle();
        Assert.assertEquals(currentTitle,"Forgot Password");
    }

    @Then("user enters valid {string}")
    public void user_enters_valid(String string) {
       forgotPasswordPage.forgotPasswordInput.sendKeys(string);

    }
    @Then("user should be able to change their password")
    public void user_should_be_able_to_change_their_password() {
        Assert.assertFalse(forgotPasswordPage.warningMessage.isDisplayed());
    }



    @When("User clicks Remember me on this computer checkbox")
    public void user_clicks_remember_me_on_this_computer_checkbox() {
      login2and3Page.rememberMeCheckBox.click();
    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        login2and3Page.loginWithCredentials(username,password);
    }

    @Then("User closes the page then open it again")
    public void userClosesThePageThenOpenItAgain() {
        ((JavascriptExecutor) Driver.get()).executeScript("window.open('https://www.google.com', 'new_window')");
        Driver.get().close();
        Driver.get().switchTo().window("new_window");
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("User should be able to login on this computer")
    public void user_should_be_able_to_login_on_this_computer() {
        String currentTitle = Driver.get().getTitle();
        login2and3Page.waitUntilLoaderScreenDisappear();
        Assert.assertEquals(currentTitle,"Dashboard");
    }

    @When("user enters the {string} and press Enter key")
    public void userEntersTheAndPressEnterKey(String username) {
        login2and3Page.usernameField.sendKeys(username+ Keys.ENTER);
    }


    @Then("user enters {string} and press Enter key")
    public void userEntersAndPressEnterKey(String password) {
        login2and3Page.passwordField.sendKeys(password + Keys.ENTER);
        login2and3Page.waitUntilLoaderScreenDisappear();

    }


    @Then("user should see their {string} in the top right corner")
    public void user_should_see_their_in_the_top_right_corner(String string) {
        String currentUsername = logOutPage.userNameBtn.getText();
        System.out.println("currentUsername = " + currentUsername);
        Assert.assertEquals(string,currentUsername);
    }



}
