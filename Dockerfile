# Use official OpenJDK base image
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml .

# Download dependencies (use Maven wrapper or install Maven globally)
RUN mvn dependency:go-offline

# Copy the whole project
COPY . .

# Package the application into a JAR file
RUN mvn clean package -DskipTests

# Set the entry point to run the Spring Boot JAR file
ENTRYPOINT ["java", "-jar", "/app/target/user-api.jar"]

# Expose the port on which the app will run
EXPOSE 8080
