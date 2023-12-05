FROM openjdk:8-jdk-alpine
EXPOSE 9100
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","/achat-1.0.jar"]
