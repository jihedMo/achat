# Use an appropriate base image (e.g., openjdk:8-jdk-alpine)
FROM openjdk:8-jdk-alpine

# Copy your JAR file into the image
COPY target/achat.jar /achat.jar

# Define the command to run when the container starts
ENTRYPOINT ["java", "-jar", "/achat.jar"]
