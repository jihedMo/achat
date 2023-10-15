FROM gamrabenmarzouka1/gamrabenmarzouka_5sleam1

EXPOSE 8083

COPY target/achat.jar /achat.jar

ENTRYPOINT ["java", "-jar", "/achat.jar"]

