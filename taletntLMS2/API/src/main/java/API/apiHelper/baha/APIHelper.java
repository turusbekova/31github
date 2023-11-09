package API.apiHelper.baha;

import API.dataProviders.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

    private static RequestSpecification authURIPATH(String endPoint) {
    RequestSpecification requestSpecification = RestAssured.given();
    requestSpecification.auth()
            .basic(ConfigReader.getProperty("userNameAPI"), ConfigReader.getProperty("passwordAPI"))
            .baseUri(ConfigReader.getProperty("baseUri"))
            .basePath(ConfigReader.getProperty("basePath") + endPoint);
    return requestSpecification;
}

    public static RequestSpecification preRequest(String endPoint, ContentType contentType, ContentType accept) {
        return authURIPATH(endPoint)
                .contentType(contentType).accept(accept);
    }


    public static String requestWithQueryParams(String endPoint, String key, String value, ContentType contentType, ContentType accept, Method method) {
        return preRequest(endPoint, contentType, accept)
                .queryParam(key, value)
                .request(method).getBody().asPrettyString();
    }

    public static <T> Response requestWithBody(String endPoint, T body, ContentType contentType, ContentType accept, Method method) {
        return preRequest(endPoint, contentType, accept)
                .body(body)
                .request(method);
    }


    public static String getJSON(String endPoint, Method method) {
        return preRequest(endPoint, ContentType.JSON, ContentType.JSON)
                .request(method).asPrettyString();
    }
}
