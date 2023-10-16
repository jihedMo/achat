# Use an official OpenJDK 11 base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/your-application.jar /app/your-application.jar

# Specify the command to run your application
CMD ["java", "-jar", "your-application.jar"]
