package com.fleetApp.step_definitions;

import com.fleetApp.pages.LogOutPage;
import com.fleetApp.pages.Login2and3Page;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    Login2and3Page login2and3Page = new Login2and3Page();

    LogOutPage logOutPage = new LogOutPage();

    String copiedUrl = "";

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
        String actualWarningMessage = login2and3Page.WarningMessage.getText();
        System.out.println(actualWarningMessage);
        Assert.assertEquals(string,actualWarningMessage);
    }






}
