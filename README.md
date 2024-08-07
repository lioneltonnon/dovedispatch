# Messaging App

This is a Spring Boot application that demonstratest a simple implementation of a Producer Consumer problem.
In it, a Sender service and a Receiver service communicate via a shared RabbitMQ queue.

## Prerequisites

- Java 21 or higher
- Maven 3.9.8 or higher
- RabbitMQ Service

## Building the Application

To build the application, clone the repo, then run the following command in the project root:

```shell
mvn clean package
```

After building, start the RabbitMQ Service, then run the application with the following command:

```shell
java -jar target/dove-dispatch-0.0.1.jar
```

The application will start and be accessible at http://localhost:8080.
