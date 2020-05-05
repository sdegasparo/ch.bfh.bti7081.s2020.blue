Social Anxiety Application Source Code
===

# Prerequisites
* Java JDK 11
* Maven version 3.5
* PostgreSQL version 12.1

## Postgresql
The application tries to connect on `localhost:5432` using the `social_anxiety` database.
Grants should be given to the user `social_anxiety` identified by `social_anxiety_password`.

# Running the Application
There are two ways to run the application :  using `mvn spring-boot:run` or by running the `Application` class directly from your IDE.

You can use any IDE of your preference,but we suggest Eclipse or Intellij IDEA.
Below are the configuration details to start the project using a `spring-boot:run` command. Both Eclipse and Intellij IDEA are covered.

## Eclipse
- Right click on a project folder and select `Run As` --> `Maven build..` . After that a configuration window is opened.
- In the window set the value of the **Goals** field to 'spring-boot:run' 
- You can optionally select `Skip tests` checkbox
- All the other settings can be left to default

Once configurations are set clicking `Run` will start the application

## Intellij IDEA
- On the right side of the window, select _Maven_--> Plugins--> `spring-boot` --> `spring-boot:run` goal
- Optionally, you can disable tests by clicking on a `Skip Tests mode` blue button.

Clicking on the green run button will start the application.

After application has started, you can view your it at http://localhost:8080/ in your browser.

If you want to run the application locally in the production mode, use `spring-boot:run -Pproduction` command instead.

# Running Integration Tests
## Backend
Run `mvn verify` to execute Unit and Integration Tests for all backend classes.
