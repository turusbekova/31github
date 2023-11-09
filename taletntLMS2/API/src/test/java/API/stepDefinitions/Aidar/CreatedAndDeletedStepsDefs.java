package API.stepDefinitions.Aidar;

import API.methodsPOM.aidar.UsersMethods;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatedAndDeletedStepsDefs{
    protected UsersMethods userMethods = new UsersMethods();
    @When("admin created {int} Users and see all {int} statuses codes")
    public void admin_created_users_and_see_all_statuses_codes(Integer amountOfUsers, Integer statusCode) {
        try {
            userMethods.createMaxUser();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("admin need to deleted all Users, which was created")
    public void admin_need_to_deleted_all_users_which_was_created() {
        try {
            userMethods.deletesAllUsers();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
