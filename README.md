# Marvel-Character-APIRestFul

Marvel Character RestAPI that utilizes a JAR dependency to consume Marvel APIs. It also exposes an endpoint to query the record of service usage.

# Code Analysis

### Prerequisites 📋

You need to have installed:
* Eclipse or your favorite IDE
* Maven
* Java 21
* Lombok

### Installation 🔧

The project is generated and compiled using Maven. The project packaging is WAR.

```
mvn clean install
```

## Built with 🛠️

* Spring Boot 3.3.2
* Java 21
* Maven
* IntelliJ IDEA
* Lombok 1.18.30
* ModelMapper 3.2.0
* jackson-core 2.17.3
* jackson-databind
* commons-lang3 3.12.0

## Database

* H2 (embedded)

The database resets every time the Spring context is restarted. It does not persist stored data, meaning that all data is erased each time the server restarts.

## Unit Tests 📄

* JUnit
* Mockito

Note: The dependency used for testing is `spring-boot-starter-test` - 3.3.2.

## Versioning 📌

Version control is managed with [GitHub].

## Author ✒️

* **[Aaron Quiñonez](aaronqudf@gmail.com)** - *JAVA SR DEVELOPER*  