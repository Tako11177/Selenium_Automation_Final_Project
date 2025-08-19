POM Selenium Test Automation Framework


Description:


This project is a Selenium Test Automation Framework based on the Page Object Model (POM) design pattern. For testing purposes, I selected the website: https://gorgia.ge/ka



Features:


Page Object Model (POM) - design pattern

TestNG - for test execution and reporting

ExtentReports - for detailed HTML reports

ConfigReader - for dynamic configuration handling

DriverManage - for browser session management

API Testing - (REST Assured)



Tech Stack:


Java 11+ (Tested on Java 24)

Selenium WebDriver



TestNG:

Maven 3.6+ (Tested on Maven 3.9.10)

ExtentReports

PageFactory



Prerequisites:


Before running the project, make sure you have:

Java 11 or higher (Installed: Java 24)

Maven 3.6 or higher (Installed: Maven 3.9.10)

IntelliJ IDEA or any Java-supported IDE

Chrome browser (or the one you want to test on)



Dependencies & Versions:


Selenium Java: 4.23.0

ExtentReports: 5.1.2

TestNG: 7.9.0

WebDriverManager: 6.2.0

RestAssured: 5.5.0

Maven Surefire Plugin: 3.2.5



Implemented Tests:



UI Tests:


Verify Home Page search functionality:

User can open the Home Page, type a valid product (e.g., pouf chair), and click Search.

Verify search bar reset and new search:

Clean the search bar, type another valid product, and click Search.

Verify login with valid credentials:

Authenticated user can successfully log in with correct credentials.

Verify catalog browsing:

Authorized user can browse the catalog (including scrolling down and up).

Verify logout functionality:

User can log out successfully using assertion.




API Tests:


Verify GET request:

Returns status code 200 OK.

Verify logout functionality:

User can log out successfully using assertion.

API Tests
Verify GET request:
Returns status code 200 OK.
