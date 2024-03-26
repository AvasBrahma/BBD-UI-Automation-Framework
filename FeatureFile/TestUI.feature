Feature: Testing UI Automation

@TC_001_Verify_User_Able_To_Login_Successfully
Scenario: Verify User able to login successfully
Given Navigate to the URL "TEST_URL"
And Enter the input text for "Username" as "Avas" in the "Login" Screen
And Enter the input text for "Password" as "Avas" in the "Login" Screen
When Click the button for "Login" in the "Login" Screen

@TC_002_Check_First_Execution
Scenario: CheckUI
Given Navigate to the URL "TEST_URL"
And Enter the input text for "Username" as "Avas" in the "Login" Screen
And Enter the input text for "Password" as "Avas" in the "Login" Screen
When Click the button for "Login" in the "Login" Screen