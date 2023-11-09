package API.stepDefinitions.Aidar;

import API.stepDefinitions.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CreateAndDeleteStepDefin extends BaseTest {
    @Given("perform POST method to create max amount new users with mock Data")
    public void perform_post_method_to_create_max_amount_new_users_with_mock_data() {
        try {
            usersMethods.createMaxUser();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("status {int} created users and {int} status code returned")
    public void status_created_users_and_status_code_returned(Integer amountOfUsers, Integer statusCode) {
        try {
            Assertions.assertEquals(amountOfUsers, usersPOJO.getAmountOfUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assertions.assertEquals(statusCode, usersMethods.createMaxUser().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("perform POST method to delete all users")
    public void perform_post_method_to_delete_all_users() {
        try {
            usersMethods.deletesAllUsers();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("must be {int} user and {int} status code returned")
    public void must_be_user_and_status_code_returned(Integer amountOfUsers, Integer statusCode) {
        try {
            Assertions.assertEquals(amountOfUsers, usersPOJO.getAmountOfUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assertions.assertEquals(statusCode, usersMethods.deletesAllUsers().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
