# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and install dependencies first to take advantage of Docker cache
COPY pom.xml .

# Install dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY . .

# Run the Maven build to create the .jar file
RUN mvn clean package

# Expose the port your app will run on
EXPOSE 8080

# Command to run the JAR file after it's built
CMD ["java", "-jar", "target/user-api-0.0.1-SNAPSHOT.jar"]


