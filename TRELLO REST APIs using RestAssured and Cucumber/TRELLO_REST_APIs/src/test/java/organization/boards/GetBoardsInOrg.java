package organization.boards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import property.PropertyFile;

import static org.testng.Assert.assertEquals;

public class GetBoardsInOrg {

    public static void main(String[] args) {

        String key = "0a7fe27ba0a93ea2142416db3971d4c2";
        String token = "ATTAf6197bbc2a0df575a30285595d5c0fdd10d2085f5c54efb6a6db490420ee9e36C81E73B7";
        PropertyFile pf = new PropertyFile();
        String orgID = pf.readFromPropFile("OrgID");

        Response response = RestAssured.given().baseUri("https://api.trello.com/1/organizations/"+orgID+"/boards").queryParam("key", key).queryParam("token", token).header("Content-Type", "application/json").when().get();

        JsonPath path = response.jsonPath();
        String orgId = path.getString("[0].idOrganization");

        assertEquals(orgId, orgID);
        assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();
    }
}
