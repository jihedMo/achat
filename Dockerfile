FROM openjdk:8-jdk-alpine
EXPOSE 8083
COPY target/achat.jar /achat.jar
ENTRYPOINT ["java", "-jar", "/achat.jar"]


