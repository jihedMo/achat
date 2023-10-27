# Utilisez une image de base
FROM openjdk:8-jdk-alpine

# Exposez un port
EXPOSE 8080
RUN mkdir /app

# Utilisez curl pour télécharger le fichier JAR depuis Nexus
RUN curl -o /app/achat.jar http://192.168.1.127:8081/tn/esprit/rh/achat/1.0/achat-1.0.jar

# Commande d'exécution
CMD ["java", "-jar", "/app/achat.jar"]



