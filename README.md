# Messaging App

This is a Spring Boot application that demonstratest a simple implementation of a Producer Consumer problem.
In it, a Sender service and a Receiver service communicate via a shared RabbitMQ queue.

## Prerequisites

- Docker
- Docker-compose
## Running the Application

First, clone the repo to your local machine, and go into the repo directory:
```shell
git clone https://github.com/your-username/dovedispatch.git
cd dovedispatch
```

 then run the following command in the project root:

```shell
docker-compose up
```

## Access the Application

RabbitMQ Management UI: Visit http://localhost:15672 to access the RabbitMQ Management UI. Log in with the following credentials:

## Stopping the Application

To stop the application, run the following command:

```shell
docker-compose up
```
