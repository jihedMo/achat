<<<<<<< HEAD
=======
# Use an official OpenJDK 11 base image
>>>>>>> 23d2ea4cd062f06781c15ed0cb5aae24857df672
# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/achat.jar /app/achat.jar

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run your application
<<<<<<< HEAD
CMD ["java", "-jar", "achat.jar"]
=======
CMD ["java", "-jar", "achat.jar"]
>>>>>>> 23d2ea4cd062f06781c15ed0cb5aae24857df672
