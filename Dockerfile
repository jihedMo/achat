FROM openjdk:8-jdk-alpine

# Exposez un port
EXPOSE 8080

# Copiez les fichiers de votre application dans le conteneur
ADD target/achat.jar /app/achat.jar

CMD ["java", "-jar", "/app/achat.jar"]
