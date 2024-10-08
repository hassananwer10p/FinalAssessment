Automation Framework for Selenium WebDriver
Overview
This project is a Selenium-based test automation framework designed to run automated tests for web application "respond.io" using various browsers like Chrome, Firefox, and IE. It leverages TestNG for test management, ExtentReports for generating detailed test reports, and WebDriver for browser automation.

Key Components
MainClass: Contains core functionality and setup required for the framework, such as WebDriver initialization and configuration settings.

POM (Page Object Model): Encapsulates all page-related methods and objects, helping separate test logic from page interaction logic.

Test Cases: Contains the actual test cases that use the POM for performing actions on the web application.

ExtentReports: A reporting utility integrated with the framework to produce detailed, interactive reports.

Listeners: Implements ITestListener and manages test events such as onTestStart, onTestSuccess, and onTestFailure.


Prerequisites
Java 8 or above
Maven for dependency management
Selenium WebDriver (ChromeDriver, IEDriver, etc.)
TestNG for managing test execution
ExtentReports for generating reports
Ensure you have the following dependencies listed in your pom.xml file:

POM.xml file 

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>3.141.59</version>
    </dependency>
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>htmlunit-driver</artifactId>
      <version>2.33.2</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.12.1</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.12.1</version>
    </dependency>

    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-server</artifactId>
      <version>3.141.59</version>
    </dependency>

    <dependency>
      <groupId>com.relevantcodes</groupId>
      <artifactId>extentreports</artifactId>
      <version>2.41.2</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
    <dependency>
      <groupId>com.aventstack</groupId>
      <artifactId>extentreports</artifactId>
      <version>4.0.9</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->

    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-firefox-driver</artifactId>
      <version>3.141.59</version>
    </dependency>

      <!-- https://mvnrepository.com/artifact/org.testng/testng -->
      <dependency>
          <groupId>org.testng</groupId>
          <artifactId>testng</artifactId>
          <version>7.0.0</version>
          <scope>test</scope>
      </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-edge-driver -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-edge-driver</artifactId>
      <version>4.0.0-alpha-3</version>
    </dependency>


    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-ie-driver -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-ie-driver</artifactId>
      <version>4.0.0-alpha-3</version>
    </dependency>


    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-api</artifactId>
      <version>3.141.5</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-chrome-driver</artifactId>
      <version>3.12.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-support</artifactId>
      <version>3.12.0</version>
    </dependency>

  </dependencies>

Project Structure


|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- MainClass
|   |   |   |-- POM
|   |   |   |-- utils
|   |   |-- resources
|   |       |-- ConfigProperties
|   |       |-- Drivers
|   |-- test
|       |-- java
|           |-- TestCases
|-- ExtentReports
|-- target
|-- pom.xml

MainClass: 
Core setup and configuration classes for WebDriver.

POM: Page Object Model classes encapsulating web page elements and their associated actions.

Utils: 
Utility classes such as listeners and helpers for the framework.

Test Cases: 
Contains test classes that include actual test scripts.

ExtentReports: 
Contains configuration for ExtentReports.

Drivers: 
Location where browser drivers (e.g., chromedriver, IEDriverServer) are stored.

TestNG.xml: 
The test suite configuration file.



Configuration:

WebDriver Setup
WebDriver binaries (chromedriver.exe, IEDriverServer.exe, etc.) are located in the Drivers folder. These drivers are necessary for running tests in different browsers.

Generating Reports
The framework uses ExtentReports for detailed test reporting. After running the tests, a report is generated in the ExtentReports folder.

To view the report, open index.html in the ExtentReports folder.


Conclusion
This framework provides a solid base for scalable and maintainable automation testing. By following the Page Object Model (POM) pattern, test cases are made modular and reusable. Additionally, the integration with ExtentReports gives insightful results for each test execution.

