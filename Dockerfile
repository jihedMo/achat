FROM gamrabenmarzouka1/gamrabenmarzouka_5sleam1

EXPOSE 8083

# Copie du fichier JAR depuis le sous-répertoire target
COPY target/achat.jar /achat.jar

ENTRYPOINT ["java", "-jar", "/achat.jar"]

