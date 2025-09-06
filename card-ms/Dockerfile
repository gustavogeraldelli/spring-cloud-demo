FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ARG RABBITMQ_HOST=localhost
ARG EUREKA_SERVER=eureka
ARG ADMIN_USERNAME=adm
ARG ADMIN_PASSWORD=adm

ENTRYPOINT ["java", "-jar", "app.jar"]