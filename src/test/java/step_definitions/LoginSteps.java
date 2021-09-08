package step_definitions;

import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By login = By.id("login");
    private static final By Logout = By.id("logout");
    private static final By InvalidPassword = By.xpath("//*[@id='pageLogin']/form/div//div[text()='Password is invalid']");
    private static  Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver ;

    @Given("^a user is on the login page$")
    public void navigateToLoginPage() {
        ActOn.browser(driver).openBrowser("https://example.testproject.io/web/");
        LOGGER.info("user is on the login page");
    }
    @When("^user enters username \"(.+?)\" and password\"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
        ActOn.element(driver,FullName).setValue(username);
        ActOn.element(driver,Password).setValue(password);
        LOGGER.info("user has entered credentials");
    }
    @And("^click on the login button$")
    public void clickOnLogin() {
        ActOn.element(driver,login).click();
        LOGGER.info("user clicked on login button");
    }
    @Then("^user is navigate to home page$")
    public void validateLoginSuccessfully() {
        boolean logoutDisplayed = driver.findElement(Logout).isDisplayed();
        Assert.assertTrue("logout button is not displayed", logoutDisplayed);
        LOGGER.info("user is on the homepage");
    }

    @Then("^user is failed to login$")
    public void validateUserIsFailedToLogin() {
        boolean invalidpassword1 = driver.findElement(InvalidPassword).isDisplayed();
        Assert.assertTrue("Invalid password is not displayed", invalidpassword1);
        LOGGER.info("user is still on the homepage");
    }


    @When("^user click on login button upon entering credentials$")
    public void userClickOnLoginButtonUponEnteringCredentials(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (Map<String,String> cells:dataTable){
            ActOn.element(driver,FullName).setValue(cells.get("username"));
            ActOn.element(driver,Password).setValue(cells.get("password"));
            LOGGER.info("Users has entered credentials");

            ActOn.element(driver,login).click();
            LOGGER.info("User clicked on login button");
        }
    }
}
