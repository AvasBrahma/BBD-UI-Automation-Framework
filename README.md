🚀 Selenium BDD Automation Framework

🧰 Tech Stack
Language: Java
Automation Tool: Selenium WebDriver
BDD Framework: Cucumber
Test Runner: TestNG
Build Tool: Maven
Logging: Custom logger (UILogger.java)
Excel Handling: Apache POI for .xlsx file reading
Design Pattern: Page Object Model (POM)

📁 Project Structure
```bash
├── FeatureFile/              # Contains Cucumber feature files
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── main/
│                   ├── actions/         # UI actions (CommonUIActions.java)
│                   ├── locators/        # Page element locators (CommonLocators.java)
│                   └── utils/           # Utility classes (UILogger.java, SeleniumHelper.java, etc.)
│   └── test/
│       └── java/
│           └── com/
│               └── ui/
│                   ├── runner/          # Test runner classes (TestRunner.java, UITestNgExecution.java)
│                   └── steps/           # Step definitions (BeforeActions.java, CommonUISteps.java)
├── test-output/              # TestNG output and logs
├── target/                   # Compiled output
├── LocatorTestData.xlsx      # Excel file for locators
├── TestData.xlsx             # Excel file for input test data
├── config.properties         # Global configuration
├── testng.xml                # TestNG suite configuration
├── pom.xml                   # Maven project description



🧪 How to Execute
Prerequisites:
Java JDK 11+
Maven 3+
IntelliJ IDEA / Eclipse

Steps to Run:
Clone the repository.
Import it as a Maven project.
Update test data/config as needed.

Run tests using:
maven or run as javaapplication or by using testng.xml

✅ Features
Cucumber + Gherkin for BDD
TestNG execution & report generation
Excel-driven test data
Centralized config & environment handling
UI logging with UILogger.java
Clean modular code using Page Object Model

📊 Reports & Logs
Test results: test-output/
Custom logging: generated through UILogger.java
Optionally extendable with Allure or Extent reports

🧹 Future Enhancements
CI/CD Integration (e.g., Jenkins, GitHub Actions)
Allure/Extent report integration

