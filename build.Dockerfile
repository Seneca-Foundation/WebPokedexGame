FROM openjdk:11-slim
EXPOSE 80
ENTRYPOINT [ "java", "-jar", "app.jar" ]
