# Automation-Projects

Project: CompareMovies
This is a simple Selenium project to compare the movie details on Wikipedia page and IMDB.
The project compares if the Release Date and the Origin of country is matching on both the websites or not.

The project is generic in nature where you can configure the browser to be used, URL of wiki & IMDB home page and the movie to be compared.
The configuration can be done in config.properties available at "src\main\java\com\movie\compare\config"

The project uses Selenium, Maven & TestNG

How to run the project:
1. Make sure you have Maven configured in your system
2. Download the CompareMovies project
3. Open command prompt and navigate to CompareMovies project
4. Execute mvn clean
5. Execute mvn test

This is start the test execution and the report will be generated in target folder.
