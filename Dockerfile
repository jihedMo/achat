FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/achat.jar  achat.jar
# ADD target/kaddem.jar /kaddem.jar
 COPY target/achat.jar /achat.jar
ENTRYPOINT ["java", "-jar", "/achat.jar"]
