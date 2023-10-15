FROM gamrabenmarzouka1/gamrabenmarzouka_5sleam1

EXPOSE 8083

# Copie du fichier JAR dans le répertoire racine de l'image
COPY target/achat.jar /achat.jar

ENTRYPOINT ["java", "-jar", "/achat.jar"]
