FROM openjdk:11-jdk-slim

WORKDIR /app

RUN ls -l /app

COPY target/achat.jar /app/achat.jar

EXPOSE 8080

CMD ["java", "-jar", "achat.jar"]
