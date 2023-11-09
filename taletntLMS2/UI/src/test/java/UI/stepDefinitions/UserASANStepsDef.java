package UI.stepDefinitions;


import UI.dataProviders.ConfigReader;
import UI.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import UI.stepDefinitions.BaseStep;

public class UserASANStepsDef extends BaseStep {
    @When("Admin click on Users div button")
    public void admin_click_on_users_div_button() {
        addUser.adminClickOnUserButton();
        throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see {string} header text")
    public void admin_should_see_header_text(String string) {

    }

    @Given("admin into the system")
    public void adminIntoTheSystem() {
        Driver.getDriver().get(ConfigReader.getProperty("environment"));
        loginPage.loginToSystem();
    }

    @Then("Admin test API")
    public void adminTestAPI() {
    }

}
