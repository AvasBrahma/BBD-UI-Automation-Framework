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
project-root/

🧪 FeatureFile/            – BDD scenarios (Cucumber feature files)

📜 src/test/java/com/ui/steps/    – Step definitions (BeforeActions.java, CommonUISteps.java)

🎯 src/main/java/com/main/actions/    – Page actions / UI logic (CommonUIActions.java)

🎯 src/main/java/com/main/locators/   – Page locators (CommonLocators.java)

🧰 src/main/java/com/main/utils/      – Utilities (UILogger.java, SeleniumHelper.java, ConfigDetails.java, etc.)

🎯 src/test/java/com/ui/runner/       – Test runners (TestRunner.java, UITestNgExecution.java)

📊 test-output/            – TestNG/Cucumber HTML reports and logs

🗂 ── LocatorTestData.xlsx   – Object locators
      TestData.xlsx          – External test data

⚙️ config.properties       – Framework/environment configuration

⚙️ testng.xml              – TestNG suite configuration

📦 pom.xml                 – Maven project configuration

🔐 .gitignore              – Files to be ignored in version control

📝 .classpath, .project    – Eclipse project metadata (if applicable)



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

