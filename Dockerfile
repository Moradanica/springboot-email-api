# Use a lightweight Java runtime
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy Maven build files
COPY pom.xml .
COPY src ./src

# Build the project inside the container
RUN apt-get update && apt-get install -y maven \
    && mvn clean package -DskipTests

# Copy the JAR
COPY target/springboot-email-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot will run on
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]