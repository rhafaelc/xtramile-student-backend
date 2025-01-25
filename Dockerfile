# Use an official Maven image as the base image
FROM maven:3.9.8-eclipse-temurin-21 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and the project files to the container
COPY pom.xml .
RUN mvn dependency:go-offline


# Build the application using Maven
COPY src ./src
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as the base image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous stage to the container
COPY --from=build /app/target/student-crud-0.0.1-SNAPSHOT.jar .
# Expose the port the app runs on
EXPOSE 8080

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "/app/student-crud-0.0.1-SNAPSHOT.jar"]
