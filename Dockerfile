# Use a lightweight OpenJDK base image for Java 17 
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from local machine to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (the port your app runs on)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

