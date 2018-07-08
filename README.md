This application is built using Spring Boot, JPA and a MySQL database for storage.

Prerequisites to run the application:
1. Java version 8. (May have issues with v-9)
2. MySQL server

Built using Eclipse. Can also be run on Intellij. Must have Maven installed.

Before running:
1. There are 2 tables being used in this application: 
	Person - (person_name (PK), voting_time in milliseconds)
	VideoGames - (game_name(PK), no_of_votes)

2. It would be better if these two tables were initialized (before running the application) in the database with a couple of entries - as the application.properties file contains spring.boot variables initialsed accordingly. I've attached a .sql file to create these tables.

3. Once the database and tables have been created; the application can be imported into Eclipse. Right click on the pom.xml file and run maven clean and maven install.

4. Run the Project as a Java application. Open "localhost:8080" on the web-browser - preferrably chrome.
	
