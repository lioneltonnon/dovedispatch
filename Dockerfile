# Use a base image that matches your Java version
FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/dovedispatch-0.0.1-SNAPSHOT.jar app.jar


# Copy the wait-for-it script into the container
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Expose the application port
EXPOSE 8080

# Use the wait-for-it script to delay the start of the application
ENTRYPOINT ["java", "-jar", "app.jar"]
