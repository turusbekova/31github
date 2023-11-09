package API.pojo.aidar;

import API.apiHelper.aidar.APIHelper;
import API.apiHelper.aidar.SDConverter;
import API.dataProviders.ConfigReader;
import API.dataProviders.MockDataGenerator;
import API.dataProviders.URI;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import lombok.Data;

import static API.apiHelper.aidar.APIHelper.requestWithQueryParams;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersPOJO extends MockDataGenerator {
    private String id;
    private String login;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String restrict_email;
    private String user_type;
    private String timezone;
    private String language;
    private String status;
    private String deactivation_date;
    private String level;
    private String points;
    private String created_on;
    private String last_updated;
    private String last_updated_timestamp;
    private String avatar;
    private String bio;
    private String login_key;

    public static String getUserByValue(String value, String key) {
        return requestWithQueryParams(ConfigReader.getProperty("users"), value, key,
                ContentType.JSON, ContentType.JSON, Method.GET);
    }

    public String getJSONUsers() {
        return APIHelper.getJSON(URI.USERS.endpoints, Method.GET);
    }

    public UsersPOJO[] getObjectsOfUsers() {
        try {
            return SDConverter.deserialize(getJSONUsers(), UsersPOJO[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAmountOfUsers() {
        return getObjectsOfUsers().length;
    }

    public void createSomeUsersWithMock(int amountOfUsers) throws JsonProcessingException {

        if (amountOfUsers + getAmountOfUsers() < 5) {
            for (int i = 0; i < amountOfUsers; i++) {
                String json = "";

                UsersPOJO usersPOJO = new UsersPOJO();
                usersPOJO.setFirst_name(generateMockFirstname());
                usersPOJO.setLast_name(generateLastname());
                usersPOJO.setEmail(generateEmail());
                usersPOJO.setLogin(generateEmail());
                usersPOJO.setPassword("Nomad.229e");

                json = SDConverter.serialize(usersPOJO);

                APIHelper.requestWithBody(
                        URI.CREATEUSER.endpoints
                        , json
                        , ContentType.JSON
                        , ContentType.JSON
                        , Method.POST);

            }
        }
        System.out.println("You can create max 5 users, storage of users is: " + getAmountOfUsers() + " users");
    }

    public void deleteUser(int numberOfUser) throws JsonProcessingException {
        if (!(numberOfUser == 0)) {
            UsersPOJO[] usersPOJOS = SDConverter.deserialize(APIHelper
                    .getJSON(URI.USERS.endpoints, Method.GET), UsersPOJO[].class);
            APIHelper.preRequest(URI.DELETEUSER.endpoints
                            , ContentType.JSON
                            , ContentType.JSON)
                    .contentType(ConfigReader.getProperty("multipart"))
                    .multiPart("user_id", usersPOJOS[numberOfUser].getId())
                    .request(Method.POST);
        }
        System.out.println("Change variable \"number of user\" exist \"0\"");
    }
}
