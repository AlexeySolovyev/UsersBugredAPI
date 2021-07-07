import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreateCompanyTest {

    @Test
    public void CreateNewCompanyTest() {

        RestAssured.baseURI = "http://users.bugred.ru/task/rest";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("company_name", "Autocomplete");
        requestParams.put("company_type", "LLC");
        requestParams.put("company users", "[test24@gmail.com]");
        requestParams.put("email_owner", "test24@gmail.com");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/createcompany");

        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response body is: " + responseBody);

        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        int statusCode = response.statusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}
