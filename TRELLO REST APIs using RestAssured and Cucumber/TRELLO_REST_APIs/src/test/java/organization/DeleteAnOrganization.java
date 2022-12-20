package organization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import property.PropertyFile;

import static org.testng.Assert.assertEquals;

public class DeleteAnOrganization {

    public static void main(String[] args) {

        String key = "0a7fe27ba0a93ea2142416db3971d4c2";
        String token = "ATTAf6197bbc2a0df575a30285595d5c0fdd10d2085f5c54efb6a6db490420ee9e36C81E73B7";
        PropertyFile pf = new PropertyFile();
        String orgId = pf.readFromPropFile("OrgID");

        Response response = RestAssured.given().baseUri("https://api.trello.com/1/organizations/"+orgId).queryParam("key", key).queryParam("token", token).header("Content-Type", "application/json").when().delete();

        assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();
    }
}
