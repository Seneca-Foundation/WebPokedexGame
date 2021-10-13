FROM maven:3.8.1-openjdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B clean package --file pom.xml

FROM openjdk:11-slim
COPY --from=build /workspace/target/*jar app.jar
EXPOSE 80
ENTRYPOINT [ "java", "-jar", "app.jar" ]