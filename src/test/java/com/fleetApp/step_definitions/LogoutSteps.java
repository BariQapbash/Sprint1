package com.fleetApp.step_definitions;

import com.fleetApp.pages.ForgotPasswordPage;
import com.fleetApp.pages.LogOutPage;
import com.fleetApp.pages.Login2and3Page;
import com.fleetApp.utilities.BrowserUtils;
import com.fleetApp.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogoutSteps {

    Login2and3Page login2and3Page = new Login2and3Page();

    LogOutPage logOutPage = new LogOutPage();

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    String copiedUrl = "";


    @Given("user is on the Dashboard page")
    public void user_is_on_the_dashboard_page() {
        login2and3Page.goLoginPage();
        login2and3Page.loginAsUserType("Store Manager");
        login2and3Page.waitUntilLoaderScreenDisappear();

    }

    @When("user clicks on profile dropdown")
    public void user_clicks_on_profile_dropdown() {
       logOutPage.userNameBtn.click();
    }

    @And("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        logOutPage.logOutBtn.click();
    }

    @Then("user is on the login page")
    public void user_is_on_the_login_page() {
        String currentTitle = Driver.get().getTitle();
        Assert.assertEquals("Login", currentTitle);
    }


    @Then("user clicks on step back button on the browser")
    public void user_clicks_on_step_back_button_on_the_browser() {
       Driver.get().navigate().back();
    }
    @Then("user should be still on the login page")
    public void user_should_be_still_on_the_login_page() {
        String currentTitle = Driver.get().getTitle();
        Assert.assertEquals("Login", currentTitle);
    }

    @When("user copied current url")
    public void user_copied_current_url() {
        copiedUrl = Driver.get().getCurrentUrl();
    }
    @When("user close the browser")
    public void user_close_the_browser() {
      Driver.closeDriver();
    }
    @Then("user open new page with copied url")
    public void user_open_new_page_with_copied_url() {
        Driver.get().get(copiedUrl);
    }


    @When("user away from keyboard for {int} minutes")
    public void user_away_from_keyboard_for_minutes(Integer int1) {
        BrowserUtils.sleep(180);
    }
    @Then("user should be logout automatically")
    public void user_should_be_logout_automatically() {
        String currentTitle = Driver.get().getTitle();
        Assert.assertEquals("Login", currentTitle);
    }

}
