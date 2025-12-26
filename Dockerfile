# --- Build Stage ---
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline
# Copy the rest of the source code
COPY src ./src
# Build the application (clean package creates the JAR in the target directory)
RUN mvn clean package -DskipTests

# --- Package Stage ---
# Use a smaller base image that only has the Java Runtime Environment (JRE)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copy the JAR file from the 'build' stage to the new stage
COPY --from=build /app/target/*.jar app.jar
# Expose the port your application runs on (commonly 8080 for Spring Boot)
EXPOSE 8080
# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
