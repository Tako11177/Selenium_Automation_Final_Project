# **POM Selenium Test Automation Framework**

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-green)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-orange)
![License](https://img.shields.io/badge/License-MIT-brightgreen)

---

## **📌 Description**
This project is a **Selenium Test Automation Framework** based on the **Page Object Model (POM)** design pattern.  
For testing purposes, the selected website is:  
🔗 [**Gorgia.ge**](https://gorgia.ge/ka)

---

## **✨ Features**
- ✅ **Page Object Model (POM)** design pattern  
- ✅ **TestNG** for test execution and reporting  
- ✅ **ExtentReports** for detailed HTML reports  
- ✅ **ConfigReader** for dynamic configuration handling  
- ✅ **DriverManager** for browser session management  
- ✅ **API Testing** with **REST Assured**  

---

## **🛠 Tech Stack**
- **Java**: `11+` (Tested on Java `24`)  
- **Selenium WebDriver**  
- **TestNG**  
- **Maven**: `3.6+` (Tested on `3.9.10`)  
- **ExtentReports**  
- **PageFactory**  

---

## **✅ Prerequisites**
Before running the project, ensure you have:  
- ☕ **Java 11 or higher** (Installed: `Java 24`)  
- 📦 **Maven 3.6 or higher** (Installed: `Maven 3.9.10`)  
- 💻 **IntelliJ IDEA** or any Java-supported IDE  
- 🌐 **Chrome browser** (or your preferred browser)  

---

## **📦 Dependencies & Versions**
| **Dependency**             | **Version**    |
|----------------------------|---------------|
| **Selenium Java**         | 4.23.0       |
| **ExtentReports**         | 5.1.2        |
| **TestNG**                | 7.9.0        |
| **WebDriverManager**      | 6.2.0        |
| **RestAssured**           | 5.5.0        |
| **Maven Surefire Plugin** | 3.2.5        |

---

## **🧪 Implemented Tests**

### **UI Tests**
- ✅ **Verify Home Page search functionality**:  
  User can open the Home Page, type a valid product (e.g., *pouf chair*), and click **Search**.
- ✅ **Verify search bar reset and new search**:  
  Clear the search bar, type another valid product, and click **Search**.
- ✅ **Verify login with valid credentials**:  
  Authenticated user can successfully log in with correct credentials.
- ✅ **Verify catalog browsing**:  
  Authorized user can browse the catalog (including scrolling down and up).
- ✅ **Verify logout functionality**:  
  User can log out successfully using **assertions**.

### **API Tests**
- ✅ **Verify GET request**:  
  Returns status code **200 OK**.

---

## **📂 Project Structure**
```plaintext
├── .idea                # IntelliJ IDEA configuration files
├── reports              # ExtentReport output
├── src
│   ├── main
│   │   ├── java/org/example
│   │   │   ├── config       # ConfigReader
│   │   │   ├── pages        # Page Objects (HomePage, SearchPage, etc.)
│   │   │   ├── utils        # Utility classes (DriverManager, ExtentReportManager)
│   │   └── resources        # config.properties
│   └── test/java/org/example/tests
│       ├── api              # API tests
│       ├── BaseTest.java
│       ├── HomePageTest.java
├── pom.xml                  # Maven dependencies
├── testng.xml               # TestNG configuration
└── README.md
