import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetFullUserTest {

    @Test
    public void getFullUserDataTest() {

        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "test24@gmail.com");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());


        Response response = httpRequest.request(Method.GET, "/getuserfull");

        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response body is: " + responseBody);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
