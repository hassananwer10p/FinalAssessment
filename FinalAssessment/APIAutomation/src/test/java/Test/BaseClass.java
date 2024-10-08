package Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;

public class BaseClass {

    // Token variable to hold the authentication token for API requests
    public static String token;

    // Base path for files used in the API tests
    public static final String File_Base_Path = "./src/main/resources/";
    // Path for the authentication file
    public static final String Auth_File = File_Base_Path + "auth.txt";

    // Method to set up the RestAssured configurations before each test method
    @BeforeMethod
    public void setup() {
        // Enable logging of request and response details if validation fails
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        // Set the base URI for the API requests
        RestAssured.baseURI = "https://app.respond.io";
    }

    // Method to handle the login flow and retrieve an authentication token
    public String loginFlow() {
        try {
            // Read the authentication body from the auth file
            String authBody = FileUtils.readFileToString(new File(Auth_File), "UTF-8");
            // Send a POST request to log in and retrieve the token
            Response response = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(authBody)
                    .when()
                    .post("/auth/login")
                    .then().log().all()
                    .assertThat()
                    .statusCode(200) // Assert that the response status code is 200
                    .body("message", equalTo("Login successful")) // Assert the success message
                    .extract().response();
            // Extract the token from the response
            String token = response.jsonPath().getString("data.idToken");
            System.out.println("Token: " + token); // Print the token for validation

            return token; // Return the extracted token
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for debugging
            throw new RuntimeException("Failed to read auth file or login", e); // Rethrow as a runtime exception
        }
    }

    // Inner class for generating random email addresses
    public static class RandomEmailGenerator {
        // Array of email domains to be used for generating random emails
        private static final String[] DOMAINS = {
                "tempmailto.org", "gmail.com", "yahoo.com", "hotmail.com"
        };

        // Method to generate a random email address
        public static String generateRandomEmail() {
            Random random = new Random();
            // Create a random string based on the current time and a random integer
            String randomString = Long.toString(System.currentTimeMillis()) + random.nextInt(1000);
            // Randomly select a domain from the DOMAINS array
            String domain = DOMAINS[random.nextInt(DOMAINS.length)];
            // Return the generated email address
            return randomString + "@" + domain;
        }
    }
}
