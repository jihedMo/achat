# Use an official OpenJDK 11 base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Expose port 8080
EXPOSE 8080

# Copy the compiled JAR file into the container
ADD target/achat.jar achat.jar

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "achat.jar"]
