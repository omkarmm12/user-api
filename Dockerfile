# Use Maven image with OpenJDK 17 as base image for building the project
FROM maven:3.8.6-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and install dependencies first to take advantage of Docker cache
COPY pom.xml .

# Install dependencies (go-offline command)
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY . .

# Build the application (creates the JAR file)
RUN mvn clean package -DskipTests

# Use a smaller image (with only JDK) to run the application
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous image
COPY --from=build /app/target/user-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app will run on
EXPOSE 8080

# Command to run the JAR file after it's built
CMD ["java", "-jar", "app.jar"]
