package organization.boards.lists;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import property.PropertyFile;

import static org.testng.Assert.assertEquals;

public class CreateNewList {

    public static void main(String[] args) {

        String key = "0a7fe27ba0a93ea2142416db3971d4c2";
        String token = "ATTAf6197bbc2a0df575a30285595d5c0fdd10d2085f5c54efb6a6db490420ee9e36C81E73B7";
        PropertyFile pf = new PropertyFile();
        String boardID = pf.readFromPropFile("BoardID");

        Response response = RestAssured.given().baseUri("https://api.trello.com/1/lists").queryParam("name", "New List").queryParam("idBoard", boardID).queryParam("key", key).queryParam("token", token).header("Content-Type", "application/json").when().post();

        JsonPath path = response.jsonPath();
        String listId = path.getString("id");
        String boardId = path.getString("idBoard");

        pf.writeToPropFile("ListID", listId);

        assertEquals(boardId, boardID);
        assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();
    }
}
