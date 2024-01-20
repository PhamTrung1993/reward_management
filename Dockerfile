#syntax=docker/dockerfile:1;
FROM openjdk:11.0.16-jdk
WORKDIR application
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]