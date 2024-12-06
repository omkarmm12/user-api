# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set a working directory
WORKDIR /app

# Add the JAR file (replace with your actual file name)
COPY target/user-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Define the entry point
ENTRYPOINT ["java", "-jar", "/app.jar"]

