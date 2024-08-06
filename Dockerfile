# Use a base image that matches your Java version
FROM eclipse-temurin:21

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/dovedispatch-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
