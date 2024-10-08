API Automation
Project Overview
The API Automation project is designed for testing RESTful APIs of Respond.io app using Java and the RestAssured framework. This project includes various test cases to validate API endpoints, authentication flows, and data handling for inviting clients and managing workspaces.

Table of Contents
Requirements
Setup Instructions
Running Tests
Directory Structure
Dependencies
Requirements
Java Development Kit (JDK) 21 or higher
Apache Maven
IDE (e.g., IntelliJ IDEA or Eclipse) with Maven support
Internet connection for API requests
Setup Instructions
Clone the Repository:

bash
Copy code
git clone <repository-url>
cd APIAutomation
Install Maven Dependencies: Run the following command in the project root directory to download the required dependencies:

bash
Copy code
mvn clean install
Configuration:

Ensure that you have the necessary authentication details in the src/main/resources/auth.txt file.
Update the invite and workspace JSON files (invite.txt and workspace.txt) in the src/main/resources/ directory as needed.
Running Tests
To execute the tests, use the following command:

bash
Copy code
mvn test
To generate reports after running tests:

bash
Copy code
mvn surefire-report:report
To serve Allure reports (if Allure is set up):

bash
Copy code
allure serve target/surefire-reports/
Directory Structure
css
Copy code
APIAutomation
+-- src
¦   +-- main
¦   ¦   +-- resources
¦   ¦       +-- auth.txt
¦   ¦       +-- invite.txt
¦   ¦       +-- workspace.txt
¦   +-- test
¦       +-- java
¦           +-- Test
¦           ¦   +-- BaseClass.java
¦           ¦   +-- UsersAPI.java
¦           +-- testng.xml
+-- pom.xml
+-- README.md
Dependencies
The project relies on the following dependencies defined in the pom.xml:

RestAssured: For API testing
TestNG: For managing test cases
Hamcrest: For matchers used in assertions
Commons IO: For file handling
Jackson Databind: For JSON processing
Allure: For generating test reports
Ensure to periodically update the dependencies in pom.xml to their latest versions.