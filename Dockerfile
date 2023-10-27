# Utilisez une image de base
FROM openjdk:8-jdk-alpine

# Exposez un port
EXPOSE 8080
RUN mkdir /app
RUN curl -o /app/achat.jar http://192.168.1.127:8081/	tn/esprit/rh/achat/1.0/achat-1.0.jar
# Copiez les fichiers de votre application dans le conteneur
#ADD target/achat-1.0.jar /app/achat.jar
# Commande d'exécution
CMD ["java", "-jar", "/app/achat.jar"]

