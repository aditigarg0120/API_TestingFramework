# API_TestingFramework
This Repository is related to testing API services in Rest ASSURED
@Author- Aditi Garg

# Required software
Java JDK 11+
Maven installed and in your classpath
API https://api.spacexdata.com/v4/launches/latest

# How to execute the tests
We can follow two different steps:
Approach 1 - Download and Import project in IntelliJ
1. Open IntelliJ
2. Import project
3. Build Project
4. Run Maven Clean, Install and Test

Approach 2 - Using Zip and command line
1. Download Zip 
2. Unzipped project
3. Go to project location using terminal
4. run commands 
 a) mvn clean
 b) mvn test
 
 
# Generating the test report
This project is using Allure Report to automatically generate test report
Command line to generate it in two ways:
1. mvn allure:serve: To open report in browser
2. mvn allure:report: To generate project report at target/site/allure-maven-plugin folder

Sample Report


# Inside API Testing Framework:
src/test/java
This folder contains 4 packages
1. common
2. runners
3. stepDef
4. utilities

src/test/resources
1. features
2. allure.properties

# Patterns applied
1. Builder
2. Base Test

<img width="1339" alt="APIs" src="https://user-images.githubusercontent.com/43905401/146693395-fba8ab8c-3bf3-4d9c-b83e-725273706076.png">

