package Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

import java.io.File;
import java.io.IOException;

public class UsersAPI extends BaseClass {

    // Base path for files used in the API tests
    public static final String File_Base_Path = "./src/main/resources/";
    // Paths for specific files
    public static final String Invite_File = File_Base_Path + "invite.txt";
    public static final String Workspace_File = File_Base_Path + "workspace.txt";

    // Variables to hold organization ID, token, and bot ID
    private String orgId;
    private String token;
    private String botId;

    // Test to set up the authentication token before other tests
    @Test(priority = 1)
    public void setupToken() throws IOException {
        token = loginFlow();  // This method sets the token if not already set
    }

    // Test to retrieve organization details and store the orgId
    @Test(priority = 2)
    public void getOrganization() {
        Response response = RestAssured.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + token).log().all()
                .get("/auth/user/organizations")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("status", equalTo("success"))
                .body("message", equalTo("Organizations successfully fetched"))
                .extract().response();

        // Extract the organization ID from the response
        orgId = response.jsonPath().getList("data.id").get(0).toString();
        System.out.println("orgId is " + orgId);
        System.out.println("Response Body: " + response.getBody().asString());
    }

    // Test to retrieve spaces associated with the organization and store the botId
    @Test(priority = 3)
    public void getSpaces() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .header("orgId", orgId)
                .when()
                .get("/auth/user/spaces")
                .then().log().all()
                .assertThat().statusCode(200)
                .body("status", equalTo("success"))
                .body("message", equalTo("Workspaces successfully fetched"))
                .body("data.id", hasSize(greaterThan(0)))
                .body("data.orgid", hasSize(greaterThan(0)))
                .extract().response();

        // Extract the bot ID from the response and ensure it is not null
        botId = response.jsonPath().getList("data.id").get(0).toString();
        Assert.assertNotNull(botId, "Bot ID should not be null.");
        System.out.println("botId is " + botId);
        System.out.println("Response Body: " + response.getBody().asString());
    }

    // Test to invite a client using the invite file with a randomly generated email
    @Test(priority = 4)
    public void inviteClient() throws IOException {
        // Generate a random email for inviting a client
        String randomEmail = RandomEmailGenerator.generateRandomEmail();

        // Read the existing content from the invite file
        String authBody = FileUtils.readFileToString(new File(Invite_File), "UTF-8");

        // Replace the existing email in the content with the randomly generated email
        authBody = authBody.replaceAll("\"email\":\"[^\"]*\"", "\"email\":\"" + randomEmail + "\"");

        // Make the API request with the modified body
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(authBody)
                .header("Authorization", "Bearer " + token).log().all()
                .header("orgId", orgId)
                .header("botId", botId)
                .when()
                .post("/workspace/collaborator/invite")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .body("status", equalTo("success"))
                .body("message", equalTo("User has been invited to workspace"))
                .extract().response();
    }

    // Test to delete spaces associated with the organization and bot
    @Test(priority = 5)
    public void deleteSpaces() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .pathParam("orgId", orgId)
                .pathParam("botId", botId)
                .when()
                .delete("/organization/{orgId}/spaces/{botId}")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    // Test to create new spaces using the workspace file
    @Test(priority = 6)
    public void createSpaces() throws IOException {
        // Read the existing content from the workspace file
        String authBody = FileUtils.readFileToString(new File(Workspace_File), "UTF-8");

        // Make the API request to create spaces with the read content
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(authBody)
                .header("Authorization", "Bearer " + token).log().all()
                .pathParam("orgId", orgId)
                .when()
                .post("/organization/{orgId}/spaces/create")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract().response();
    }
}
