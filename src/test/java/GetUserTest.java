import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserTest {

    @Test
    public void getUserDataTest() {

        RestAssured.baseURI = "http://users.bugred.ru/tasks/rest";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/getuser");

        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response body is: " + responseBody);
        if (responseBody.contains("success")) {
            Assert.assertTrue(true);
        }else
            Assert.assertFalse(false);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
