import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Objects;

public class CreateUserTest {

    @Test
    void CreateNewUserTest() {


        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest";
        RequestSpecification httpRequest = RestAssured.given();
        int[] companies = {34, 35};

        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "test42@gmail.com");
        requestParams.put("name", "Anon");
        requestParams.put("tasks", 1);
        requestParams.put("companies", companies);
        requestParams.put("hobby", "hockey");
        requestParams.put("adres", "T-street, 24");
        requestParams.put("name1", "Anonymous");
        requestParams.put("surname1", "Black");
        requestParams.put("fathername1", "Jackson");
        requestParams.put("cat", "Patty");
        requestParams.put("dog", "Stan");
        requestParams.put("cavy", "Toy");
        requestParams.put("hamster", "Jarry");
        requestParams.put("squirrel", "Tobby");
        requestParams.put("phone", "333 33 33");
        requestParams.put("inn", "123456789012");
        requestParams.put("gender", "m");
        requestParams.put("date_start", "11.11.2012");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/createuser");

        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body is: " + responseBody);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        int statusCode = response.statusCode();
        System.out.println("Status Code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);



    }
}
