# Use an official Java runtime as a parent image
FROM openjdk:21-jdk-slim
LABEL authors="Aravind"

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
